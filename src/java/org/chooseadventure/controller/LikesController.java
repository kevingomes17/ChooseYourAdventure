/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.Produces;
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
public class LikesController extends BaseController{
    
    @Autowired
    private LikesDao likesDao; 
    
    @RequestMapping(value = "/like")
    public String likeAttraction(String attId, HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println("Liking attraction id " + attId);
        Boolean flag = likesDao.likeAttaction(attId);
        
        System.out.print("Liked");
        HashMap<String,String> jresponse = new HashMap<String,String>();
        jresponse.put("success", flag.toString());
        if(flag == true) {
            jresponse.put("message", "Successfully saved data.");
        } else {
            jresponse.put("message", "Not implemented yet!");
        }
        
        model.addAttribute("response", toJSON(jresponse));
        return TemplateJson;
    }
    
    @RequestMapping(value = "/dislike")
    public String dislikeAttraction(String attId, HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println("Liking attraction id " + attId);
        Boolean flag = likesDao.dislikeAttaction(attId);
        
        System.out.print("Liked");
        HashMap<String,String> jresponse = new HashMap<String,String>();
        jresponse.put("success", flag.toString());
        if(flag == true) {
            jresponse.put("message", "Successfully saved data.");
        } else {
            jresponse.put("message", "Not implemented yet!");
        }
        
        model.addAttribute("response", toJSON(jresponse));
        return TemplateJson;
    }
    
}
