package com.wemb.toy.domain.sheet.dao;

import com.wemb.toy.domain.sheet.dto.SheetMessage;
import com.wemb.toy.domain.sheet.dto.SheetSaveRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class SheetRepository {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    private static final String TEMP = "sheet";
    public void save(SheetSaveRequest sheetMessage) {
        log.info("redis save :: Sheet : {}", sheetMessage);
        ListOperations<String, Object> redis = redisTemplate.opsForList();
        redis.rightPop(TEMP);
        redis.rightPush(TEMP,sheetMessage);
    }

    //?? 이상
    public SheetMessage getSheetMessage() {
        ListOperations<String, Object> redis = redisTemplate.opsForList();
//        SheetSaveRequest data = (SheetSaveRequest) redis.index(TEMP, 0);
        SheetMessage data = (SheetMessage) redis.index(TEMP, 0);
        log.info("redis get Data :: Sheet : {}", data);
        if(data == null)
            return new SheetMessage();
        return data;
    }

}
