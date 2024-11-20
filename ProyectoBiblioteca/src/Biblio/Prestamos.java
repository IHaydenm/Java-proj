package Biblio;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Prestamos {
    /*VARIABLES*/
    String bookRequest = "PRESTAMO DE LIBRO ";
    String teacher = "3. ES ALUMNO O PROFESOR? PROFESOR";
    String student = "3. ES ALUMNO O PROFESOR? ALUMNO";
    static String myPCPath = "C:/Users/katco/Documents/les javas/ProyectoBiblioteca/src/Biblio";
    Scanner sc = new Scanner(System.in);
    Boolean keepsGoing = true; 
    int wantsOut = 0;
    /*VARAIBLES*/
public char AsksForBook(Boolean keepsGoing){
    while(keepsGoing){
        System.out.print("QUE USUARIO QUIERE HACER EL PEDIR PRESTADO UN LIBRO?\n\nESCRIBE SU NOMBRE COMPLETO: ");
        String userNamePath = sc.nextLine();
        String tempNamePath = userNamePath.toUpperCase() + ".txt";
        File userInformation = new File(myPCPath, tempNamePath);/*SEARCHING FOR THE FILE*/
        GetUserData(userInformation);
        String checkType = CheckForUserType(tempNamePath);
        if(checkType.equals(teacher)){/*CHECKS IF THE USER IS A TEACHER*/
            System.out.println("\n\nEL USUARIO ES UN PROFESOR. EMPEZAREMOS A REALIZAR SU REGISTRO POR EL LIBRO");
            File fileForBookRequest = new File(myPCPath, bookRequest + userInformation.getName());
            ModifyRequestData(fileForBookRequest);
        }/*IF BRACKETS*/
        else if(checkType.equals(student)){/*CHECKS IF THE USER IS A STUDENT*/
            Boolean getsOut = true;
            while(getsOut){
                System.out.println("\n\nEL USUARIO ES UN ALUMNO. EMPEZAREMOS A REALIZAR SU REGISTRO");
                File fileForBookRequest = new File(myPCPath, bookRequest + userInformation.getName());
                ModifyRequestData(fileForBookRequest);
                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                try {
                    sc = new Scanner(System.in);
                    wantsOut = sc.nextInt();
                }catch(InputMismatchException e){
                    e.printStackTrace();
                }/*CATCH BRACKETS*/
                if(wantsOut!=1){
                    ModifyRequestData(fileForBookRequest);
                    getsOut = false;
                }/*IF BRACKETS*/
                else{
                    System.out.println("REGRESANDO");
                    TimeOut();
                    getsOut = false;
                    break;
                }/*ELSE BRACKETS*/
            }/*INNER WHILE BRACKETS*/
        }/*ELSE IF BRACKETS*/
    }/*WHILE BRACKETS*/
    return ' ';
}/*ASKS FOR BOOK*/
private void GetUserData(File userFile){
    BufferedReader myBufferedReader = null;
    BufferedReader bufRead = null;
    System.out.println("VAMOS A REVISAR LOS DATOS DEL USUARIO:\n\n");
    try {
        FileReader ReadingFile = new FileReader(userFile);
        bufRead = new BufferedReader(ReadingFile);
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
            if(userFile.exists()){
                System.out.println("GUARDANDO INFORMACION");
                TimeOut();
            }
            else{
                userFile.createNewFile();
            }
            FileReader myFileReader = new FileReader(userFile);
            myBufferedReader = new BufferedReader(myFileReader);
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
    }finally{
        try {
            bufRead.close();
            myBufferedReader.close();    
        } catch (IOException e) {
            System.out.println("HUBO UN ERROR AL LEER LOS DATOS");
        }
    }
}/*GET USER DATA BRACKETS*/
private void TimeOut(){
    /*SLEEP TIMEOUT*/
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}/*TIME OUT VOID*/
private String CheckForUserType(String userPath){
    String isTeacherorStudent = " ";
    File userFile = new File(Prestamos.myPCPath, userPath); 
    BufferedReader myBufferedReader = null;
    BufferedReader bufRead = null;
        try {
            FileReader ReadingFile = new FileReader(userFile);
            bufRead = new BufferedReader(ReadingFile);
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
                if(userFile.exists()){
                    System.out.println("BUSCANDO...\n");
                    TimeOut();
                    FileReader myFileReader = new FileReader(userFile);
                    myBufferedReader = new BufferedReader(myFileReader);
                    List <String> userData = new ArrayList<String>();
                    for(int j=0;j<rowCounter;j++){
                        String tempLineReader = " ";
                        tempLineReader = myBufferedReader.readLine().toString();
                        userData.add(tempLineReader);
                        String tempTypeReader = userData.get(j);
                        if(tempTypeReader.equals(teacher)){
                            isTeacherorStudent = userData.get(j);
                            j = rowCounter--;
                        }
                        else if(tempTypeReader.equals(student)){
                            isTeacherorStudent = userData.get(j);
                            j = rowCounter--;
                        }
                }/*SECOND FOR CYCLE BRACKETS*/
                }
                else{
                    System.out.println("NO EXISTE UN USUARIO CON EL NOMBRE ESPECIFICADO ANTERIORMENTE");
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bufRead.close();
                myBufferedReader.close();    
            } catch (IOException e) {
                System.out.println("HUBO UN ERROR AL LEER LOS DATOS");
            }
        }
        return isTeacherorStudent;
    }/*CHECK FOR USER TYPE*/
    private void ModifyRequestData(File userRequestFile){
    PrintWriter myPrintWriter = null;
    FileWriter myFileWriter = null;
    String requestedBook = "1. NOMBRE DEL LIBRO SOLICITADO: "; 
    String askUserName = "2. NOMBRE DEL USUARIO QUE SOLICITA EL LIBRO: ";
    String askDate = "3. FECHA DE SOLICITUD: ";
    List <String> bookData = new ArrayList<String>();
        System.out.println("\n\nCONTINUANDO");
        TimeOut();
        System.out.println("\n\n"+ requestedBook);
            sc = new Scanner(System.in);
            String tempBookName = sc.nextLine();
            String bookName = requestedBook + tempBookName.toUpperCase();
            bookData.add(bookName); /*ADDING THE DATA TO A LIST */
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + askUserName);
            sc = new Scanner(System.in);
            String tempUserName = sc.nextLine();
            String userName = askUserName + tempUserName.toUpperCase();
            bookData.add(userName); /*ADDING THE DATA TO A LIST */
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + askDate + "ESCRIBE ALUMNO O EN CUYO CASO PROFESOR: ");
            sc = new Scanner(System.in);
            String tempSetDate = sc.nextLine();
            String bookReqDate = askDate + tempSetDate.toUpperCase();
            bookData.add(bookReqDate); /*ADDING THE DATA TO A LIST */
    try {
        myFileWriter = new FileWriter(userRequestFile);
        myPrintWriter = new PrintWriter(myFileWriter);
        for(int i=0;i<bookData.size();i++){
            String tempStringWriter = bookData.get(i);
            myPrintWriter.println(tempStringWriter);
            System.out.println(tempStringWriter+"\n");/*DELETE*/
        }
    } catch (IOException e) {
        System.out.println("HUBO UN ERROR CARGANDO LOS DATOS AL ARCHIVO" + e.getMessage());
    }finally{
        try {
            myFileWriter.close();
            myPrintWriter.close();
        } catch (Exception e) {
            System.out.println("NO SE PUDIERON ESCRIBIR LOS DATOS AL SISTEMA");
        }
    }
}/*MODIFY USER DATA*/
}/*PRESTAMOS BRACKETS*/

