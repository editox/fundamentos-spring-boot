package com.edito.fundamentos.controller;

import com.edito.fundamentos.bean.BeanProperties;
import com.edito.fundamentos.bean.BeanPropertiesImplement;
import com.edito.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public BeanProperties beanOperationProperties() {
        return new BeanPropertiesImplement(name, apellido);
    }
}
