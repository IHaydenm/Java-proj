package com.mycompany.consolausuario;
import java.util.Scanner;
public class ConsolaUsuario {
    public static void main(String[] args) {
        String studentN[] = new String[10]; 
        String sGender[] = new String[10];
        int matri[] = new int[10], semest[] = new int[10];
        String sCarr[] = new String[10];
        Boolean cred[] = new Boolean[10];
        String varIn;
        System.out.println("Bienvenido. Por favor, indicanos tu nombre de usuario:  ");
        Scanner name = new Scanner(System.in);
        String userName = name.nextLine();
        for(int i=0;i<=9;i++){
                studentN[i] = "";
                sGender[i] = "";
                matri[i] = 0;
                semest[i] = 0;
                sCarr[i] = "";
                cred[i]= false;          
            }
        Student myStuName = new Student(studentN);
        StudentGend myStuGend = new StudentGend(sGender);
        StudentMatri myStuMatri = new StudentMatri(matri);
        StudentSemest myStuSemest = new StudentSemest(semest);
        StudentMajor myStuMaj = new StudentMajor(sCarr);
        StudentCred myStuCred = new StudentCred(cred);  
        while(true){
            System.out.println("\nBienvenido al menu " + userName + "\n");
            System.out.println("Estas son las opciones del sistema: \nPara seleccionar una de estas, escribe el nombre de la opcion que necesitas.\n\n1. Nombre\n2. Genero\n3. Matricula\n4. Carrera\n5. Semestre\n6. Credencial\n\nOpcion a la que quieres acceder: ");
            Scanner sVar = new Scanner(System.in);
            varIn = sVar.nextLine();
            String varInL = varIn.toLowerCase();
            
            switch(varInL){
                case "nombre":
                        System.out.println(myStuName.setStudentName());
                    break;
                case "genero":
                        System.out.println(myStuGend.setStudentGender());
                    break;
                case "matricula":
                        System.out.println(myStuMatri.setStudentNumber());
                    break;
                case "carrera":
                        System.out.println(myStuMaj.setStudentMajor());
                    break;
                case "semestre":
                        System.out.println(myStuSemest.setStudentSemester());
                    break;
                case "credencial":
                        System.out.println(myStuCred.knowCredentials());
                    break;
                case "checar":
                        System.out.println("Que lista quieres revisar?\n\n1. Nombre\n2. Genero\n3. Matricula\n4. Carrera\n5. Semestre\n6. Credencial\n\nOpcion a la que quieres acceder: ");
                        Scanner sOp= new Scanner(System.in);
                        String sOpIn = sOp.nextLine();
                        String sOpL = sOpIn.toLowerCase();
                        switch(sOpL){
                            case "nombre":
                                 System.out.println(myStuName.getStudentName());
                                break;
                        }
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
