package com.edito.fundamentos.bean;

public class BeanPropertiesImplement implements BeanProperties{
    private String name;
    private String apellido;

    public BeanPropertiesImplement(String name, String apellido) {
        this.name = name;
        this.apellido = apellido;
    }

    @Override
    public String print() {
        return "Yo soy" + name + " " + apellido +", chaito.";
    }
}
