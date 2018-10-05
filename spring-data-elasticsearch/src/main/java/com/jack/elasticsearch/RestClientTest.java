package com.jack.elasticsearch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import java.io.IOException;
import java.util.Collections;
public class RestClientTest {
    public  static void main(String[]args){
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "aixiangdao@88"));
        RestClient restClient = RestClient.builder(new HttpHost("es-cn-0pp0shlha000ds6yk.public.elasticsearch.aliyuncs.com", 9200))
                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                    @Override
                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                    }
                }).build();
        try {
            //index a document
            HttpEntity entity = new NStringEntity("{\n\"user\" : \"kimchy\"\n}", ContentType.APPLICATION_JSON);
            Response indexResponse = restClient.performRequest(
                    "PUT",
                    "/index/type/123",
                    Collections.<String, String>emptyMap(),
                    entity);
            //search a document
            Response response = restClient.performRequest("GET", "/index/type/123",
                    Collections.singletonMap("pretty", "true"));
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}