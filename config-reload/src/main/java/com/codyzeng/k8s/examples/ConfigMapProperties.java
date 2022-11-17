package com.codyzeng.k8s.examples;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/15
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "examples.configmap")
@Getter
@Setter
public class ConfigMapProperties {

    private String errorMessage;

    private Integer retryCount;
}
