package com.edito.fundamentos.configuration;


import com.edito.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:conection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("$jdbc.url")
    private String url;
    @Value("$driver")
    private String driver;
    @Value("$username")
    private String username;
    @Value("$password")
    private String password;

    @Bean
    public DataSource dataSource(){

        return DataSourceBuilder.create()
                .driverClassName(this.driver)
                .url(this.url)
                .username(this.username)
                .password(this.password)
                .build();
    }

}
