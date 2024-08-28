package com.mycompany.mavenproject1;

import java.util.Scanner;



    public class Mavenproject1{
        public static void main(String[] args) {
            
        // variables 
        double longitud;
        double radi;
        
        Scanner goben = new Scanner(System.in);
        System.out.print("Dame la longitud del cuadrado:\n");
        longitud = goben.nextDouble();
        
        Cuadrado mycuadrado = new Cuadrado(longitud);
        
        System.out.print("Dame el radio del circulo:\n");
        radi = goben.nextDouble();
          
        Circulo mycirc = new Circulo(radi);
        
        System.out.println("Valores del cuadrado: ");
        System.out.println("\nEl valor del perimetro es igual a: " + mycuadrado.perimeter() + "\nEl valor de la diagonal es igual a: " + mycuadrado.diagonal() + "\nEl valor del area es igual a: " + mycuadrado.area()); 
        System.out.println("Valores del circulo: ");
        System.out.println("\nEl valor del perimetro: " + mycirc.circunf() + "\n El area del circulo: " + mycirc.areaCi()); 
        
    }
}