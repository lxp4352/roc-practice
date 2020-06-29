package com.roc.hikaricp;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HikaricpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HikaricpApplication.class, args);
        HikariDataSource hikariDataSource = DataSourceGenerator.getHikariDataSource("db");
        System.out.println(hikariDataSource);
    }

}
