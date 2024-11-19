package Biblio;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Libros extends Prestamos {
    /*VARIABLES*/
    Scanner sc = new Scanner(System.in);
    String book = "LIBRO ";
    String titulo = "1.- TITULO DEL LIBRO: ";
    String autor = "2.- AUTOR: ";
    String year = "3.- AÑO DE PUBLICACION DEL LIBRO: ";
    String[] genero = new String[4];{
        genero[0] = "epico";
        genero[1] = "lirico";
        genero[2] = "dramatico";
        genero[3] = "didactico";
    }
    String genreTitle = "4.- GENERO: ";
    String Isbn = "5.- ISBN: ";
    String yes = "si";
    String id;
    String name;
    String typeUser;
    int op = 0;
    int wantsOut = 0;
    /*VARIABLES*/
    public char CheckForBook(Boolean keepsGoing){
        while (keepsGoing) {
            /*THIS SECTION OF THE PROGRAM WILL ASK THE USER TO INDICATE FOR WHICH ATRIBUTE SEARCH*/
            System.out.println("CHECAREMOS SI EL LIBRO ESTA EN EL SISTEMA.\tTENEMOS ESTAS OPCIONES PARA CHECAR POR EL LIBRO.\n\n1. BUSCAR POR NOMBRE DEL LIBRO/AGREGAR LIBRO AL SISTEMA\t 2. BUSCAR POR NOMBRE DEL AUTOR\t 3. BUSCAR POR AÑO DE PUBLICACION\t4. BUSCAR POR GENERO.\n\n5. BUSCAR POR ISBN\t6. BORRAR UN LIBRO DEL SISTEMA\t7. REGRESAR AL MENU PRINCIPAL\n\nPARA SELECIONAR UNA OPCION ESCRIBE EL NUMERO DEL INDICE\tTU SELECION: ");
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
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL NOMBRE DEL LIBRO SI YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut = true;
                    while(getsOut){
                        TimeOut();
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA EL NOMBRE DEL LIBRO: ");
                        sc = new Scanner(System.in);
                        String bookNameTransform = sc.nextLine();
                        String tempBookNameString = book + bookNameTransform.toLowerCase() + ".txt";
                        File bookFile = new File(Prestamos.myPCPath, tempBookNameString);   
                        if(bookFile.exists()){
                            TimeOut();
                            System.out.println("ENCONTRE EL LIBRO");
                            TimeOut();
                            GetBookData(bookFile);
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
                                    ModifyBookData(bookFile);
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
                                System.out.println("\n\nEL LIBRO INGRESADO NO SE ENCUENTRA EN EL SISTEMA, VAMOS A GUARDAR SU INFORMACION EN EL SISTEMA: ");
                                System.out.println("\n\nEMPEZAREMOS A GUARDAR LOS DATOS.\tSI DESEAS VOLVER, ESCRIBE 1 EN EL TECLADO Y DA ENTER. SI DESEAS CONTINUAR ESCRIBE 0 Y DA ENTER: ");
                                try {
                                    sc = new Scanner(System.in);
                                    wantsOut = sc.nextInt();
                                }catch(InputMismatchException e){
                                    e.printStackTrace();
                                }
                                if(wantsOut!=1){
                                    bookFile.createNewFile();
                                    ModifyBookData(bookFile);
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
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL NOMBRE DEL AUTOR DEL LIBRO SI YA SE ENCUENTRA EN EL SISTEMA.");
                    List <String> finalFilePath = new ArrayList<String>();
                    Boolean getsOut2 = true;
                    while(getsOut2){
                        TimeOut();
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA EL NOMBRE DEL AUTOR DE LIBRO: ");
                        sc = new Scanner(System.in);
                        String authorNameTransform = sc.nextLine();
                        String tempAuthorNameString = autor + authorNameTransform.toUpperCase();
                        File bookAuthorPath = null;
                        finalFilePath = CheckForBookYear(tempAuthorNameString);
                        System.out.println("ESTOS SON LOS ARCHIVOS CON " + tempAuthorNameString + " CON AÑO DE PUBLICACION\n\n");
                        for(int k =0;k<finalFilePath.size();k++){
                           System.out.println((k+1) + ".- " + finalFilePath.get(k));
                        }
                        System.out.println("\nSELECCIONA UNO PARA REVISAR SUS CONTENIDOS: ");
                        sc = new Scanner(System.in);
                        int tempChoosing = sc.nextInt();
                        String childFilePath = finalFilePath.get((tempChoosing-1));
                        TimeOut();
                        bookAuthorPath = new File(Prestamos.myPCPath, childFilePath);
                        GetBookData(bookAuthorPath);
                        TimeOut();
                        System.out.println("QUIERES CAMBIAR LOS DATOS DEL LIBRO? \tESCRIBE SI O NO: ");
                        sc = new Scanner(System.in);
                        String tempOption = sc.nextLine();
                        String op2 = tempOption.toLowerCase();
                        if(bookAuthorPath.exists()){
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
                                    ModifyBookData(bookAuthorPath);
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
                            }/*ELSE BRACKETS*/
                        }/*IF BRACKETS*/
                            else{
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nNO EXISTE UN LIBRO CON " + tempAuthorNameString + "COMO FECHA DE PUBLICACION EN EL SISTEMA\n\nREGRESANDO");
                            }/*ELSE BRACKETS*/ 
                    }/*WHILE BRACKETS*/
                    break;
                case 3:
                    System.out.println("UN SEGUNDO POR FAVOR\n\n");
                    TimeOut();
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL AÑO DEL LIBRO SI ESTE YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut3 = true;
                    while(getsOut3){
                        TimeOut();
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA AÑO DE PUBLICACION DEL LIBRO: ");
                        sc = new Scanner(System.in);
                        String yearTransform = sc.nextLine();
                        String tempYearString = year + yearTransform;
                        List <String> finalBookFilePath = new ArrayList<String>();
                        File bookYearPath = null;
                        finalBookFilePath = CheckForBookYear(tempYearString);
                        System.out.println("ESTOS SON LOS ARCHIVOS CON " + yearTransform + " CON AÑO DE PUBLICACION\n\n");
                        for(int k =0;k<finalBookFilePath.size();k++){
                           System.out.println((k+1) + ".- " + finalBookFilePath.get(k));
                        }
                        System.out.println("\nSELECCIONA UNO PARA REVISAR SUS CONTENIDOS: ");
                        sc = new Scanner(System.in);
                        int tempChoosing = sc.nextInt();
                        String childFilePath = finalBookFilePath.get((tempChoosing-1));
                            TimeOut();
                            bookYearPath = new File(Prestamos.myPCPath, childFilePath);
                            GetBookData(bookYearPath);
                            System.out.println("QUIERES CAMBIAR LOS DATOS DEL LIBRO? \tESCRIBE SI O NO: ");
                            sc = new Scanner(System.in);
                            String tempOption = sc.nextLine();
                            String op2 = tempOption.toLowerCase();
                            if(bookYearPath.exists()){
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
                                        ModifyBookData(bookYearPath);
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
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nNO EXISTE UN LIBRO CON " + yearTransform + "COMO FECHA DE PUBLICACION EN EL SISTEMA\n\nREGRESANDO");
                            }/*ELSE BRACKETS*/    
                    }/*WHILE BRACKETS*/
                    break;
                case 4:
                    System.out.println("UN SEGUNDO POR FAVOR\n\n");
                    TimeOut();
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL GENERO DEL LIBRO SI ESTE YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut4 = true;
                    while(getsOut4){
                        TimeOut();
                        for(int i = 0; i<4;i++){/*SPECIFING THE USER WHICH ARE THE AVIABLE GENRES FOR THE BOOKS IN THE SYSTEM*/
                            System.out.println((i+1) + ".- " + genero[i]);
                        } 
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA GENERO DEL LIBRO (ESCRIBE EL GENERO COMPLETO): ");
                        sc = new Scanner(System.in);
                        String genreTransform = sc.nextLine();
                        String tempGenreTransform = genreTitle + genreTransform.toUpperCase();
                        List <String> finalBookGenrePath = new ArrayList<String>();
                        File bookGenrePath = null;
                        finalBookGenrePath = CheckForBookYear(tempGenreTransform);
                        System.out.println("ESTOS SON LOS ARCHIVOS CON " + tempGenreTransform + " CON AÑO DE PUBLICACION\n\n");
                        for(int k =0;k<finalBookGenrePath.size();k++){
                           System.out.println((k+1) + ".- " + finalBookGenrePath.get(k));
                        }
                        System.out.println("\nSELECCIONA UNO PARA REVISAR SUS CONTENIDOS: ");
                        sc = new Scanner(System.in);
                        int tempChoosing = sc.nextInt();
                        String childFilePath = finalBookGenrePath.get((tempChoosing-1));
                            TimeOut();
                            bookGenrePath = new File(Prestamos.myPCPath, childFilePath);
                            GetBookData(bookGenrePath);
                            System.out.println("QUIERES CAMBIAR LOS DATOS DEL LIBRO? \tESCRIBE SI O NO: ");
                            sc = new Scanner(System.in);
                            String tempOption = sc.nextLine();
                            String op2 = tempOption.toLowerCase();
                            if(bookGenrePath.exists()){
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
                                        ModifyBookData(bookGenrePath);
                                        getsOut4 = false;
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
                                    getsOut4 = false;
                                }/*ELSE BRACKETS*/
                            }/*IF BRACKETS*/
                            else{
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nNO EXISTE UN LIBRO CON " + genreTransform + "COMO FECHA DE PUBLICACION EN EL SISTEMA\n\nREGRESANDO");
                            }/*ELSE BRACKETS*/    
                    }/*WHILE BRACKETS*/
                    break;
                case 5:
                    System.out.println("UN SEGUNDO POR FAVOR\n\n");
                    TimeOut();
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL ISBN DEL LIBRO SI ESTE YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut5 = true;
                    while(getsOut5){
                        TimeOut();
                        System.out.println("POR FAVOR, A CONTINUACION PROPORCIONA ISBN DEL LIBRO (ESCRIBE EL ISBN COMPLETO): ");
                        sc = new Scanner(System.in);
                        String isbnTransform = sc.nextLine();
                        String tempIsbnTransform = Isbn + isbnTransform;
                        List <String> finalBookIsbnPath = new ArrayList<String>();
                        File bookIsbnPath = null;
                        finalBookIsbnPath = CheckForBookYear(tempIsbnTransform);
                        System.out.println("ESTOS SON LOS ARCHIVOS CON " + tempIsbnTransform + " CON AÑO DE PUBLICACION\n\n");
                        for(int k =0;k<finalBookIsbnPath.size();k++){
                            System.out.println((k+1) + ".- " + finalBookIsbnPath.get(k));
                        }
                        System.out.println("\nSELECCIONA UNO PARA REVISAR SUS CONTENIDOS: ");
                        sc = new Scanner(System.in);
                        int tempChoosing = sc.nextInt();
                        String childFilePath = finalBookIsbnPath.get((tempChoosing-1));
                            TimeOut();
                            bookIsbnPath = new File(Prestamos.myPCPath, childFilePath);/*FINDING FILE PATH*/
                            GetBookData(bookIsbnPath);
                            if(bookIsbnPath.exists()){
                                System.out.println("QUIERES CAMBIAR LOS DATOS DEL LIBRO? \tESCRIBE SI O NO: ");
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
                                        ModifyBookData(bookIsbnPath);
                                        getsOut5 = false;
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
                                    getsOut5 = false;
                                }/*ELSE BRACKETS*/
                            }/*IF BRACKETS*/
                            else{
                                /*THIS SECTION WILL ASK THE USER TO ENTER THE DATA OF THE LIBRARY'S USER OR IN THE CASE THE PROGRAM USER WANTS TO GO BACK*/
                                System.out.println("\n\nNO EXISTE UN LIBRO CON " + isbnTransform + "COMO FECHA DE PUBLICACION EN EL SISTEMA\n\nREGRESANDO");
                            }/*ELSE BRACKETS*/    
                    }/*WHILE BRACKETS*/
                    break;
                case 6:
                Boolean getsOut6 = true;
                while(getsOut6){
                    System.out.println("A CUAL DE LOS LIBROS QUIERES BORRAR DEL SISTEMA?\n\n");
                    File userDataPath = new File (Prestamos.myPCPath);/*GETTING FILES FROM PARENT */
                    String[] ArchNames = userDataPath.list();
                    for(int i=0; i < ArchNames.length; i++){/*GIVING AN ARRAY THE NAMES FORM THE FILES INSIDE THE PARENT*/
                        System.out.println(i+1 + ". " + ArchNames[i]);/*LISTING FILES INSIDE REPOSITORY*/
                    } /*ERRASE AFTER TESTS*/
                    System.out.println("ESTOS SON LOS ARCHIVOS. AQUELLOS QUE SON .TXT E INDICAN 'LIBRO' SON LIBROS QUE SE ENCUENTRAN EN EL SISTEMA. POR FAVOR SELECCIONA UNO DE ESTOS, INSERTANDO EL INCISO QUE SE VE A LA IZQUIERDA DEL ARCHIVO");
                    sc = new Scanner(System.in);
                    int fileOption = sc.nextInt();
                    File fileErrasing = new File(Prestamos.myPCPath, ArchNames[(fileOption-1)]);
                    getsOut6 = ErrasingBook(fileErrasing);
                }/*WHILE BRACKETS*/
                    break;
                case 7:
                keepsGoing = false;
                    break;
                default:
                    break;
            }/*SWITCH CASE BRACKETS*/        
        }/*MAIN WHILE BRACKETS*/
        return ' ';
}/*CHEKINGFORUSER BRACKETS*/
private void GetBookData(File userFile){
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
private void ModifyBookData(File userFile){
    int chosenGenre = 0;
    PrintWriter myPrintWriter = null;
    FileWriter myFileWriter = null;
    List <String> bookData = new ArrayList<String>();
        System.out.println("\n\nCONTINUANDO");
        TimeOut();
        System.out.println("\n\n"+ titulo);
            sc = new Scanner(System.in);
            String tempTitle = sc.nextLine();
            String bookTitle = titulo + tempTitle.toUpperCase();
            bookData.add(bookTitle); /*ADDING THE DATA TO A LIST*/
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + autor);
            sc = new Scanner(System.in);
            String tempAuthor = sc.nextLine();
            String bookAuthor = autor + tempAuthor.toUpperCase();
            bookData.add(bookAuthor); /*ADDING THE DATA TO A LIST */
        System.out.println("GUARDANDO");
        TimeOut();
        System.out.println("\n\n" + year);
            sc = new Scanner(System.in);
            String tempYear = sc.nextLine();
            String bookYear = year + tempYear.toUpperCase();
            bookData.add(bookYear); /*ADDING THE DATA TO A LIST */
        System.out.println("ESTOS SON LOS GENEROS DE LIBRO DISPONIBLES EN EL SISTEMA\n\n");
            for(int i = 0; i<4;i++){/*SPECIFING THE USER WHICH ARE THE AVIABLE GENRES FOR THE BOOKS IN THE SYSTEM*/
                System.out.println((i+1) + ".- " + genero[i]);
            } 
            try {
                System.out.println("PARA ELEGIR UN GENERO ESCRIBE EL INCISO QUE APARECE A LA IZQUIERDA DE ESTE: ");
                sc = new Scanner(System.in);
                chosenGenre = sc.nextInt(); 
            } catch (InputMismatchException e) {
                System.out.println("EL VALOR QUE ESPECIFICASTE NO ES VALIDO, INTENTA CON UN NUMERO DEL 1 AL 4 UNICAMENTE Y NO INSERTES TEXTO");
            }
            System.out.println("\n\n"+ genero[(chosenGenre-1)]);/*DELETE*/
                String genre = genreTitle + genero[(chosenGenre-1)].toUpperCase();
                bookData.add(genre); /*ADDING THE DATA TO A LIST */
            System.out.println("GUARDANDO");
            TimeOut();    
            System.out.println("\n\n" + Isbn);
            sc = new Scanner(System.in);
            String tempIsbn = sc.nextLine();
            String bookIsbn = Isbn + tempIsbn;
            bookData.add(bookIsbn); /*ADDING THE DATA TO A LIST */
    try {
        myFileWriter = new FileWriter(userFile);
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
}/*MODIFY BOOK DATA*/
private void TimeOut(){
    /*SLEEP TIMEOUT*/
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}/*TIME OUT VOID*/
private List <String> CheckForBookYear(String userType){
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
private Boolean ErrasingBook(File userFile){
    Boolean out = true;
    GetBookData(userFile);
    System.out.println("ESTAS SEGURO DE QUE QUIERES BORRAR ESTE LIBRO DEL SISTEMA\n\nSI/NO: ");
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
        out = false;
    }
    return out;
}/*CHECK FOR ERRASING USER*/
}/*MAIN CLASS BRACKETS*/
