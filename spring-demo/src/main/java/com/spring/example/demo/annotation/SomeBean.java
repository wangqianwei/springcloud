package com.spring.example.demo.annotation;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SomeBean {

    private int someValue = 10;
}
