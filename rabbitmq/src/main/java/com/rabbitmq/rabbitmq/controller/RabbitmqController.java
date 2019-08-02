package com.rabbitmq.rabbitmq.controller;

import com.rabbitmq.rabbitmq.listener.BaseListener;
import com.rabbitmq.rabbitmq.work.WorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RabbitmqController {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private WorkService workService;

    @GetMapping("sendMsg")
    public ResponseEntity<Object> sendMsg(String msg) {

        log.info("sendMsg:{}", msg);
        template.convertAndSend("queue", msg);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("customer")
    public ResponseEntity<Object> customer(String msg) {

        log.info("customer:{}", msg);
        workService.init();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
