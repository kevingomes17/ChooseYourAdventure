/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.chooseadventure.entity.Attraction;
import org.chooseadventure.entity.DbTable;
import org.chooseadventure.entity.UserRoles;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevingomes17
 */
@Service
public class OtherDao extends BaseDao {
    
    
    /**
     * Returns the list of tables in the DB.
     * 
     * @return 
     */
    public List<DbTable> getTables() {        
        try {
            TypedQuery<DbTable> query = em.createNamedQuery("DbTable.findAll", DbTable.class);
            List<DbTable> tables = query.getResultList();
            return tables;
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList<DbTable>();
        }
    }
    
    public ArrayList getTableData(String tableName) {
        try {
            HashMap<String,String> tableClassMapping = new HashMap<String,String>() 
            {{
                put("ATTRACTION", "org.chooseadventure.entity.Attraction");
                
            }};            
            
            HashMap<String,String> tableClassMapping1 = new HashMap<String,String>();
            tableClassMapping1.put("ATTRACTION", "Attraction");
            
            String classNameStr = tableClassMapping.get(tableName).toString();
            Class className = Class.forName(classNameStr);
            
            ArrayList<String> results = new ArrayList();
            
            TypedQuery query = em.createNamedQuery(tableClassMapping1.get(tableName).toString()+".findAll", className.getClass());
            List res = query.getResultList();
            Iterator itr = res.iterator();
            while(itr.hasNext()) {                
                Object obj = itr.next();
                results.add(className.cast(obj).toString());
            }
            
            return results;
        } catch(Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
