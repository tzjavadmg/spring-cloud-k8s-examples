package com.codyzeng.k8s.examples;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/16
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
public class SecretProperties {

    private String username;

    private String password;
}
