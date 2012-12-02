/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.chooseadventure.entity.Userbase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kevingomes17
 */
public class BaseDao {
    @PersistenceContext
    protected EntityManager em;
    
    protected DaoService daoService;
    @Autowired
    public void setDaoService(DaoService ds) {
        this.daoService = ds;
    }
    
    public Userbase getUserObj(String email){
        try {
            TypedQuery<Userbase> userQuery= em.createNamedQuery("Userbase.findById", Userbase.class);
            userQuery.setParameter("email", email);
            Userbase user = userQuery.getSingleResult();
            return user;
        } catch (Exception e){
            return null;
        }
        
    }
}
