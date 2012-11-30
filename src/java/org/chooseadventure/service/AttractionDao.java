/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import java.util.ArrayList;
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
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<City>();
        }
    }
    
    public List<Attraction> getAttractions() {
        try {
            TypedQuery<Attraction> query = em.createNamedQuery("Attraction.findAll", Attraction.class);
            List<Attraction> attList = query.getResultList();
            return attList;
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<Attraction>();
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
