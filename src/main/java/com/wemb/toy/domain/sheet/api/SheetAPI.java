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
    private final UserRepository userRepository;

    @MessageMapping("/chat.sendMessage") // Message를 보낼 endPoint 설정 prefix = /app/
//    @SendTo("/topic/public") // 결과를 return?
    public SheetMessage sendMessage(@Payload SheetMessage sheetMessage,Authentication authentication) {
//        log.info("sned()");
        User user = (User)(authentication.getPrincipal());
        sheetMessage.setUsername(user.getName());
        redisPublisher.publish(ChannelTopic.of("sheetMessage"),sheetMessage);
//        sheetRepository.save(sheetMessage);
        return sheetMessage;
    }


    @GetMapping("/room")
    public SheetRoomResponse makeRandomRoomId() {
        SheetRoomResponse sr = new SheetRoomResponse();
        String roomId = UUID.randomUUID().toString().substring(0, 5);
        sr.setRoomId(roomId);
        return sr;
    }

    @GetMapping
    public SheetMessage getSheetMessage() {
       return sheetRepository.getSheetMessage();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSheet(@RequestBody SheetSaveRequest sheetSaveRequest) {
        sheetRepository.save(sheetSaveRequest);
    }

    @GetMapping("/test")
    public SheetMessage test(@RequestBody SheetMessage sheetMessage ) {
        log.info("sheetMessage : {}" , sheetMessage.toString());
//        SheetMessage sm = new SheetMessage();
//
//        List<String> list1 = Arrays.asList("aa", "bb", "cc");
//        List<String> list2 = Arrays.asList("dd", "ee", "ff");
//
//        sm.setRowData(Arrays.asList(list1,list2));
        return sheetMessage;
    }

}
