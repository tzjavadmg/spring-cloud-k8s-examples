package com.codyzeng.k8s.examples.sd;

/**
 * @author: codyzeng@163.com
 * @date: 2022/11/8
 */

import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        long start = System.currentTimeMillis();
        ClientHttpResponse response = execution.execute(request, body);
        long cost = System.currentTimeMillis() - start;

        // 打印日志
        trace(request, body, response);
        return response;
    }

    private void trace(HttpRequest request, byte[] body, ClientHttpResponse response) throws IOException {
        // 记录日志
        String responseStr = IOUtils.toString(response.getBody(), StandardCharsets.UTF_8);
        log.info(
                "\n" +
                        "URI          : {}, \n" +
                        "Method       : {}, \n" +
                        "Headers      : {}, \n" +
                        "Param        : {}, \n" +
                        "RespStatus   : {}, \n" +
                        "Response     : {}", request.getURI(),
                request.getMethod(), request.getHeaders(), new String(body, StandardCharsets.UTF_8), response.getStatusCode(), responseStr);
    }
}

