/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
public class DiscussionController extends BaseController {

    @Autowired
    private DiscussionDao discussionDao;

    @RequestMapping(value = "/attraction_topics", method = RequestMethod.GET)
    public String dTopicsByAttractionView(HttpServletRequest request, HttpServletResponse response, Model model) {

        //take city from request pass as paremeter
        String atractionid = request.getParameter("attraction");

        List<Discussiontopic> dTopics = discussionDao.getDiscussionTopicsbyAtt(atractionid);
        System.out.println("topic list size = " + dTopics.size());
        model.addAttribute("discussionTopics", dTopics);
        model.addAttribute("Filename", "attraction_topics.jsp");

        return TemplateSubForm;
    }

    @RequestMapping(value = "/new_thread", method = RequestMethod.GET)
    public String insertThread(HttpServletRequest request, HttpServletResponse response, Model model) {
        String topicId = Utils.GetValIfNull(request.getParameter("topicId"), "0");

        model.addAttribute("topicId", topicId);
        setModelParameters(request, model, "new_thread.jsp", "New Thread");

        return TemplateSubForm;
    }

    @RequestMapping(value = "/new_thread", method = RequestMethod.POST)
    public String insertThread_submitHandler(HttpServletRequest request, HttpServletResponse response, Model model) {
        String title = Utils.GetValIfNull(request.getParameter("t_title"), "0");
        String description = Utils.GetValIfNull(request.getParameter("t_description"), "0");
        String topicId = Utils.GetValIfNull(request.getParameter("topicId"), "0");
        String email = request.getUserPrincipal().getName();
        
        HashMap hm = new HashMap();
        hm.put("title", title);
        hm.put("description", description);
        hm.put("topicId", topicId);
        hm.put("user", email);
        
        discussionDao.insertThread(hm);
        
        return null;
    }
}
