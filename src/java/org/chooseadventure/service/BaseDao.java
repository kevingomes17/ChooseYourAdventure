/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
