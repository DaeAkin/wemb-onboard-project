package com.wemb.toy.domain.sheet.api;


import com.wemb.toy.domain.sheet.dto.SheetMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
@Slf4j
public class SheetAPI {


    @MessageMapping("/chat.sendMessage") // Message를 보낼 endPoint 설정 prefix = /app/
    @SendTo("/topic/public") // 결과를 return?
    public SheetMessage sendMessage(@Payload SheetMessage sheetMessage) {
        log.info("sheetMessage : {} ", sheetMessage.toString());
        SheetMessage sm = new SheetMessage();
        sm.setContent("hihi");
        return sheetMessage;
    }

}
