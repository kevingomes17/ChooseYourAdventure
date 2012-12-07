/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.management.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.chooseadventure.entity.*;
import org.springframework.transaction.annotation.Propagation;
import org.w3c.dom.UserDataHandler;

/**
 *
 * @author kevingomes17
 */
@Service
public class UserDao extends BaseDao {    
    public Userbase getUser(String email) {
        try {
            TypedQuery<Userbase> query = em.createNamedQuery("Userbase.findByEmail", Userbase.class);
            query.setParameter("email", email);
            Userbase user = query.getSingleResult();
            return user;   
        } catch(Exception e) { 
            return null;
        }
    }
    
    public List<City> getCities() {
        try {
            TypedQuery<City> query = em.createNamedQuery("City.findAll", City.class);
            List<City> cities = query.getResultList();
            return cities;
        } catch(Exception e) {
            return new ArrayList<City>();
        }
    }
    
    /**
     * 
     * @param username
     * @param phones
     * @return 
     */
    public Boolean updatePhones(String username, String[] phones) {
        try {
            Userbase user = getUser(username);
            Collection Userphones = user.getUserphonesCollection();
            Iterator itr = Userphones.iterator();
            int i = 0;
            while(itr.hasNext()) {
                Userphones pobj = (Userphones) itr.next();
                pobj.setPhonenumber(new Long(phones[i]));
                i++;
                
                daoService.update(pobj);
            }
            
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the list of guest users in the system.
     * @return 
     */
    public List<Userwebsite> getGuestUsers() {
        try {
            TypedQuery<Userwebsite> query = em.createNamedQuery("Userwebsite.findAll", Userwebsite.class);
            List<Userwebsite> users = query.getResultList();
            return users;
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
