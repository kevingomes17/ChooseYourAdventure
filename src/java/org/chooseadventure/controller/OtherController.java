/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.chooseadventure.entity.DbTable;
import org.chooseadventure.service.OtherDao;
import org.chooseadventure.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kevingomes17
 */
@Controller
public class OtherController extends BaseController {
    @Autowired
    private OtherDao otherDao;    
    
    @RequestMapping(value = "/table-data", method = RequestMethod.GET)
    public String tableData(HttpServletRequest request, HttpServletResponse response, Model model) {              
        String tableName = Utils.GetValIfNull(request.getParameter("tableName"), "");
        
        if(!tableName.isEmpty()) {
            ArrayList<String> results = otherDao.getTableData(tableName);
            model.addAttribute("results", results);
        } else {
            model.addAttribute("results", null);
        }
        
        List<DbTable> tables = otherDao.getTables();
        model.addAttribute("tables", tables);
        
        setModelParameters(request, model, "view_any_table_data.jsp", "View Data in Tables");
        return TemplateFile;
    }
}
