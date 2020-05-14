package com.wemb.toy.domain.sheet.dao;

import com.wemb.toy.domain.sheet.dto.SheetMessage;
import com.wemb.toy.domain.sheet.dto.SheetSaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class SheetRepository {
    private static final String TEMP = "sheet";

    private final RedisTemplate<String,Object> redisTemplate;
    private final ListOperations<String,Object> redis;

    public SheetRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        redis = redisTemplate.opsForList();
    }
    public void save(SheetSaveRequest sheetMessage) {
        log.info("redis save :: Sheet : {}", sheetMessage);
        redis.rightPop(TEMP);
        redis.rightPush(TEMP,sheetMessage);
    }

    //?? 이상
    public SheetMessage getSheetMessage() {
        SheetMessage data = (SheetMessage) redis.index(TEMP, 0);
        log.info("redis get Data :: Sheet : {}", data);

       return Optional.of(data).orElseGet(SheetMessage::new);
    }

}
