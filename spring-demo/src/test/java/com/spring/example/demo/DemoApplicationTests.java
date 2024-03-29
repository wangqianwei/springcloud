package com.spring.example.demo;

import com.spring.example.demo.annotation.PropertiesDemo;
import com.spring.example.demo.annotation.ValueAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private ValueAnnotation valueAnnotation;

    @Resource
    private PropertiesDemo propertiesDemo;

    @Test
    public void contextLoads() {

        log.info("{}", valueAnnotation);
        valueAnnotation.getSystemPropertiesMap().entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });
    }

    @Test
    public void propertiesDemo() {

        log.info("{}", propertiesDemo);
    }
}
