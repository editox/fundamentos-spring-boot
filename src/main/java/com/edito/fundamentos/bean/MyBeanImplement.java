package com.edito.fundamentos.bean;

public class MyBeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde my implementación propia del bean");
    }
}
