package com.wemb.toy.domain.sheet.dao;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.wemb.toy.domain.sheet.dto.SheetMessage;
import com.wemb.toy.test.IntegrationTest;
import com.wemb.toy.test.RepositoryTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
public class SheetRepositoryTests extends IntegrationTest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

//    @Autowired
//    private SheetRepository sheetRepository;

    
    @Test
    public void Redis_테스트() {

    }
}
