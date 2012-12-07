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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.management.Query;
import javax.persistence.NoResultException;
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
        } catch (Exception e) {
            return null;
        }
    }

    public List<City> getCities() {
        try {
            TypedQuery<City> query = em.createNamedQuery("City.findAll", City.class);
            List<City> cities = query.getResultList();
            return cities;
        } catch (Exception e) {
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
            while (itr.hasNext()) {
                Userphones pobj = (Userphones) itr.next();
                pobj.setPhonenumber(new Long(phones[i]));
                i++;

                daoService.update(pobj);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the list of guest users in the system.
     *
     * @return
     */
    public List<Userwebsite> getGuestUsers() {
        try {
            TypedQuery<Userwebsite> query = em.createNamedQuery("Userwebsite.findAll", Userwebsite.class);
            List<Userwebsite> users = query.getResultList();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Transactioninfo> getTransactions(Userbase user) {
        try {
            TypedQuery<Transactioninfo> query = em.createNamedQuery("Transactioninfo.findByUserId", Transactioninfo.class);
            query.setParameter("userid", user);
            List<Transactioninfo> li = query.getResultList();
            return li;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Transactioninfo>();
        }
    }

    public Useremployee getUserEmployee(BigDecimal uid) {
        try {
            TypedQuery<Useremployee> query = em.createNamedQuery("Useremployee.findByUserid", Useremployee.class);
            query.setParameter("userid", uid);
            Useremployee eobj = query.getSingleResult();
            return eobj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Role getRoleObj(BigDecimal roleId) {
        try {
            TypedQuery<Role> query = em.createNamedQuery("Role.findById", Role.class);
            query.setParameter("id", roleId);
            Role robj = query.getSingleResult();
            return robj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean hasRole(String username, Integer roleId) {
        try {
            Userbase user = getUser(username);
            TypedQuery<Employeerole> query = em.createNamedQuery("Employeerole.findByEmployeeIdRoleId", Employeerole.class);
            query.setParameter("employeeid", user.getId().toBigInteger());
            query.setParameter("roleid", new BigInteger(roleId.toString()));

            Employeerole erObj = query.getSingleResult();
            return true;
        } catch (NoResultException ex1) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean save(String username, HashMap<String, String> ds, String action) {
        try {
            Userbase existingUser = getUser(ds.get("username").toString());
            if (existingUser == null) {
                Userbase currentUser = getUser("username");
                Date date = new Date();
                Userbase user = new Userbase(
                        ds.get("displayName").toString(),
                        ds.get("username").toString(),
                        ds.get("password").toString(),
                        ds.get("address").toString(),
                        ds.get("zipcode").toString(),
                        currentUser.getId().toBigInteger(), date,
                        currentUser.getId().toBigInteger(), date);

                return daoService.insert(user);
            }
            
            //User already exists
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
