package com.codyzeng.k8s.examples.sd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/05
 */
@RestController
public class ClientSideController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }
}
