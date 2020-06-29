package com.roc.hikaricp;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;


@Component
public class DatasourceCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatasourceCommandLineRunner.class);

    @Resource
    private MapConfig mapConfig;

    @Override
    public void run(String... args) {
        Set<Map.Entry<String, Map<String, String>>> entrySet = mapConfig.getSources().entrySet();
        for (Map.Entry<String, Map<String, String>> entry : entrySet) {
            try {
                HikariDataSource  hikariDataSource= BaseJdbcUtils.createDataSource(entry.getValue());
                DataSourceCenter.add(entry.getKey(), hikariDataSource);
            } catch (Exception ex) {
                logger.error("The data source type is {} initialization exception", entry.getKey(), ex);
            }
        }
    }
}
