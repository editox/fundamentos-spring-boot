package com.edito.fundamentos.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ComponentTwoImplement implements ComponentDependency{
    public void saludar() {
        System.out.println("Saludando desde mi componente 2");
    }
}
