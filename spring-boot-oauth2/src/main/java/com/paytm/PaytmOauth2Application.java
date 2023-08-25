package com.paytm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class PaytmOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(PaytmOauth2Application.class, args);
	}
}
