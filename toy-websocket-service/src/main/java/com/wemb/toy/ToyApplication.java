package com.wemb.toy;

import com.wemb.toy.domain.sheet.dto.SheetMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableCircuitBreaker
public class ToyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyApplication.class, args);
	}

	@Primary
	@Bean
	public Map<String, SheetMessage> sheetMap() {
		return new ConcurrentHashMap<>();
	}

}
