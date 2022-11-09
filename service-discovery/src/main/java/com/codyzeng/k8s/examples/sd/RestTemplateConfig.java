package com.codyzeng.k8s.examples.sd;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/8
 */
@Configuration
public class RestTemplateConfig {

    @Value("${ok.http.connect-timeout:3000}")
    private Integer connectTimeout;

    @Value("${ok.http.read-timeout:3000}")
    private Integer readTimeout;

    @Value("${ok.http.write-timeout:3000}")
    private Integer writeTimeout;

    @Value("${ok.http.max-idle-connections:0}")
    private Integer maxIdleConnections;

    @Value("${ok.http.keep-alive-duration:1}")
    private Long keepAliveDuration;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(ClientHttpRequestFactory httpRequestFactory) {

        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

        // 设置拦截器，答应请求信息，方便Debug
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new LoggingClientHttpRequestInterceptor());

        restTemplate.setInterceptors(interceptors);

        //提供对传出/传入流的缓冲,可以让响应body多次读取(如果不配置,拦截器读取了Response流,再响应数据时会返回body=null)
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(httpRequestFactory));

        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new OkHttp3ClientHttpRequestFactory(okHttpConfigClient());
    }

    public OkHttpClient okHttpConfigClient() {
        return new OkHttpClient().newBuilder()
//                .connectionPool(pool())
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .hostnameVerifier((hostname, session) -> true)
                // 设置代理
//              .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888)))
                // 拦截器
                .addInterceptor(new Interceptor() {

                    public Response intercept(Chain chain) throws IOException {

                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("Connection", "Close")
                                .method(original.method(), original.body())
                                .build();
                        return chain.proceed(request);

                    }
                })
                .build();
    }

//    public ConnectionPool pool() {
//        return new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.SECONDS);
//    }
}
