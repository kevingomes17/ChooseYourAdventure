/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
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
    
    public Collection<Attraction> getAttractions(String cityId) {
        try {
            TypedQuery<City> cityQuery = em.createNamedQuery("City.findById", City.class);
            cityQuery.setParameter("id", new BigDecimal(cityId));                
            City cityObj = cityQuery.getSingleResult();
            Collection<Attraction> attList = cityObj.getAttractionCollection();             
            return attList;
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<Attraction>();
        }
    }
    
    
    public List<Packages> getPackages() {
        try {
            TypedQuery<Packages> query = em.createNamedQuery("Packages.findAll", Packages.class);
            List<Packages> pkgList = query.getResultList();
            return pkgList;
        } catch(Exception e) {
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
        } catch(Exception e) {
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
        } catch(Exception e) {
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
