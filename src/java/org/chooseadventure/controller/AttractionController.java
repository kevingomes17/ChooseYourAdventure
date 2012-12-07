/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
 * @author kevingomes17
 */
@Controller
public class AttractionController extends BaseController {
    @Autowired
    private AttractionDao attractionDao;    
    
    @Autowired
    private DiscussionDao discussionDao;  
    
     @Autowired
    private LikesDao likesDao; 
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
        if("POST".equals(request.getMethod())) {
            //userDao.add();            
        } 
        
        List<City> cities = attractionDao.getCities();
        model.addAttribute("cities", cities);
        
        //List<Attraction> attList = attractionDao.getAttractions();
        //model.addAttribute("attractions", attList);
        
        List<Packages> pkgList = attractionDao.getPackages();
        model.addAttribute("packages", pkgList);
        
        setModelParameters(request, model, "choose_attraction.jsp", "Choose Attraction/Package");
        return TemplateFile;
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String home_submitHandler(HttpServletRequest request, HttpServletResponse response, Model model) {
        String attId = Utils.GetValIfNull(request.getParameter("attraction"), "0");
        String pkgId = Utils.GetValIfNull(request.getParameter("package"), "0");
        
        if(!"0".equals(attId)) { //Display attraction landing page
            Attraction attObj = attractionDao.getAttraction(attId);
            model.addAttribute("attraction", attObj);
            
            List<Discussiontopic> disList = discussionDao.getDiscussionTopicsbyAtt(attId);
            model.addAttribute("discussions", disList);
            
            HashMap<String,Collection<Discussionthread>> dThreads = new HashMap<String,Collection<Discussionthread>>();
            HashMap<String,Integer> topicLikes = new HashMap<String,Integer>();
            HashMap<String,Integer> topicDislikes = new HashMap<String,Integer>();
            HashMap<String,Integer> threadLikes = new HashMap<String,Integer>();
            HashMap<String,Integer> threadDislikes = new HashMap<String,Integer>();
            
            Iterator ditr = disList.iterator();
            while(ditr.hasNext()) {
                Discussiontopic dobj = (Discussiontopic) ditr.next();
                dThreads.put(dobj.getId().toString(),dobj.getDiscussionthreadCollection());
                topicLikes.put(dobj.getId().toString(), likesDao.getLikesForTopic(dobj.getId().toString()));
                topicDislikes.put(dobj.getId().toString(), likesDao.getDislikesForTopic(dobj.getId().toString()));
            }
            
            int attLikes = likesDao.getLikesForAttaction(attId);
            int attDislikes = likesDao.getDislikesForAttaction(attId);
            
            model.addAttribute("attlikescount", attLikes);
            model.addAttribute("attdislikescount", attDislikes);
            model.addAttribute("dThreads", dThreads);
            model.addAttribute("topicLikes", topicLikes);
            model.addAttribute("topicDislikes", topicDislikes);
            
            
            setModelParameters(request, model, "attraction_view.jsp", "Attraction: "+attObj.getName());
        } else {
            model.addAttribute("package", attractionDao.getPackage(pkgId));
            setModelParameters(request, model, "package_view.jsp", "View Package");
        }
        return TemplateFile;
    }
    
    @RequestMapping(value = "/package-view", method = RequestMethod.GET)
    public String packageView(HttpServletRequest request, HttpServletResponse response, Model model) {
        String pkgId = Utils.GetValIfNull(request.getParameter("package"), "0");
        
        model.addAttribute("package", attractionDao.getPackage(pkgId));
        setModelParameters(request, model, "package_view.jsp", "View Package");
        
        return TemplateFile;
    }
    
    @RequestMapping(value = "/attraction-comments")
    public String attractionComments(HttpServletRequest request, HttpServletResponse response, Model model) {
//        String attId = Utils.GetValIfNull(request.getParameter("attractionId"), "0");
//        String topicId = Utils.GetValIfNull(request.getParameter("topicId"), "0");
        String threadId = Utils.GetValIfNull(request.getParameter("threadId"), "0");
        
        List<Discussionthreadcomment> comments = discussionDao.getCommentsFromThread( threadId);
        HashMap<String,Integer> commentDislikes = new HashMap<String,Integer>();
        HashMap<String,Integer> commentLikes = new HashMap<String,Integer>();
        
        Iterator citor = comments.iterator();
        while (citor.hasNext()){
            Discussionthreadcomment comm = (Discussionthreadcomment)citor.next();
            commentLikes.put(comm.getId().toString(), likesDao.getLikesForComment(comm.getId().toString()));
            commentDislikes.put(comm.getId().toString(), likesDao.getDislikesForComment(comm.getId().toString()));   
        }
        
        model.addAttribute("commentlikes", commentLikes);
        model.addAttribute("commentdislikes", commentDislikes);
        model.addAttribute("comments", comments);
        model.addAttribute("threadId", threadId);
        model.addAttribute("Filename", "attraction_comments.jsp");
        setModelParameters(request, model, "attraction_comments.jsp", "Comments");
        return TemplateSubForm;        
    }
    
    @RequestMapping(value = "/attraction-selectbox")
    public String attractionSelectBox(HttpServletRequest request, HttpServletResponse response, Model model) {
        String cityId = Utils.GetValIfNull(request.getParameter("city"), "0");
        
        Collection<Attraction> attList = attractionDao.getAttractions(cityId);
        attList.size();
        model.addAttribute("attractions", attList);
        model.addAttribute("Filename", "attractions_selectbox.jsp");
        
        return TemplateSubForm;
    }
    
    @RequestMapping(value = "/package-selectbox")
    public String packageSelectBox(HttpServletRequest request, HttpServletResponse response, Model model) {
        String cityId = Utils.GetValIfNull(request.getParameter("city"), "0");
        
        Collection<Packages> attList = attractionDao.getPackages(cityId);
        attList.size();
        model.addAttribute("packages", attList);
        model.addAttribute("Filename", "packages_selectbox.jsp");
        
        return TemplateSubForm;
    }


}
