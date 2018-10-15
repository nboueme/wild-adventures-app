package com.wa.msm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.wa.msm.user")
@EnableDiscoveryClient
public class WaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaUserApplication.class, args);
	}
}
