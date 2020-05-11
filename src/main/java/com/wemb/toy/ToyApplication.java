package com.wemb.toy;

import com.wemb.toy.domain.sheet.dto.SheetMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
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
