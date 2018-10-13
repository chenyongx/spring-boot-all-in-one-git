package com.jack.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author yangyueming
 */
@SpringBootApplication
@EnableElasticsearchRepositories
public class EsAliyunApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsAliyunApplication.class, args);
    }

//    @Bean
//    public TransportClient transportClient() throws UnknownHostException {
//        TransportClient client = new PreBuiltXPackTransportClient(Settings.builder()
//                .put("cluster.name", "es-cn-0pp0shlha000ds6yk")
//                .put("xpack.security.user", "elastic:aixiangdao@88")
//                .build())
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("es-cn-0pp0shlha000ds6yk" +
//                        ".public.elasticsearch.aliyuncs.com"), 9300));
//        return client;
//    }
}
