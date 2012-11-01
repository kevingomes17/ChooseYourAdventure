/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chooseadventure.utils;

/**
 *
 * @author kevingomes17
 */
public class Utils {
    /**
     * 
     * @param val
     * @return 
     */
    public static Boolean IsNullOrEmpty(String val) {
        if(val == null) return true;
        return val.isEmpty();
    }
    
    /**
     * If val is empty then defaultValue is returned.
     * Used a lot for parsing parameters passed in http request.
     * 
     * @param val
     * @param defaultValue
     * @return 
     */
    public static String IsNullOrEmpty(String val, String defaultValue) {
        defaultValue = IsNullOrEmpty(defaultValue)?"":defaultValue;
        val = IsNullOrEmpty(val)?defaultValue:val.trim();
        return val;
    }
}
