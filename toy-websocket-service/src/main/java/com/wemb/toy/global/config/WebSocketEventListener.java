package com.wemb.toy.global.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
public class WebSocketEventListener {


    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        log.info("-------------------------------------");
        log.info("Received a new web socket connection");
        log.info("-------------------------------------");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        log.info("-------------------------------------");
        log.info("webSocket disconnected");
        log.info("-------------------------------------");
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

//        SheetMessage sm = new SheetMessage();
//        sm.setContent("hihi");
////
//
//        messagingTemplate.convertAndSend("/topic/public", sm);

    }
}
