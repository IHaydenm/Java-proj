package Proy_Final_Biblio;
import java.util.*;
import java.util.concurrent.TimeoutException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

public class Usuario extends Libro{
    /*VARIABLES*/
    FileWriter myFileWriter;
    PrintWriter myPrintWriter;
    String yes = "si";
    String id;
    String name;
    String typeUser;
    int op = 0;
    boolean keepsGoing = true;
    int wantsOut = 0;
    /*VARIABLES*/
    public char CheckForUser(){
        while (keepsGoing) {
            /*THIS SECTION OF THE PROGRAM WILL ASK THE USER TO INDICATE FOR WHICH ATRIBUTE SEARCH*/
            System.out.println("CHECAREMOS SI EL USUARIO ESTA EN EL SISTEMA.\tTENEMOS ESTAS OPCIONES PARA CHECAR POR EL USUARIO.\n\n1. BUSCAR POR NOMBRE\t 2. BUSCAR POR ID\t 3. BUSCAR POR TIPO DE USUARIO (ALUMNO O PROFESOR)\n\nPARA SELECIONAR UNA OPCION ESCRIBE EL NUMERO DEL INDICE\tTU SELECION: ");
            try{
                Scanner sc = new Scanner(System.in);
                op = sc.nextInt();
                sc.close();
            } catch (InputMismatchException e) {
                System.out.println("EL VALOR QUE HA INSERTADO ES INVALIDO, INTENTE OTRA VEZ INTRODUCIENDO UN VALOR NUMERICO VALIDO.");
            }
            switch (op) {
                case 1:
                    System.out.println("UN SEGUNDO POR FAVOR");
                    TimeOut();
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL NOMBRE DEL USUARIO SI YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut = true;
                    while(getsOut){
                        TimeOut();
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA EL NOMBRE DEL USUARIO: ");
                        Scanner sc1 = new Scanner(System.in);
                        String nameTransform = sc1.nextLine() + ".txt";
                        String tempNameString = nameTransform.toLowerCase();
                        File usersFile = new File(Libro.myPCPath, tempNameString);   
                        if(usersFile.exists()){
                            TimeOut();
                            System.out.println("EL USUARIO YA HA ESTADO AQUI");
                            TimeOut();
                            GetUserData(usersFile);
                            System.out.println("QUIERES CAMBIAR DATOS DEL USUARIO? \tESCRIBE SI O NO: ");
                            Scanner sc2 = new Scanner(System.in);
                            String tempOption = sc2.nextLine();
                            String op2 = tempOption.toLowerCase();
                            if(op2.equals(yes)){
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                try {
                                    Scanner sc3 = new Scanner(System.in);
                                    wantsOut = sc3.nextInt();
                                }catch(InputMismatchException e){
                                    e.printStackTrace();
                                }
                                if(wantsOut!=1){
                                    ModifyUserData(usersFile);
                                    getsOut = false;
                                }/*IF BRACKETS*/
                                else{
                                    System.out.println("REGRESANDO");
                                    TimeOut();
                                    break;
                                }
                            }/*IF BRACKETS*/
                            else{
                                System.out.println("ESTAMOS REGRESANDO AL MENU, UN SEGUNDO");
                                TimeOut();
                                getsOut = false;
                            }/*ELSE BRACKETS */
                        }/*IF BRACKETS*/
                        else{
                            try{
                                usersFile.createNewFile();
                                System.out.println("se creo el archivo");/*DELETE AFTER TESTS */
                                ModifyUserData(usersFile);
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                        }/*ELSE IF FILE DOES NOT EXISTS*/
                    }/*WHILE BRACKETS*/
                    break;
                default:
                    break;
            }/*SWITCH CASE BRACKETS*/        
        }/*MAIN WHILE BRACKETS*/
        return ' ';
}/*CHEKINGFORUSER BRACKETS*/
private void GetUserData(File userFile){
    System.out.println("VAMOS A MODIFICAR LOS DATOS DEL USUARIO:\n\n");
    try {
        FileReader ReadingFile = new FileReader(userFile);
        BufferedReader bufRead = new BufferedReader(ReadingFile);
        /*DECLARING UNTIL WHICH POINT DOES THE FILE HAS INFORMATION (OTHER THAN NULL)*/
        boolean noInfo = true;
        String tempInformationCheck = " ";
        int rowCounter = 0;
        while(noInfo){
            if(tempInformationCheck==null){
                noInfo = false;
            }/*IF BRACKETS*/
            else{
                tempInformationCheck = bufRead.readLine();
                rowCounter++;
            }/*ELSE BRACKETS*/
        }/*INNER WHILE CYCLE*/
        rowCounter--;
        try {
            /*READING THE INFORMATION FORM THE FILE*/
            FileReader myFileReader = new FileReader(userFile);
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);
            List <String> userData = new ArrayList<String>();
            System.out.println("ESTOS SON LOS DATOS DEL USUARIO.");
            String fileDataReading = " ";
            for(int j=0;j<rowCounter;j++){
                    String tempLineReader = " ";
                    tempLineReader = myBufferedReader.readLine().toString();
                    userData.add(tempLineReader);
                    fileDataReading = userData.get(j);
                    System.out.println(fileDataReading);
            }/*SECOND FOR CYCLE BRACKETS*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}/*GET USER DATA BRACKETS*/
private void ModifyUserData(File userFile){
    String askUserName = "1. NOMBRE DEL USUARIO: "; 
    String askUserId = "2. ID DEL USUARIO: ";
    String askUserType = "3. ES ALUMNO O PROFESOR? ";
    List <String> userData = new ArrayList<String>();
        System.out.println("\n\nCONTINUANDO");
        TimeOut();
        System.out.println("\n\n"+ askUserName);
            Scanner sc4 = new Scanner(System.in);
            String tempUserName = sc4.nextLine();
            String userName = askUserName + tempUserName.toUpperCase();
            userData.add(userName); /*ADDING THE DATA TO A LIST */
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + askUserId);
            Scanner sc5 = new Scanner(System.in);
            String tempUserId = sc5.nextLine();
            String userId = askUserId + tempUserId.toUpperCase();
            userData.add(userId); /*ADDING THE DATA TO A LIST */
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + askUserType + "ESCRIBE ALUMNO O EN CUYO CASO PROFESOR: ");
            Scanner sc6 = new Scanner(System.in);
            String tempUserType = sc6.nextLine();
            String userType = askUserType + tempUserType.toUpperCase();
            userData.add(userType); /*ADDING THE DATA TO A LIST */
    try {
        myPrintWriter = new PrintWriter(userFile);
        for(int i=0;i<userData.size();i++){
            String tempStringWriter = userData.get(i);
            myPrintWriter.println(tempStringWriter);
            System.out.println(tempStringWriter+"\n");/*DELETE*/
        }
    } catch (IOException e) {
        System.out.println("HUBO UN ERROR CARGANDO LOS DATOS AL ARCHIVO" + e.getMessage());
    }
}/*MODIFY USER DATA*/
private void TimeOut(){
    /*SLEEP TIMEOUT*/
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}/*MAIN CLASS BRACKETS*/

