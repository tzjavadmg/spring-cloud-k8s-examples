package com.codyzeng.k8s.examples.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ClientSideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientSideApplication.class);
    }

}
