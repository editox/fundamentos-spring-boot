package com.edito.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
    private MyOperation myOperation;
    private final Log LOGGER = LogFactory.getLog(MyOperation.class);
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al método printWithDependency");
        int numero = 5;
        LOGGER.debug("El numero enviado como parametro a la dependencia operation es: " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un bean con dependencia");
    }
}
