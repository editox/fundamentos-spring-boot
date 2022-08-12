package com.edito.fundamentos.configuration;

import com.edito.fundamentos.caseuse.GetUser;
import com.edito.fundamentos.caseuse.GetUserImplement;
import com.edito.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
