package com.eureka.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClientController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("client")
    public ResponseEntity<Object> client() {

        log.info("ClientController.client:{}", client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
