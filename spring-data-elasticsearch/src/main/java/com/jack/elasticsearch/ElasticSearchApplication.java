package com.jack.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        TransportClient client = new PreBuiltXPackTransportClient(Settings.builder()
                .put("cluster.name", "es-cn-0pp0shlha000ds6yk")
                .put("xpack.security.user", "elastic:aixiangdao@88")
                .build())
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("es-cn-0pp0shlha000ds6yk" +
                        ".public.elasticsearch.aliyuncs.com"), 9300));
        return client;
    }
}
