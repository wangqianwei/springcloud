package com.spring.example.demo.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource("classpath:value.properties")
public class ValueAnnotation {

    @Value("string value")
    private String stringValue;

    @Value("${value.from.file}")
    private String valueFromFile;

    @Value("${unknown.param:some default}")
    private String someDefault;

    @Value("${priority}")
    private String prioritySystemProperty;

    @Value("${listOfValues}")
    private String[] valuesArray;

    @Value("#{someBean.someValue}")
    private Integer someBeanValue;

    @Value("#{'${listOfValues}'.split(',')}")
    private List<String> valuesList;

    @Value("#{${valuesMap}}")
    private Map<String, Integer> valuesMap;

    @Value("#{systemProperties}")
    private Map<String, String> systemPropertiesMap;
}
