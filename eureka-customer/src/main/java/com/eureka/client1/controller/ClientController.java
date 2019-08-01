package com.eureka.client1.controller;

import com.eureka.client1.feign.Client0Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClientController {

    @Autowired
    private Client0Controller client0Controller;

    @GetMapping("get")
    public ResponseEntity<Object> get() {

        log.info("{}", "get");
        return client0Controller.client();
    }
}
