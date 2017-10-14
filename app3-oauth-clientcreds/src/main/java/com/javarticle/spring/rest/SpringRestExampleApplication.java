package com.javarticle.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestExampleApplication {
    
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestExampleApplication.class, args);
		//SpringApplication.run(SpringRestExampleApplication.class);
		System.out.println(( (RESTClientExample) context.getBean("restClient")).getAllEmployees());
	}
	
	@Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }
}
