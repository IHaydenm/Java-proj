package com.mycompany.consolausuario;
import java.util.Scanner;
public class StudentSemest {
    int semest[] = new int[10];
    int alumNum;
    public StudentSemest(int semest[]){
         this.semest = semest;
    }
       public int setStudentSemester(){
        System.out.println("Sistema de registro de semestre de alumnos. Por favor sigua las instrucciones.\nA que alumno quiere modificar su semestre (escriba el numero del alumno p.e: 5).\n\nNumero del alumno: ");
            Scanner alum = new Scanner(System.in);
            alumNum = alum.nextInt();
            System.out.println("Estamos modificando el semestre que cursa el alumno " + alumNum + "\nIndique el numero de semestre que cursa el alumno: ");
            Scanner alumSem = new Scanner(System.in);
            semest[alumNum] = alumSem.nextInt();
            System.out.println("Datos guardados.");
        return semest[alumNum];
   }
}
