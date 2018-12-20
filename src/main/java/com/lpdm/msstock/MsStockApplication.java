package com.lpdm.msstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStockApplication.class, args);
	}
}
