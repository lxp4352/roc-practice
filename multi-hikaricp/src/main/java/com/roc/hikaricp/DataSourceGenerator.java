package com.roc.hikaricp;


import com.zaxxer.hikari.HikariDataSource;

public class DataSourceGenerator {

    public static HikariDataSource getHikariDataSource(String code) {
        return (HikariDataSource) DataSourceCenter.get(code);
    }

}
