package com.codyzeng.k8s.examples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/06
 */
@Slf4j
@RestController
public class ExampleServiceController {

    private final String hostName = System.getenv("HOSTNAME");

    @RequestMapping("/")
    public String hello() {
        log.info("Hello!---------------");
        return "Hello World";
    }

    @RequestMapping("/login")
    public String login(String username) {
        log.info("Hello!---------------" + username);
        return username + " login success! message from " + hostName;
    }

}
