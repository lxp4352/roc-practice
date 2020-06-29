package com.roc.hikaricp;

import java.util.HashMap;
import java.util.Map;


public class DataSourceCenter {

    public static Map<String, Object> sourceMap = new HashMap<>();

    public static void add(String type, Object o) {
        sourceMap.put(type, o);
    }

    public static Object get(String type) {
        return sourceMap.get(type);
    }
}
