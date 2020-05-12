package com.wemb.toy.domain.sheet.api;


import com.wemb.toy.domain.pubsub.RedisPublisher;
import com.wemb.toy.domain.sheet.dto.SheetMessage;
import com.wemb.toy.domain.sheet.dto.SheetRoomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@Slf4j
@CrossOrigin("*")
@RequestMapping("/sheet")
@RequiredArgsConstructor
public class SheetAPI {

    private final RedisPublisher redisPublisher;

    @MessageMapping("/chat.sendMessage") // Message를 보낼 endPoint 설정 prefix = /app/
//    @SendTo("/topic/public") // 결과를 return?
    public SheetMessage sendMessage(@Payload SheetMessage sheetMessage) {
        log.info("sheetMessage : {} ", sheetMessage.toString());
        redisPublisher.publish(ChannelTopic.of("sheetMessage"),sheetMessage);
        return sheetMessage;
    }

    @GetMapping("/room")
    public SheetRoomResponse makeRandomRoomId() {
        SheetRoomResponse sr = new SheetRoomResponse();
        String roomId = UUID.randomUUID().toString().substring(0, 5);
        sr.setRoomId(roomId);
        return sr;
    }

}
