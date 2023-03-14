package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //웹서버 실행
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DemoApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE); //웹서버 수행 안됨
		application.run(args);
		abc();
	}
	
	public static void abc() {	
		System.out.println("스프링 부트로 작업하기");		
	}
}
