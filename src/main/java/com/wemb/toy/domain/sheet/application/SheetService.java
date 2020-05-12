package com.wemb.toy.domain.sheet.application;

import com.wemb.toy.domain.sheet.dao.SheetRepository;
import com.wemb.toy.domain.sheet.dto.SheetMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class SheetService {
    private SimpMessageSendingOperations messagingTemplate;
    private Map<String,SheetMessage> sheetMap;
//    private final SheetRepository sheetRepository;

//    public SheetService(Map<String, SheetMessage> sheetMap, SheetRepository sheetRepository) {
//        this.sheetMap = sheetMap;
//        this.sheetRepository = sheetRepository;
//    }

    public Map<String,SheetMessage> asyncSheet(SheetMessage sheetMessage) {
        return null;
    }

    public void saveContent() {
    }

    public void sendSheetMessage(SheetMessage sheetMessage) {
        messagingTemplate.convertAndSend(sheetMessage);
    }


}
