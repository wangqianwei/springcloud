package com.rabbitmq.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class RabbitmqListener2 implements BaseListener {
    @Override
    public void listener(String msg, Message message, Channel channel) {
        log.info("listener2:{}", msg);
    }
}
