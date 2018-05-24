package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.example.demo.controller","com.example.demo.dto","com.example.demo.entity","com.example.demo.repository","com.example.demo.service"})
public class ProjekatOsaApplication{
	


	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProjekatOsaApplication.class, args);
	}
}
