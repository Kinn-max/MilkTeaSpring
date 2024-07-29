package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum Sugar {
    DUONG_IT("Đường ít"),
    DUONG_VUA("Đường vừa"),
    DUONG_100("Đường 100%");// save table sugar
    private  final String sugarName;
    Sugar(String sugarName) {
        this.sugarName = sugarName;
    }
    public static Map<String,String> type(){
        Map<String,String> sugars = new TreeMap<>();
        for(Sugar sugar : values()){
            sugars.put(sugar.toString(),sugar.sugarName); //(DUONG_IT, Đường ít)
        }
        return sugars;
    }
}
