package com.example.ProductSellerRestTemplate.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {
   private final Integer maxTotalConnections=100;
    private final Integer defaultMaxTotalConnection=20;
    private final Integer connectionRequestTimeout=3000;
    private final Integer soketTimeOut=3000;

 public ClientHttpRequestFactory clientHttpRequestFactory() {
     PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
     connectionManager.setMaxTotal(maxTotalConnections);
     connectionManager.setDefaultMaxPerRoute(defaultMaxTotalConnection);

     RequestConfig requestConfig = RequestConfig
             .custom()
             .setConnectionRequestTimeout(connectionRequestTimeout)
             .setSocketTimeout(soketTimeOut)
             .build();

     CloseableHttpClient httpClient = HttpClients
             .custom()
             .setConnectionManager(connectionManager)
             .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
             .setDefaultRequestConfig(requestConfig)
             .build();
     return new HttpComponentsClientHttpRequestFactory(httpClient);

 }
 @Override
    public void customize(RestTemplate restTemplate) {
restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
