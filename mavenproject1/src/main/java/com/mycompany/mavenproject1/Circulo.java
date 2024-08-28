package com.mycompany.mavenproject1;


public class Circulo {
    double radi;
    
    
    public Circulo(double radi){
        this.radi = radi;
    }
    public double circunf(){
       double circunf = (radi*2)*3.1519;
       return circunf;
    }
    public double areaCi(){
        double areaCi = (radi*radi)*3.1519;
        return areaCi;
    }
}
