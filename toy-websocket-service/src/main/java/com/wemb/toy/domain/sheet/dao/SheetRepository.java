package com.wemb.toy.domain.sheet.dao;

import com.wemb.toy.domain.sheet.dto.SheetMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SheetRepository {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    private static final String TEMP = "sheet";
    public void save(SheetMessage sheetMessage) {
        ListOperations<String, Object> redis = redisTemplate.opsForList();
        redis.rightPop(TEMP);
        redis.rightPush(TEMP,sheetMessage);
    }

    public SheetMessage getSheetMessage() {
        ListOperations<String, Object> redis = redisTemplate.opsForList();
        return (SheetMessage)redis.index(TEMP,0);
    }

}
