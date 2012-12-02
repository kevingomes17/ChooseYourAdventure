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
        if (val == null) {
            return true;
        }
        return val.isEmpty();
    }

    public static Boolean IsNullOrEmpty(Integer val) {
        if (val == null) {
            return true;
        }
        return false;
    }

    public static Boolean IsNullOrEmpty(Double val) {
        if (val == null) {
            return true;
        }
        return false;
    }

    /**
     * If val is empty then defaultValue is returned.
     * Used a lot for parsing parameters passed in http request.
     * 
     * @param val
     * @param defaultValue
     * @return 
     */
    public static String GetValIfNull(String val, String defaultValue) {
        defaultValue = IsNullOrEmpty(defaultValue) ? "" : defaultValue;
        val = IsNullOrEmpty(val) ? defaultValue : val.trim();
        return val;
    }

    public static Integer GetValIfNull(String val, Integer defaultValue) {
        try {
            defaultValue = IsNullOrEmpty(defaultValue) ? 0 : defaultValue;
            Integer retVal = IsNullOrEmpty(val) ? defaultValue : Integer.parseInt(val.trim());
            return retVal;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double GetValIfNull(String val, double defaultValue) {
        try {
            defaultValue = IsNullOrEmpty(defaultValue) ? 0 : defaultValue;
            Double retVal = IsNullOrEmpty(val) ? defaultValue : Double.parseDouble(val.trim());
            return retVal;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Method to join array elements of type string
     * @author Hendrik Will, imwill.com
     * @param inputArray Array which contains strings
     * @param glueString String between each array element
     * @return String containing all array elements seperated by glue string
     */
    public static String implodeArray(String[] inputArray, String glueString) {

        /** Output variable */
        String output = "";

        if (inputArray.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(inputArray[0]);

            for (int i = 1; i < inputArray.length; i++) {
                sb.append(glueString);
                sb.append(inputArray[i]);
            }

            output = sb.toString();
        }

        return output;
    }
}
