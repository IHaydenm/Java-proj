
package com.mycompany.mavenproject1;

public class Cuadrado{
    // atributos 
    double longitud;

//constructor del cuadrado lol
    public Cuadrado(double longitud) {
        this.longitud = longitud;
    }


    public double diagonal() {
    this.longitud = Math.sqrt(longitud*longitud +  longitud*longitud);
    return longitud;
    }

    public double perimeter() {
    double perimeter = longitud * 4;
    return perimeter;
    }

    public double area() {
        double area= longitud*longitud;
        return area;
    }

}