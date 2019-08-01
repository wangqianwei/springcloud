package com.eureka.client1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka-client-0")
public interface Client0Controller {

    @RequestMapping("client")
    ResponseEntity<Object> client();
}
