package com.wemb.toy.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    //애는 처음에 웹소켓 맺을 때 쓰는 endpoint
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //클라이언트에서 메세지 송신시 붙여줄 prefix
        registry.setApplicationDestinationPrefixes("/app");
        //클라이언트로 메세지를 보낼 때 쓰는 endPoint
        registry.enableSimpleBroker("/topic");
    }
}
