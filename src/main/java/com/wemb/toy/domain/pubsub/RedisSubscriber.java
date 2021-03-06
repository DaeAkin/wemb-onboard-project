package com.wemb.toy.domain.pubsub;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.wemb.toy.domain.sheet.dto.SheetMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class RedisSubscriber implements MessageListener {

    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;
    private final SimpMessageSendingOperations messagingTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            // redis에서 발행된 데이터를 받아 deserialize
            String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
            // ChatMessage 객채로 맵핑
            SheetMessage sheetMessage = objectMapper.readValue(publishMessage, SheetMessage.class);
            log.info("redis subscribe Message :: {}",sheetMessage.toString());
            // Websocket 구독자에게 채팅 메시지 Send
            messagingTemplate.convertAndSend("/topic/public",sheetMessage);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
