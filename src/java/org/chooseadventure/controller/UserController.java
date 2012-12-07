/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import java.util.ArrayList;
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
import org.springframework.util.StringUtils;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevingomes17
 */
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserDao userDao;     

    @RequestMapping(value = "/add")
    public String insert(HttpServletRequest request, HttpServletResponse response, Model model) {
        if("POST".equals(request.getMethod())) {
            //userDao.add();            
        } 
        
        //List<City> cities = userDao.getCities();
        //model.addAttribute("cities", cities);
        setModelParameters(request, model, "add_city.jsp", "Add City");
        return TemplateFile;
    }
    
    /**
     * TODO: Redirect to home page if user is already logged in.
     * 
     * @param request
     * @param response
     * @param model
     * @return 
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession sess = null;
        String email;
        Boolean flag;

        try {
            if (request.getUserPrincipal() == null) {
                email = "";
            } else {
                email = request.getUserPrincipal().getName();
                flag = authenticateUser(email);

                if (flag == true) { //user exists in database
                    sess = request.getSession(true);
                    sess.setAttribute("email", email);

                    return "redirect:" + HomeUrl;
                } else { //user does not exist in database
                    sess = request.getSession(false);
                    if (sess != null) {
                        sess.invalidate();
                    }

                    Errors.add("Looks like your account has not been setup. Please contact Administrator!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setModelParameters(request, model, "login.jsp", "Login");
        return TemplateFile;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession sess = request.getSession(false);
        if (sess != null) {
            sess.invalidate();
        }
        return "redirect:" + LoginUrl;
    }

    @RequestMapping(value = "/profile")
    public String profile(HttpServletRequest request, HttpServletResponse response, Model model) {        
        String username = getUserIdFromSession(request);
        
        if("POST".equals(request.getMethod())) {
            String[] phones = request.getParameterValues("phone");
            Boolean flag = userDao.updatePhones(username, phones);
            if(flag == true) {
                model.addAttribute("message", "Successfully updated phone nos.");
            } else {
                model.addAttribute("message", "Unable to update phone nos.");
            }
        }
        
        Userbase user = userDao.getUser(username);
        model.addAttribute("user", user);
        setModelParameters(request, model, "user_profile.jsp", "Profile");
        return TemplateFile;
    }
    
    private Boolean authenticateUser(String email) {
        Boolean flag = false;

        Userbase userObj = userDao.getUser(email);
        if (userObj == null) {
            flag = false;

        } else {
            flag = true;
        }

        return flag;
    }
    
    @RequestMapping(value = "/view-guests")
    public String viewGuests(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Userwebsite> users = userDao.getGuestUsers();
        model.addAttribute("users", users);
        
        setModelParameters(request, model, "view_guests.jsp", "List of Guests");
        return TemplateFile;
    }
}
