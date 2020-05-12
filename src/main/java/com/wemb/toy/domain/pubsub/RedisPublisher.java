package com.wemb.toy.domain.pubsub;

import com.wemb.toy.domain.sheet.dto.SheetMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    public void publish(ChannelTopic topic, SheetMessage message) {
        log.info("redis published");
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
