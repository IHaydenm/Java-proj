
package com.mycompany.consolausuario;

import java.util.Scanner;

public class StudentGend {
    String sGender[] = new String[10];
    int alumNum;
    public StudentGend(String sGender[]){
        this.sGender = sGender;
}
    public String setStudentGender(){
       System.out.println("Sistema de registro de genero de alumnos. Por favor sigua las instrucciones.\nA que alumno quiere modificar su genero (escriba el numero del alumno p.e: 5).\n\nNumero del alumno: ");
            Scanner alum = new Scanner(System.in);
            alumNum = alum.nextInt();
            System.out.println("Estamos modificando el genero del alumno " + alumNum + "\nIndique el genero del alumno: ");
            Scanner alumGend = new Scanner(System.in);
            sGender[alumNum] = alumGend.nextLine();
            System.out.println("Datos guardados.");
        return sGender[alumNum];
   }
}
