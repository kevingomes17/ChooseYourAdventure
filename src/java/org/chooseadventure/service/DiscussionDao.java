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

    public List<Discussionthread> getDiscussionThreadsFromTopic(String topicId) {
        try {
            TypedQuery<Discussiontopic> dTopics = em.createNamedQuery("Discussiontopic.findById", Discussiontopic.class);
            dTopics.setParameter("topicId", new BigDecimal(topicId));
            Discussiontopic topic = dTopics.getSingleResult();

            List<Discussionthread> threads = (List) topic.getDiscussionthreadCollection();

            return threads;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Discussionthreadcomment> getCommentsFromThread(String threadId) {
        try {
            TypedQuery<Discussionthread> dTthreadQuery = em.createNamedQuery("Discussionthread.findById", Discussionthread.class);
            dTthreadQuery.setParameter("threadId", new BigDecimal(threadId));
            Discussionthread thread = dTthreadQuery.getSingleResult();
            List<Discussionthreadcomment> comments = (List) thread.getDiscussionthreadcommentCollection();
            return comments;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    //new thread
    public Boolean insertThread(HashMap hm) {

        try {
            
            Discussionthread thread = new Discussionthread();

            //get topic
            TypedQuery<Discussiontopic> dtopicQuery = em.createNamedQuery("Discussiontopic.findById", Discussiontopic.class);
            dtopicQuery.setParameter("id", new BigDecimal(hm.get("topicId").toString()));
            Discussiontopic topic = dtopicQuery.getSingleResult();

            Userbase user = getUserObj(hm.get("user").toString());
            
            System.out.println("User name = " + user.getDisplayname());
            
            Date date = new Date();
            thread.setDescription(hm.get("description").toString());
            thread.setTitle(hm.get("title").toString());
            thread.setTopicid(topic);
            thread.setCreatedon(date);
            thread.setModifiedon(date);
            thread.setUserid(user);
            thread.setCreatedby(user.getId().toBigIntegerExact());
            thread.setModifiedby(user.getId().toBigInteger());
            
            return daoService.insert(thread);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
