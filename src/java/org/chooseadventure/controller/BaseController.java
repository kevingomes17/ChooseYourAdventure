/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.chooseadventure.service.*;
import org.chooseadventure.entity.*;
import org.chooseadventure.utils.Utils.*;
import java.util.ArrayList;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author kevingomes17
 */
@Controller
public class BaseController {        
    protected ArrayList<String> Errors = new ArrayList();
    
    protected String BasePath = "/ChooseYourAdventure"; //no trailing slash
    protected String TemplateFile = "TemplateMain"; //Html template
    protected String TemplateJson = "TemplateJson"; //JSON template
    protected String TemplateSubForm = "TemplateSubForm"; //Sub-form template
    
    protected String HomeUrl = "/attraction/home.htm";
    protected String LoginUrl = "/user/login.htm";
    protected String LogoutUrl = "/user/logout.htm";
    
    protected String INSUFFICIENT_REQ_DATA = "Insufficient data supplied to complete the request.";
    
    public BaseController() {
        
    }
    
    protected void setModelParameters(HttpServletRequest request, Model model, String filename, String pageTitle) {
        String username = getUserIdFromSession(request);
        
        LinkedHashMap<String,String> primaryMenu = new LinkedHashMap<String,String>();
        primaryMenu.put("Home", BasePath+HomeUrl);
        primaryMenu.put("My ITV", "");
        primaryMenu.put("Approve ITV", "");
        primaryMenu.put("Budgets", "");
        primaryMenu.put("Logout", BasePath+LogoutUrl);
        
        model.addAttribute("Filename", filename);
        model.addAttribute("PageTitle", pageTitle);
        model.addAttribute("BasePath", BasePath);
        model.addAttribute("PrimaryMenu", primaryMenu);
        model.addAttribute("Errors", Errors.clone());
        model.addAttribute("Username", username);
        
        Errors.clear();
    }
    
    //returning user email
    protected String getUserIdFromSession(HttpServletRequest request) {
        HttpSession sess = request.getSession(true);
        String username = "";
        
        try {
            if(sess != null) {
                String userId = sess.getAttribute("uname").toString();
                username = userId;
            }
        } catch(Exception e) {
            username = "";
        }
        return username;
    }
    
    protected String toJSON(HashMap<String,String> results) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {            
            json = mapper.writeValueAsString(results);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return json;
    }
    
    protected String toJSON(ArrayList<HashMap<String,String>> results) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {            
            json = mapper.writeValueAsString(results);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return json;
    }
}
