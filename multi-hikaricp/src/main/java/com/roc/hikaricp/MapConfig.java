package com.roc.hikaricp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
@ConfigurationProperties(prefix = "datasource")
public class MapConfig {

    private Map<String, Map<String, String>> sources = new HashMap<>();

    public Map<String, Map<String, String>> getSources() {
        return sources;
    }

    public void setSources(Map<String, Map<String, String>> sources) {
        this.sources = sources;
    }
}

