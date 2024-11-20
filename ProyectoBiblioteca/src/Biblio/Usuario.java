package Biblio;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Usuario extends Prestamos{
    /*VARIABLES*/
    Scanner sc = new Scanner(System.in);
    String yes = "si";
    String id;
    String name;
    String typeUser;
    int op = 0;
    int wantsOut = 0;
    /*VARIABLES*/
    public char CheckForUser(Boolean keepsGoing){
        while (keepsGoing) {
            /*THIS SECTION OF THE PROGRAM WILL ASK THE USER TO INDICATE FOR WHICH ATRIBUTE SEARCH*/
            System.out.println("CHECAREMOS SI EL USUARIO ESTA EN EL SISTEMA.\tTENEMOS ESTAS OPCIONES PARA CHECAR POR EL USUARIO.\n\n1. BUSCAR POR NOMBRE\t 2. BUSCAR POR ID\t 3. BUSCAR POR TIPO DE USUARIO (ALUMNO O PROFESOR)\t4. ELIMINAR A UN USUARIO DEL SISTEMA\t5. REGRESAR AL MENU PRINCIPAL\n\nPARA SELECIONAR UNA OPCION ESCRIBE EL NUMERO DEL INDICE\tTU SELECION: ");
            try{
                sc = new Scanner(System.in);
                op = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("EL VALOR QUE HA INSERTADO ES INVALIDO, INTENTE OTRA VEZ INTRODUCIENDO UN VALOR NUMERICO VALIDO.");
            }
            switch (op) {
                case 1:
                    System.out.println("UN SEGUNDO POR FAVOR\n\n");
                    TimeOut();
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL NOMBRE DEL USUARIO SI YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut = true;
                    while(getsOut){
                        TimeOut();
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA EL NOMBRE DEL USUARIO: ");
                        sc = new Scanner(System.in);
                        String nameTransform = sc.nextLine();
                        String tempNameString = nameTransform.toLowerCase() + ".txt";
                        File usersFile = new File(Prestamos.myPCPath, tempNameString);   
                        if(usersFile.exists()){
                            TimeOut();
                            System.out.println("EL USUARIO YA HA ESTADO AQUI");
                            TimeOut();
                            GetUserData(usersFile);
                            System.out.println("QUIERES CAMBIAR DATOS DEL USUARIO? \tESCRIBE SI O NO: ");
                            sc = new Scanner(System.in);
                            String tempOption = sc.nextLine();
                            String op2 = tempOption.toLowerCase();
                            if(op2.equals(yes)){
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                try {
                                    sc = new Scanner(System.in);
                                    wantsOut = sc.nextInt();
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
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nEL USUARIO NO HA ESTADO AQUI ANTES, VAMOS A CREAR UN PERFIL DE USUARIO: ");
                                System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                try {
                                    sc = new Scanner(System.in);
                                    wantsOut = sc.nextInt();
                                }catch(InputMismatchException e){
                                    e.printStackTrace();
                                }
                                if(wantsOut!=1){
                                    usersFile.createNewFile();
                                    ModifyUserData(usersFile);
                                    getsOut = false;
                                }/*IF BRACKETS*/
                                else{
                                    System.out.println("REGRESANDO");
                                    TimeOut();
                                    break;
                                }
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                        }/*ELSE IF FILE DOES NOT EXISTS*/
                    }/*WHILE BRACKETS*/
                    break;
                case 2:
                    System.out.println("UN SEGUNDO POR FAVOR\n\n");
                    TimeOut();
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL ID DEL USUARIO SI YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut2 = true;
                    while(getsOut2){
                        TimeOut();
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA EL ID DEL USUARIO: ");
                        sc = new Scanner(System.in);
                        String idTransform = sc.nextLine();
                        String tempIdString = "2. ID DEL USUARIO: " + idTransform;
                        String finalUserFilePath = " ";
                        File userIdPath = null;
                        finalUserFilePath = CheckForUserId(tempIdString);
                        if(finalUserFilePath!=" "){
                            TimeOut();
                            System.out.println("EL USUARIO YA HA ESTADO AQUI");
                            TimeOut();
                            userIdPath = new File(Prestamos.myPCPath, finalUserFilePath);
                            GetUserData(userIdPath);
                            System.out.println("QUIERES CAMBIAR DATOS DEL USUARIO? \tESCRIBE SI O NO: ");
                            sc = new Scanner(System.in);
                            String tempOption = sc.nextLine();
                            String op2 = tempOption.toLowerCase();
                            if(op2.equals(yes)){
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                try {
                                    sc = new Scanner(System.in);
                                    wantsOut = sc.nextInt();
                                }catch(InputMismatchException e){
                                    e.printStackTrace();
                                }
                                if(wantsOut!=1){
                                    ModifyUserData(userIdPath);
                                    getsOut2 = false;
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
                                getsOut2 = false;
                            }/*ELSE BRACKETS */
                        }/*IF BRACKETS*/
                        else{
                            try{
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nEL USUARIO NO HA ESTADO AQUI ANTES, VAMOS A CREAR UN PERFIL DE USUARIO: ");
                                System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                try {
                                    sc = new Scanner(System.in);
                                    wantsOut = sc.nextInt();
                                }catch(InputMismatchException e){
                                    e.printStackTrace();
                                }
                                if(wantsOut!=1){
                                    System.out.println("NECESITO UN PREELIMINAR DEL NOMBRE DEL USUARIO. POR FAVOR PROPORCIONA EL NOMBRE DEL USUARIO A CONTINUACION: ");
                                    sc = new Scanner(System.in);
                                    String tempUserNameString = sc.nextLine();
                                    String userNameString = tempUserNameString.toLowerCase();
                                    userIdPath = new File(Prestamos.myPCPath, userNameString + ".txt");
                                    userIdPath.createNewFile();
                                    ModifyUserData(userIdPath);
                                    getsOut2 = false;
                                }/*IF BRACKETS*/
                                else{
                                    System.out.println("REGRESANDO");
                                    TimeOut();
                                    break;
                                }
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                        }/*ELSE IF FILE DOES NOT EXISTS*/
                    }/*WHILE BRACKETS*/
                    break;
                case 3:
                    System.out.println("UN SEGUNDO POR FAVOR\n\n");
                    TimeOut();
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL TIPO DE USUARIO SI YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut3 = true;
                    while(getsOut3){
                        TimeOut();
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA EL TIPO DEL USUARIO (ALUMNO/PROFESOR): ");
                        sc = new Scanner(System.in);
                        String typeTransform = sc.nextLine();
                        String tempTypeString = "3. ES ALUMNO O PROFESOR? " + typeTransform.toUpperCase();
                        List <String> finalUserFilePath = new ArrayList<String>();
                        File userIdPath = null;
                        finalUserFilePath = CheckForUserType(tempTypeString);
                        System.out.println("ESTOS SON LOS ARCHIVOS CON " + typeTransform.toUpperCase() + " COMO USUARIOS\n\n");
                        for(int k =0;k<finalUserFilePath.size();k++){
                           System.out.println((k+1) + ".- " + finalUserFilePath.get(k));
                        }
                        System.out.println("\nSELECCIONA UNO PARA REVISAR SUS CONTENIDOS: ");
                        sc = new Scanner(System.in);
                        int tempChoosing = sc.nextInt();
                        String childFilePath = finalUserFilePath.get((tempChoosing-1));
                            TimeOut();
                            userIdPath = new File(Prestamos.myPCPath, childFilePath);
                            GetUserData(userIdPath);
                            System.out.println("QUIERES CAMBIAR DATOS DEL USUARIO? \tESCRIBE SI O NO: ");
                            sc = new Scanner(System.in);
                            String tempOption = sc.nextLine();
                            String op2 = tempOption.toLowerCase();
                            if(userIdPath.exists()){
                                if(op2.equals(yes)){
                                    /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                    System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                    try {
                                        sc = new Scanner(System.in);
                                        wantsOut = sc.nextInt();
                                    }catch(InputMismatchException e){
                                        e.printStackTrace();
                                    }
                                    if(wantsOut!=1){
                                        ModifyUserData(userIdPath);
                                        getsOut3 = false;
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
                                    getsOut3 = false;
                                }/*ELSE BRACKETS*/
                            }/*IF BRACKETS*/
                            else{
                                try{
                                    /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                    System.out.println("\n\nEL USUARIO NO HA ESTADO AQUI ANTES, VAMOS A CREAR UN PERFIL DE USUARIO: ");
                                    System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                    try {
                                        sc = new Scanner(System.in);
                                        wantsOut = sc.nextInt();
                                    }catch(InputMismatchException e){
                                        e.printStackTrace();
                                    }
                                    if(wantsOut!=1){
                                        System.out.println("NECESITO UN PREELIMINAR DEL NOMBRE DEL USUARIO. POR FAVOR PROPORCIONA EL NOMBRE DEL USUARIO A CONTINUACION: ");
                                        sc = new Scanner(System.in);
                                        String tempUserNameString = sc.nextLine();
                                        String userNameString = tempUserNameString.toLowerCase();
                                        userIdPath = new File(Prestamos.myPCPath, userNameString + ".txt");
                                        userIdPath.createNewFile();
                                        ModifyUserData(userIdPath);
                                        getsOut3 = false;
                                    }/*IF BRACKETS*/
                                    else{
                                        System.out.println("REGRESANDO");
                                        TimeOut();
                                        break;
                                    }
                            }catch(IOException e){
                                e.printStackTrace();
                            }
                        }/*ELSE BRACKETS*/
                    }/*WHILE BRACKETS*/
                    break;
                case 4:
                Boolean getsOut4 = true;
                while(getsOut4){
                    System.out.println("A CUAL DE LOS USUARIOS QUIERES BORRAR DEL SISTEMA?\n\n");
                    File userDataPath = new File (Prestamos.myPCPath);/*GETTING FILES FROM PARENT */
                    String[] ArchNames = userDataPath.list();
                    for(int i=0; i < ArchNames.length; i++){/*GIVING AN ARRAY THE NAMES FORM THE FILES INSIDE THE PARENT*/
                        System.out.println(i+1 + ". " + ArchNames[i]);/*LISTING FILES INSIDE REPOSITORY*/
                    } /*ERRASE AFTER TESTS*/
                    System.out.println("ESTOS SON LOS ARCHIVOS. AQUELLOS QUE SON .TXT SON ARCHIVOS DE USUARIOS. POR FAVOR SELECCIONA UNO DE ESTOS, INSERTANDO EL INCISO QUE SE VE A LA IZQUIERDA DEL ARCHIVO");
                    sc = new Scanner(System.in);
                    int fileOption = sc.nextInt();
                    File fileErrasing = new File(Prestamos.myPCPath, ArchNames[(fileOption-1)]);
                    getsOut4 = ErrasingUser(fileErrasing);
                }/*WHILE BRACKETS*/
                    break;
                case 5:
                keepsGoing = false;
                    break;
                default:
                    break;
            }/*SWITCH CASE BRACKETS*/        
        }/*MAIN WHILE BRACKETS*/
        return ' ';
}/*CHEKINGFORUSER BRACKETS*/
private void GetUserData(File userFile){
    BufferedReader myBufferedReader = null;
    BufferedReader bufRead = null;
    System.out.println("VAMOS A MODIFICAR LOS DATOS DEL USUARIO:\n\n");
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
private void ModifyUserData(File userFile){
    PrintWriter myPrintWriter = null;
    FileWriter myFileWriter = null;
    String askUserName = "1. NOMBRE DEL USUARIO: "; 
    String askUserId = "2. ID DEL USUARIO: ";
    String askUserType = "3. ES ALUMNO O PROFESOR? ";
    List <String> userData = new ArrayList<String>();
        System.out.println("\n\nCONTINUANDO");
        TimeOut();
        System.out.println("\n\n"+ askUserName);
            sc = new Scanner(System.in);
            String tempUserName = sc.nextLine();
            String userName = askUserName + tempUserName.toUpperCase();
            userData.add(userName); /*ADDING THE DATA TO A LIST */
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + askUserId);
            sc = new Scanner(System.in);
            String tempUserId = sc.nextLine();
            String userId = askUserId + tempUserId.toUpperCase();
            userData.add(userId); /*ADDING THE DATA TO A LIST */
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + askUserType + "ESCRIBE ALUMNO O EN CUYO CASO PROFESOR: ");
            sc = new Scanner(System.in);
            String tempUserType = sc.nextLine();
            String userType = askUserType + tempUserType.toUpperCase();
            userData.add(userType); /*ADDING THE DATA TO A LIST */
    try {
        myFileWriter = new FileWriter(userFile);
        myPrintWriter = new PrintWriter(myFileWriter);
        for(int i=0;i<userData.size();i++){
            String tempStringWriter = userData.get(i);
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
private void TimeOut(){
    /*SLEEP TIMEOUT*/
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}/*TIME OUT VOID*/
private String CheckForUserId(String userId){
    File userFile = new File(Prestamos.myPCPath); 
    String[] fileArrayList = userFile.list();
    BufferedReader myBufferedReader = null;
    BufferedReader bufRead = null;
    String tempFinalUserPath = " ";
    for(int i=0; i<fileArrayList.length; i++){
        File tempUserFile = new File(Prestamos.myPCPath, fileArrayList[i]);
        String finalUserPath = " ";
        try {
            FileReader ReadingFile = new FileReader(tempUserFile);
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
                if(tempUserFile.exists()){
                    System.out.println("BUSCANDO...\n");
                    TimeOut();
                }
                else{
                    tempUserFile.createNewFile();
                }
                FileReader myFileReader = new FileReader(tempUserFile);
                myBufferedReader = new BufferedReader(myFileReader);
                List <String> userData = new ArrayList<String>();
                for(int j=0;j<rowCounter;j++){
                        String tempLineReader = " ";
                        tempLineReader = myBufferedReader.readLine().toString();
                        userData.add(tempLineReader);
                        if(userId.equals(userData.get(j))){
                            finalUserPath = tempUserFile.getName();
                            tempFinalUserPath = finalUserPath;
                            j = rowCounter--;
                            int l = fileArrayList.length;
                            i = l--;
                        }
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
    }/*FOR CYCLE*/
    return tempFinalUserPath;
}/*CHECK FOR USER ID*/
private List <String> CheckForUserType(String userType){
    List <String> relevantFiles = new ArrayList <String>();
    File userFile = new File(Prestamos.myPCPath); 
    String[] fileArrayList = userFile.list();
    BufferedReader myBufferedReader = null;
    BufferedReader bufRead = null;
    String tempFinalUserPath = " ";
    for(int i=0; i<fileArrayList.length; i++){
        File tempUserFile = new File(Prestamos.myPCPath, fileArrayList[i]);
        String finalUserPath = " ";
        try {
            FileReader ReadingFile = new FileReader(tempUserFile);
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
                if(tempUserFile.exists()){
                    System.out.println("BUSCANDO...\n");
                    TimeOut();
                }
                else{
                    tempUserFile.createNewFile();
                }
                FileReader myFileReader = new FileReader(tempUserFile);
                myBufferedReader = new BufferedReader(myFileReader);
                List <String> userData = new ArrayList<String>();
                for(int j=0;j<rowCounter;j++){
                        String tempLineReader = " ";
                        tempLineReader = myBufferedReader.readLine().toString();
                        userData.add(tempLineReader);
                        if(userType.equals(userData.get(j))){
                            finalUserPath = tempUserFile.getName();
                            tempFinalUserPath = finalUserPath;
                            relevantFiles.add(tempFinalUserPath);
                            j = rowCounter--;
                            int l = fileArrayList.length;
                            i = l--;
                        }
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
    }/*FOR CYCLE*/
    return relevantFiles;
}/*CHECK FOR USER TYPE*/
private Boolean ErrasingUser(File userFile){
    Boolean out = true;
    GetUserData(userFile);
    System.out.println("ESTAS SEGURO DE QUE QUIERES BORRAR ESTE USUARIO DEL SISTEMA\n\nSI/NO: ");
    sc = new Scanner(System.in);
    String optionTransform = sc.nextLine();
    String optionSel = optionTransform.toLowerCase();
    if((optionSel.equals(yes))){
        userFile.delete();    
        System.out.println("EL USUARIO SE BORRO DEL SISTEMA\n\n");
        out = false;
    }
    else{
        System.out.println("REGRESANDO...\n\n");
        out = true;
    }
    return out;
}/*CHECK FOR ERRASING USER*/
}/*MAIN CLASS BRACKETS*/

