package com.codyzeng.k8s.examples.sd;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/8
 */
@Service
public class ExampleService {

    @Resource
    private RestTemplate restTemplate;

    public Object login(String username){
        String url="http://example-service/login?username={username}";
        Map<String, Object> uriVariables = new HashMap<>(1);
        uriVariables.put("username", username);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Connection", "Close");
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET,httpEntity, String.class,uriVariables);
    }
}
