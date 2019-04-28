package com.hl.machine.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.hl.machine.provider.mapper")
public class ProviderMain {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderMain.class, args);
	}

}
