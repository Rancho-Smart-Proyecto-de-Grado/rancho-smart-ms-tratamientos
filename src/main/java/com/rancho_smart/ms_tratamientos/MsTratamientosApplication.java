package com.rancho_smart.ms_tratamientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsTratamientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTratamientosApplication.class, args);
	}

}
