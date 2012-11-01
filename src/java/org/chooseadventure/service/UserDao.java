/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import com.sun.tools.internal.xjc.api.S2JJAXBModel;
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
public class UserDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
    
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
}
