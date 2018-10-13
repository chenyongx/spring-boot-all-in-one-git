package com.jack.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/***
 ** 配置ES,支持集群
 * @author yangyueming
 */
@Configuration
public class ElasticSearchXPackConfig {

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Value("${elasticsearch.xpack.security.user}")
    private String xpackSecurityUser;

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;
    

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        TransportClient transportClient = new PreBuiltXPackTransportClient(Settings.builder()
                .put("cluster.name", clusterName)
                .put("xpack.security.user", xpackSecurityUser)
                .build())
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        return transportClient;
    }

}