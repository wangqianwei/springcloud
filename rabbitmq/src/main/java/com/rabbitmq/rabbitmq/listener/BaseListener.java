package com.rabbitmq.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface BaseListener {

    @RabbitListener(queues = "queue")
    void listener(String msg, Message message, Channel channel);
}
