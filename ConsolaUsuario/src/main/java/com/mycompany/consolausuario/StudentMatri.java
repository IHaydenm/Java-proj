package com.mycompany.consolausuario;
import java.util.Scanner;
public class StudentMatri {
    int matri[] = new int[10];
    int alumNum;
            public StudentMatri(int matri[]){
                this.matri = matri;
            }
            public int setStudentNumber(){
            System.out.println("Sistema de registro de matricula de alumnos. Por favor sigua las instrucciones.\nA que alumno quiere modificar su matricula (escriba el numero del alumno p.e: 5).\n\nNumero del alumno: ");
            Scanner alum = new Scanner(System.in);
            alumNum = alum.nextInt();
            System.out.println("Estamos modificando la matricula del alumno " + alumNum + "\nIndique el numero de matricula del alumno: ");
            Scanner alumMatr = new Scanner(System.in);
            matri[alumNum] = alumMatr.nextInt();
            System.out.println("Datos guardados.");
        return matri[alumNum];
   }
}
