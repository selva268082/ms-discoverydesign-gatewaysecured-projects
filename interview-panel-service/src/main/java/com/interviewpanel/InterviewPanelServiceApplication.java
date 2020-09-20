package com.interviewpanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InterviewPanelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPanelServiceApplication.class, args);
	}

}
