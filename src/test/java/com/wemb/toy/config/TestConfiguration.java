package com.wemb.toy.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.wemb.toy"})
@EnableJpaRepositories
@EnableAutoConfiguration
@EnableJpaAuditing
public class TestConfiguration {
}
