package com.wemb.toy.domain.sheet.api;


import com.wemb.toy.domain.pubsub.RedisPublisher;
import com.wemb.toy.domain.sheet.dao.SheetRepository;
import com.wemb.toy.domain.sheet.dto.RowData;
import com.wemb.toy.domain.sheet.dto.SheetMessage;
import com.wemb.toy.domain.sheet.dto.SheetRoomResponse;
import com.wemb.toy.domain.sheet.dto.SheetSaveRequest;
import com.wemb.toy.domain.user.dao.UserRepository;
import com.wemb.toy.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RestController
@Slf4j
@CrossOrigin("*")
@RequestMapping("/sheet")
@RequiredArgsConstructor
public class SheetAPI {

    private final RedisPublisher redisPublisher;
    private final SheetRepository sheetRepository;

    @MessageMapping("/chat.sendMessage") // Message를 보낼 endPoint 설정 prefix = /app/
    public SheetMessage sendMessage(@Payload SheetMessage sheetMessage,Authentication authentication) {
        User user = (User)(authentication.getPrincipal());
        log.info("message is send :: {} , username is :: {}",sheetMessage.toString() ,user.getUsername());
        sheetMessage.setUsername(user.getName());
        redisPublisher.publish(ChannelTopic.of("sheetMessage"),sheetMessage);
        return sheetMessage;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SheetMessage getSheetMessage() {
       return sheetRepository.getSheetMessage();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSheet(@RequestBody SheetSaveRequest sheetSaveRequest) {
        sheetRepository.save(sheetSaveRequest);
    }


}
