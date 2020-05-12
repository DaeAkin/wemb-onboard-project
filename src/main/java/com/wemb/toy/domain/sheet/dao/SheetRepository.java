package com.wemb.toy.domain.sheet.dao;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SheetRepository {

    private RedisTemplate<String,Object> redisTemplate;
    
}
