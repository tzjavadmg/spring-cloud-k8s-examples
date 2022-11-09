package com.codyzeng.k8s.examples.sd;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/8
 */
@FeignClient("example-service")
public interface ExampleFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestParam String username);
}
