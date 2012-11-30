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
 * @author kevingomes17
 */
@Controller
public class AttractionController extends BaseController {
    @Autowired
    private AttractionDao attractionDao;     
    
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
        
        if(!"0".equals(attId)) {            
            model.addAttribute("attraction", attractionDao.getAttraction(attId));
            setModelParameters(request, model, "attraction_view.jsp", "View Attraction");
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
