package com.mycompany.consolausuario;
import java.util.Scanner;

public class ConsolaUsuario {
    String alumnoN[]; 
    String varIn;
    public static void main(String[] args) {
        System.out.println("Bienvenido. Por favor, indicanos tu nombre de usuario:  ");
        Scanner name = new Scanner(System.in);
        String userName = name.nextLine();
        while(){
            System.out.println("Bienvenido al menu " + userName + "\n");
            Scanner sVar = new Scanner(System.in);
            String varIn = sVar.nextLine();
            switch(varIn){
                case "nombres":
                    System.out.println("Systema de registro de nombres de alumnos. Por favor sigue las instrucciones que siguen");
                    break;
                case "genero":
                    //acciones
                    break;
                case "matricula":
                    //acciones
                    break;
                case "carrera":
                    //acciones
                    break;
                case "semestre":
                    //acciones
                    break;
                case "credencial":
                    //acciones
                    break;
                case "salir":
                    System.exit(0);
                    break;
                default:    
                    System.out.println("La seleccion del menu no fue inteligible, intente otra vez\n");
            }
        }
    }
}
