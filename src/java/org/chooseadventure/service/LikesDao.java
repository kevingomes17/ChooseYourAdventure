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
import org.chooseadventure.utils.AppConstants;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class LikesDao extends BaseDao {

    public int getLikesForAttaction(String attId) {
        try {
            TypedQuery<Likes> likesQuery = em.createNamedQuery("Likes.findPerContentType", Likes.class);
            int attraction = Integer.valueOf(attId);
            likesQuery.setParameter("foreignid", attraction);
            likesQuery.setParameter("contenttype", AppConstants.attContentType);
            likesQuery.setParameter("likeordislike", new BigDecimal(AppConstants.like));
            List<Likes> attLikes = likesQuery.getResultList();

            System.out.println("Likes for attraction" + attLikes.size());
            return attLikes.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public boolean likeAttaction(String attId) {
        try {
            Date date = new Date();

            Likes like = new Likes();
            like.setContenttype(AppConstants.attContentType);
            like.setLikeordislike(new BigInteger(String.valueOf(AppConstants.like)));
            like.setForeignid(Integer.parseInt(attId));
            like.setModifiedon(date);
            like.setCreatedon(date);
            return daoService.insert(like);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getDislikesForAttaction(String attId) {
        try {
            TypedQuery<Likes> likesQuery = em.createNamedQuery("Likes.findPerContentType", Likes.class);
            int attraction = Integer.valueOf(attId);
            likesQuery.setParameter("foreignid", attraction);
            likesQuery.setParameter("contenttype", AppConstants.attContentType);
            likesQuery.setParameter("likeordislike", new BigDecimal(AppConstants.dislike));
            List<Likes> attLikes = likesQuery.getResultList();
            return attLikes.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public boolean dislikeAttaction(String attId) {
        try {
            Date date = new Date();

            Likes like = new Likes();
            like.setContenttype(AppConstants.attContentType);
            like.setLikeordislike(new BigInteger(String.valueOf(AppConstants.dislike)));
            like.setForeignid(Integer.parseInt(attId));
            like.setModifiedon(date);
            like.setCreatedon(date);
            return daoService.insert(like);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getLikesForTopic(String topicId) {
        try {
            TypedQuery<Likes> likesQuery = em.createNamedQuery("Likes.findPerContentType", Likes.class);
            int topic = Integer.valueOf(topicId);
            likesQuery.setParameter("foreignid", topic);
            likesQuery.setParameter("contenttype", AppConstants.topicContentType);
            likesQuery.setParameter("likeordislike", new BigDecimal(AppConstants.like));
            List<Likes> topicLikes = likesQuery.getResultList();

            System.out.println("Likes for Topic " + topicLikes.size());
            return topicLikes.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
    
        public int getDislikesForTopic(String topicId) {
        try {
            TypedQuery<Likes> likesQuery = em.createNamedQuery("Likes.findPerContentType", Likes.class);
            int topic = Integer.valueOf(topicId);
            likesQuery.setParameter("foreignid", topic);
            likesQuery.setParameter("contenttype", AppConstants.topicContentType);
            likesQuery.setParameter("likeordislike", new BigDecimal(AppConstants.dislike));
            List<Likes> attLikes = likesQuery.getResultList();
            return attLikes.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public boolean likeTopic(String topicId) {
        try {
            Date date = new Date();

            Likes like = new Likes();
            like.setContenttype(AppConstants.topicContentType);
            like.setForeignid(Integer.parseInt(topicId));
            like.setLikeordislike(new BigInteger(String.valueOf(AppConstants.like)));
            like.setModifiedon(date);
            like.setCreatedon(date);
            return daoService.insert(like);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public boolean dislikeTopic(String topicId) {
        try {
            Date date = new Date();

            Likes like = new Likes();
            like.setContenttype(AppConstants.topicContentType);
            like.setForeignid(Integer.parseInt(topicId));
            like.setLikeordislike(new BigInteger(String.valueOf(AppConstants.dislike)));
            like.setModifiedon(date);
            like.setCreatedon(date);
            return daoService.insert(like);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    

    
}
