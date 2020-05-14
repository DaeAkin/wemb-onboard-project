package com.wemb.toy.global.config;//package com.wemb.toy.global.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import redis.embedded.RedisServer;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
///**
// * 테스트 환경일 경우 내장 레디스 실행
// */
//@Profile("test")
//@Configuration
//public class EmbeddedRedisConfig {
//
//    @Value("${spring.redis.port}")
//    private int redisPort;
//    private RedisServer redisServer;
//    @PostConstruct
//    public void redisServer() {
//        redisServer = new RedisServer(redisPort);
//        redisServer.start();
//    }
//    @PreDestroy
//    public void stopRedis() {
//        if (redisServer != null) {
//            redisServer.stop();
//        }
//    }
//}
