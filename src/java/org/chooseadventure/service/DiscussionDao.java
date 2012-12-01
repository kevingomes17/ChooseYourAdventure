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
import javax.persistence.TemporalType;


import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class DiscussionDao extends BaseDao {

    //get all Discussion topics for attraction
    public List<Discussiontopic> getDiscussionTopicsbyAtt(String attractionId) {
        try {
            //get discussion topics by attraction
            TypedQuery<Discussiontopicbyattraction> dTopicByAttQuery = em.createNamedQuery("Discussiontopicbyattraction.findByAttractionid", Discussiontopicbyattraction.class);
            dTopicByAttQuery.setParameter("attractionid", new BigDecimal(attractionId));
            List<Discussiontopicbyattraction> dTopicsByAtt = dTopicByAttQuery.getResultList();
            
            //get discussion topic in each Discussiontopicbyattraction and add to list
            List<Discussiontopic> dTopic = new ArrayList< Discussiontopic>();

            if (dTopicsByAtt.size() > 0) {
                for (int i = 0; i < dTopicsByAtt.size(); i++) {
                    dTopic.add(dTopicsByAtt.get(i).getDiscussiontopic());
                }
            }
            //return list
            return dTopic;    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
