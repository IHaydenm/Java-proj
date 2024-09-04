package com.mycompany.consolausuario;
import java.util.Scanner;
public class StudentMajor {
    String sCarr[] = new String[10];
    int alumNum;
    public StudentMajor(String sCarr[]){
    this.sCarr = sCarr;
}
     public String setStudentMajor(){
       System.out.println("Sistema de registro de carrera de alumnos. Por favor sigua las instrucciones.\nA que alumno quiere modificar su carrera (escriba el numero del alumno p.e: 5).\n\nNumero del alumno: ");
            Scanner alum = new Scanner(System.in);
            alumNum = alum.nextInt();
            System.out.println("Estamos modificando la carrera que cursa el alumno " + alumNum + "\nEscriba el nombre de la carrera que cursa el alumno: ");
            Scanner alumcarr = new Scanner(System.in);
            sCarr[alumNum] = alumcarr.nextLine();
            System.out.println("Datos guardados.");
        return sCarr[alumNum];
   }
}
