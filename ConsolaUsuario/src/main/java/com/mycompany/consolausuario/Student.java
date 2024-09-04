package com.mycompany.consolausuario;
import java.util.Scanner;

public class Student {
    String studentN[] = new String[10];
    int alumNum; 
    public Student(String studentN[]){
        this.studentN = studentN;
    }
    public String setStudentName(){
            System.out.println("Sistema de registro de nombres de alumnos. Por favor sigua las instrucciones.\nA que alumno quiere modificar su nombre (escriba el numero del alumno p.e: 5).\n\nNumero del alumno: ");
            Scanner alum = new Scanner(System.in);
            alumNum = alum.nextInt();
            System.out.println("Estamos modificando el nombre del alumno " + alumNum + "\nEscribe el nombre del alumno: ");
            Scanner alumName = new Scanner(System.in);
            
            this.studentN[alumNum] = alumName.nextLine();
            System.out.println(this.studentN[alumNum]);
            System.out.println("Datos guardados.");
        return studentN[alumNum];
    }
    
    public String getStudentName(){
        
        for (int i=0; i<=9;i++){
            System.out.println(i+"." + studentN[i]);
        }
       return studentN[1];
    }
}