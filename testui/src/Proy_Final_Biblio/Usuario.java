package Proy_Final_Biblio;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Usuario extends Libro{
    /*VARIABLES*/
    String yes = "si";
    String id;
    String name;
    String typeUser;
    int op = 0;
    boolean keepsGoing = true;
    /*VARIABLES*/
    public char CheckForUser(){
        while (keepsGoing) {
            /*THIS SECTION OF THE PROGRAM WILL ASK THE USER TO INDICATE FOR WHICH ATRIBUTE SEARCH*/
            System.out.println("CHECAREMOS SI EL USUARIO ESTA EN EL SISTEMA.\tTENEMOS ESTAS OPCIONES PARA CHECAR POR EL USUARIO.\n\n1. BUSCAR POR NOMBRE\t 2. BUSCAR POR ID\t 3. BUSCAR POR TIPO DE USUARIO (ALUMNO O PROFESOR)\n\nPARA SELECIONAR UNA OPCION ESCRIBE EL NUMERO DEL INDICE\tTU SELECION: ");
            try{
                Scanner sc = new Scanner(System.in);
                op = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("EL VALOR QUE HA INSERTADO ES INVALIDO, INTENTE OTRA VEZ INTRODUCIENDO UN VALOR NUMERICO VALIDO.");
            }
            switch (op) {
                case 1:
                    System.out.println("ESTAMOS REVISANDO A TRAVES DEL NOMBRE DEL USUARIO SI YA SE ENCUENTRA EN EL SISTEMA.");
                    Boolean getsOut = true;
                    while(getsOut){
                        System.out.print("POR FAVOR, A CONTINUACION PROPORCIONA EL NOMBRE DEL USUARIO: ");
                        Scanner sc1 = new Scanner(System.in);
                        String nameTransform = sc1.nextLine() + ".txt";
                        String tempNameString = nameTransform.toLowerCase();
                        File usersFile = new File(Libro.myPCPath, tempNameString);   
                        if(usersFile.exists()){
                            System.out.println("EL USUARIO YA HA ESTADO AQUI");
                            System.out.println("QUIERES CAMBIAR DATOS DEL USUARIO? \tESCRIBE SI O NO: ");
                            Scanner sc2 = new Scanner(System.in);
                            String tempOption = sc2.nextLine();
                            String op2 = tempOption.toLowerCase();
                            if(op2.equals(yes)){
                                ModifyUser(usersFile);
                            }
                        }/*IF BRACKETS*/
                        else{
                            try{
                                usersFile.createNewFile();
                                System.out.println("se creo el archivo");/*DELETE AFTER TESTS */
                                System.out.println("QUIERES GUARDAR DATOS DEL USUARIO?");
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
public void ModifyUser(File userFile){
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
        System.out.println(rowCounter); /*DELETE AFTER TESTS*/
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
}/*MODIFY USER BRACKETS*/
}/*MAIN CLASS BRACKETS*/

