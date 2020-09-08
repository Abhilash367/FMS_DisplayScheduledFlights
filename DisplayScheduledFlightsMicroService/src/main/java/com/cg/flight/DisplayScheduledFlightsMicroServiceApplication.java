package com.cg.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DisplayScheduledFlightsMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayScheduledFlightsMicroServiceApplication.class, args);
	}
	
}

