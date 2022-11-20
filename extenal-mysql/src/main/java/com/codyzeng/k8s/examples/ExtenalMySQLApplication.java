package com.codyzeng.k8s.examples;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.codyzeng.k8s.examples.**.dao")
public class ExtenalMySQLApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExtenalMySQLApplication.class, args);
    }

}
