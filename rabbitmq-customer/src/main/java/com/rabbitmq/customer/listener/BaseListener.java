package com.rabbitmq.customer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface BaseListener {

    @RabbitListener(queues = "queue")
    void listener(String msg);
}
