/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
//import javax.management.j2ee.statistics.JDBCConnectionPoolStats;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.chooseadventure.entity.*;
import java.util.HashMap;
import java.util.Iterator;
import org.chooseadventure.utils.AppConstants;

/**
 *
 * @author kevingomes17
 */
@Service
public class AttractionDao extends BaseDao {

    public List<City> getCities() {
        try {
            TypedQuery<City> query = em.createNamedQuery("City.findAll", City.class);
            List<City> cities = query.getResultList();
            return cities;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<City>();
        }
    }

    public List<Attraction> getAttractions() {
        try {
            TypedQuery<Attraction> query = em.createNamedQuery("Attraction.findAll", Attraction.class);
            List<Attraction> attList = query.getResultList();
            return attList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Attraction>();
        }
    }

    public Collection<Attraction> getAttractions(String cityId) {
        try {
            TypedQuery<City> cityQuery = em.createNamedQuery("City.findById", City.class);
            cityQuery.setParameter("id", new BigDecimal(cityId));
            City cityObj = cityQuery.getSingleResult();
            Collection<Attraction> attList = cityObj.getAttractionCollection();
            return attList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Attraction>();
        }
    }

    public List<Packages> getPackages() {
        try {
            TypedQuery<Packages> query = em.createNamedQuery("Packages.findAll", Packages.class);
            List<Packages> pkgList = query.getResultList();
            return pkgList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Packages>();
        }
    }

    public List<Packages> getPackages(String cityId) {
        try {
            TypedQuery<Packages> query = em.createNamedQuery("Packages.findByCityId", Packages.class);
            query.setParameter("cityId", new BigDecimal(cityId));
            List<Packages> pkgList = query.getResultList();
            return pkgList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Packages>();
        }
    }

    public Attraction getAttraction(String attId) {
        try {
            TypedQuery<Attraction> query = em.createNamedQuery("Attraction.findById", Attraction.class);
            query.setParameter("id", new BigDecimal(attId));
            Attraction aobj = query.getSingleResult();
            return aobj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Packages getPackage(String pkgId) {
        try {
            TypedQuery<Packages> query = em.createNamedQuery("Packages.findById", Packages.class);
            query.setParameter("id", new BigDecimal(pkgId));
            Packages pobj = query.getSingleResult();
            return pobj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean isTicketAvailable(String attractionId, String numTickets, String dateAvailable) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(AppConstants.dateFormat);
            Date date = format.parse(dateAvailable);

            Attraction aobj = getAttraction(attractionId);
            TypedQuery<Ticketsavailable> query = em.createNamedQuery("Ticketsavailable.findByAttractionIdDateTickets", Ticketsavailable.class);
            query.setParameter("dateavailable", date);
            query.setParameter("remainingtickets", new BigInteger(numTickets));
            query.setParameter("attractionid", aobj);

            List<Ticketsavailable> t = query.getResultList();
            if (t.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param ds - data submitted
     * @return
     */
    public Boolean purchaseAttractionTicket(String username, HashMap<String, String> ds) {
        try {
            Userbase user = getUserObj(username);

            String numTickets = ds.get("numTickets");
            String dateAvailable = ds.get("datAvailable");
            String attractionId = ds.get("attractionId");
            String creditCardNum = ds.get("creditCardNum");
            String creditCardAmount = ds.get("creditCardAmount");
            String rewardPoints = ds.get("rewardPoints");
            String totalAmount = ds.get("totalAmount");

            Attraction aobj = getAttraction(attractionId);
            //Update num tickets available also
            //update payment info

            SimpleDateFormat format = new SimpleDateFormat(AppConstants.dateFormat);
            Date expiresOn = format.parse(dateAvailable);
            Calendar cal = Calendar.getInstance();
            cal.setTime(expiresOn);
            cal.add(Calendar.DATE, 10);
            expiresOn = cal.getTime();

            Date date = new Date();
            
            Transactioninfo tiobj = new Transactioninfo();
            tiobj.setAmount(new BigInteger(totalAmount));
            tiobj.setRewardpointsused(Integer.parseInt(rewardPoints));
            tiobj.setCreditcardamount(new BigDecimal(creditCardAmount));
            tiobj.setCreatedby(user.getId().toBigInteger());
            tiobj.setCreatedon(date);
            tiobj.setModifiedby(user.getId().toBigInteger());
            tiobj.setModifiedon(date);
            tiobj.setUserid(user);
            
            
            Transactionattraction taobj = new Transactionattraction();
            taobj.setTicketcount(new BigInteger(numTickets));
            taobj.setTicketexpirationdate(expiresOn);
            taobj.setCreatedby(user.getId().toBigInteger());
            taobj.setCreatedon(date);
            taobj.setModifiedby(user.getId().toBigInteger());
            taobj.setModifiedon(date);
            taobj.setAttractionid(aobj);
            //taobj.setTransactionid(tiobj);
            
            //ArrayList<Transactionattraction> tacoll = new ArrayList<Transactionattraction>();
            //tacoll.add(taobj);            
            //tiobj.setTransactionattractionCollection(tacoll);
            
            Boolean flag = daoService.insert(tiobj);
            
            if(flag == true) {                
                Query query = em.createNativeQuery("SELECT SEQ_TRANSACTIONINFO_ID.CURRVAL FROM DUAL");
                Object object = query.getSingleResult();
                BigDecimal ti_id = new BigDecimal(object.toString());
                
                tiobj.setId(ti_id);
                taobj.setTransactionid(tiobj);
                daoService.insert(taobj);
                
                Ticketsavailable tavailobj = getTicketsavailableObject(attractionId, numTickets, dateAvailable);
                Integer tickets = Integer.parseInt(tavailobj.getRemainingtickets().toString());
                Integer ntkts = Integer.parseInt(numTickets);
                tickets = tickets - ntkts;
                tavailobj.setRemainingtickets(new BigInteger(tickets.toString()));
                daoService.update(tavailobj);
            }
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Ticketsavailable getTicketsavailableObject(String attractionId, String numTickets, String dateAvailable) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(AppConstants.dateFormat);
            Date date = format.parse(dateAvailable);

            Attraction aobj = getAttraction(attractionId);
            TypedQuery<Ticketsavailable> query = em.createNamedQuery("Ticketsavailable.findByAttractionIdDateTickets", Ticketsavailable.class);
            query.setParameter("dateavailable", date);
            query.setParameter("remainingtickets", new BigInteger(numTickets));
            query.setParameter("attractionid", aobj);

            List<Ticketsavailable> t = query.getResultList();
            Iterator itr = t.iterator();
            return (Ticketsavailable) itr.next();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
     public List<Comments> getComments(Integer attractionId) {
     try {
     TypedQuery<Userbase> query = em.createNamedQuery("Userbase.findByEmail", Userbase.class);
     query.setParameter("email", email);
     Userbase user = query.getSingleResult();
     return user;
     } catch(Exception e) {
     e.printStackTrace();
     return new ArrayList<Comments>();
     }
     }*/
}
