package com.test.demo;

import clover.org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

/**
 * @author todkarin
 * Created on : 17 Dec 2020
 * Test controller for html page
 */

@Controller
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String testPage() {
        return "test";
    }


    @GetMapping("/callAPI")
    public ResponseEntity<ResponseObject> callAPI() {

        ResponseEntity<ResponseObject> responseEntity = restTemplate.exchange(
                "https://postman-echo.com/get?foo1=bar1&foo2=bar2",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseObject>() {
                });
        ResponseObject responseObject = responseEntity.getBody();
        return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
    }


}

