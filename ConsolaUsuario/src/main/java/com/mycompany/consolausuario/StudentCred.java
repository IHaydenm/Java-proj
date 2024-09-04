package com.mycompany.consolausuario;
import java.util.Scanner;
public class StudentCred {
    Boolean cred[] = new Boolean[10];
    String credCond;
    int alumNum;
    public StudentCred(Boolean cred[]){
           this.cred = cred;
    }
    public Boolean knowCredentials(){
       System.out.println("Sistema de registro de credenciales de alumnos. Por favor sigua las instrucciones.\nA que alumno quiere modificar sus credenciales (escriba el numero del alumno p.e: 5).\n\nNumero del alumno: ");
            Scanner alum = new Scanner(System.in);
            alumNum = alum.nextInt();
            System.out.println("Estamos modificando las credenciales del alumno " + alumNum + "\nIndique si el alumno tiene credencial con 'si' o 'no': ");
            Scanner alumCred = new Scanner(System.in);
            credCond = alumCred.nextLine();
            if(credCond.equals("si")){
                cred[alumNum] = true;
                System.out.println("Datos guardados.");
            }
            else if(credCond.equals("no")){
                cred[alumNum] = false;
                System.out.println("Datos guardados.");
            }
            else{
                System.out.println("Invalido, intente otra vez");
            }
        return cred[alumNum];
   }
}
