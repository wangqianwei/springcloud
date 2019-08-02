package com.rabbitmq.customer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Component
public class CustomerListener implements BaseListener {
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Integer> template;

    @PostConstruct
    public void init() {
        template.setKeySerializer(StringRedisSerializer.UTF_8);
    }

    @Override
    public void listener(String msg) {
        template.opsForValue().increment("key");
        log.info("customer listener:{}", msg);
    }
}
