package com.codyzeng.k8s.examples.sd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/05
 */
@Slf4j
@RestController
public class ClientSideController {

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private ExampleService exampleService;
    @Resource
    private ExampleFeignClient exampleFeignClient;


    @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }

    @RequestMapping("/instances")
    public List<ServiceInstance> instances(String serviceName) {
        return this.discoveryClient.getInstances(serviceName);
    }

    @RequestMapping("/invoke")
    public Object invoke(String username) {
        return exampleService.login(username);
    }

    @RequestMapping("/feign")
    public Object feign(String username) {
        return exampleFeignClient.login(username);
    }

}
