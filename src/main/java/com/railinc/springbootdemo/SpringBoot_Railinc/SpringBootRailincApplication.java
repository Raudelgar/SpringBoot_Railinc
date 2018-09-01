package com.railinc.springbootdemo.SpringBoot_Railinc;

import com.railinc.springbootdemo.SpringBoot_Railinc.controller.UserController;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.Address;
import com.railinc.springbootdemo.SpringBoot_Railinc.domain.User;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.IAddService;
import com.railinc.springbootdemo.SpringBoot_Railinc.service.IUsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootRailincApplication {

	private static Logger log = LoggerFactory.getLogger(SpringBootRailincApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringBootRailincApplication.class, args);

		log.info("Starting Application #========================#");
	}

}
