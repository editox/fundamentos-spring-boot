package com.edito.fundamentos.bean;

public class ClaraImplement implements Clara{
    Yema yema;
    public ClaraImplement(Yema yema) {
        this.yema = yema;
    }
    @Override
    public void print() {
        yema.numberOfChikens();
        System.out.println("Contengo " + yema.numberOfChikens() + " pollitos :3");
    }
}
