package com.plendo.repository.utils;

import java.util.List;

/**
 * Created by nxuser on 23/05/15.
 */
public class DaoUtils {

    public static String listOfStringToFormattedString(List<String> listToFormat){
        StringBuilder ret = new StringBuilder("");
        if(listToFormat != null){
            for (String curseur : listToFormat){
                ret.append("'" + curseur + "',");
            }
        }
        ret.setLength(ret.length() - 1);
        return ret.toString();
    }
}
