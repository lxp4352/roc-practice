package com.roc.hikaricp;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class BaseJdbcUtils {

    private static final Logger logger = LoggerFactory.getLogger(BaseJdbcUtils.class);

    public static HikariDataSource createDataSource(Map<String, String> map) {
        logger.info(map.get("username") + "------start!!!");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(map.get("url"));
        config.setUsername(map.get("username"));
        config.setPassword(map.get("password"));
        config.setDriverClassName(map.get("driverClassName"));
        config.setConnectionTimeout(8 * 60 * 60);
        config.setIdleTimeout(30000);
        config.setAutoCommit(true);
        config.setMaximumPoolSize(300);
        config.setMinimumIdle(5);
        config.setMaxLifetime(60000);
        config.setPoolName(map.get("username"));
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource dataSource = new HikariDataSource(config);
        logger.info(map.get("username") + "------end!!!");
        return dataSource;
    }
}
