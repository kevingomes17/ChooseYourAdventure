/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.chooseadventure.service.*;
import org.chooseadventure.entity.*;
import org.chooseadventure.utils.Utils;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author root
 */
@Controller
public class DiscussionController  extends BaseController{
    @Autowired
    private DiscussionDao discussionDao;
    
    @RequestMapping(value="/attraction_topics", method= RequestMethod.GET)
    public String dTopicsByAttractionView(HttpServletRequest request, HttpServletResponse response, Model model){
        
        //take city from request pass as paremeter
        String atractionid = request.getParameter("attraction");
        
        List<Discussiontopic> dTopics = discussionDao.getDiscussionTopicsbyAtt(atractionid);
        System.out.println("topic list size = " + dTopics.size());
        model.addAttribute("discussionTopics", dTopics);
        model.addAttribute("Filename", "attraction_topics.jsp");
        
        return TemplateSubForm;
    }
}
