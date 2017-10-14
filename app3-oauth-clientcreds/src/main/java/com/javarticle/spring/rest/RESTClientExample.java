package com.javarticle.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RESTClientExample {
    @Autowired
    private RestTemplate restTemplate;

    public String getAllEmployees() {
        return restTemplate.getForObject("http://localhost:8082/clientcreds/txa/employees", String.class);
    }
}
