package com.railinc.springbootdemo.SpringBoot_Railinc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRailincApplication {

	private static Logger log = LoggerFactory.getLogger(SpringBootRailincApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringBootRailincApplication.class, args);

		log.info("Starting Application #========================#");
	}

}
