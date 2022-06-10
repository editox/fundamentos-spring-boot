package com.edito.fundamentos.configuration;

import com.edito.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation() {
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationSum() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationWithDepency(MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public Yema beanOperationYema() {
        return new YemaImplements();
    }

    @Bean
    public Clara beanOperationClara(Yema yema) {
        return new ClaraImplement(yema);
    }
}
