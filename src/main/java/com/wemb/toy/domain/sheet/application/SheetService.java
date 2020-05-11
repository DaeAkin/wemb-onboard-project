package com.wemb.toy.domain.sheet.application;

import com.wemb.toy.domain.sheet.dao.SheetRepository;
import com.wemb.toy.domain.sheet.dto.SheetMessage;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public class SheetService {

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


}
