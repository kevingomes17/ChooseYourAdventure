/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.chooseadventure.service.*;
import org.chooseadventure.entity.*;

/**
 *
 * @author kevingomes17
 */
@Controller
public class AttractionController extends BaseController {
    @Autowired
    private AttractionDao attractionDao;     
    
    @RequestMapping(value = "/home")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
        if("POST".equals(request.getMethod())) {
            //userDao.add();            
        } 
        
        List<City> cities = attractionDao.getCities();
        model.addAttribute("cities", cities);
        
        setModelParameters(request, model, "choose_attraction.jsp", "Choose Attractions");
        return TemplateFile;
    }
}
