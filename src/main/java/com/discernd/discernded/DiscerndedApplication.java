package com.discernd.discernded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class DiscerndedApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscerndedApplication.class, args);
	}


}
