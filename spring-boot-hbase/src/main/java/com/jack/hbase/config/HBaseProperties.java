package com.jack.hbase.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author yangyueming
 */
@ConfigurationProperties(prefix = "hbase")
public class HBaseProperties {

    private Map<String, String> config;
    
    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
    

}