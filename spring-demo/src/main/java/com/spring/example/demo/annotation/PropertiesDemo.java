package com.spring.example.demo.annotation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:propertiesdemo.properties")
@ConfigurationProperties("com.spring.properties")
public class PropertiesDemo {

    private int value1;
    private int value2;
    private int value3;
}
