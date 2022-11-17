package com.codyzeng.k8s.examples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/15
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class ConfigReloadApplication {

    @Resource
    private ConfigMapProperties configProperties;
    @Resource
    private SecretProperties secretProperties;

    public static void main(String[] args) {
        SpringApplication.run(ConfigReloadApplication.class, args);
    }

    /**
     * 定时调度，每1000毫秒打印一次ConfigMap和Secrets中的配置项数据
     */
    @Scheduled(fixedDelay = 1000)
    public void hello() {
        log.info("重试次数：{},错误消息：{},用户名：{},密码：{}",
                configProperties.getRetryCount(),
                configProperties.getErrorMessage(),
                secretProperties.getUsername(),
                secretProperties.getPassword()
        );
    }
}
