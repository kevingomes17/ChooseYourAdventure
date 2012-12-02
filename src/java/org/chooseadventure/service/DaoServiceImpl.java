/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kevingomes17
 */
@Transactional
public class DaoServiceImpl implements DaoService {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public <T> Boolean insert(T object) {
        try {
            em.persist(object);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Transactional
    public <T> Boolean update(T object) {
        try {
            em.merge(object);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
