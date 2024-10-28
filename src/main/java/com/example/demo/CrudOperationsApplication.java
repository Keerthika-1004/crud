package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication


public class CrudOperationsApplication {
 public static int add(int a, int b) {
	 int c = a+b;
	 return c;
 }
	public static void main(String[] args) {
		System.out.println("hello");
		int a=10;
		int b=30;
		System.out.println(add(a,b));
		SpringApplication.run(CrudOperationsApplication.class, args);
		
		
	}
	

}
