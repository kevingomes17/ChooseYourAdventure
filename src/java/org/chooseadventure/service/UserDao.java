/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
}
