package Biblio;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Prestamos {
    static String myPCPath = "C:/Users/katco/Documents/les javas/ProyectoBiblioteca/src/Biblio";
    Scanner sc = new Scanner(System.in);
public char AsksForBook(){
    System.out.println("QUE USUARIO QUIERE HACER EL PEDIR PRESTADO UN LIBRO?\n\nESCRIBE SU NOMBRE COMPLETO");
    String userNamePath = sc.nextLine();
    File userInformation = new File(myPCPath, userNamePath + ".txt");/*SEARCHING FOR THE FILE*/
    GetUserData(userInformation);
    return ' ';
}
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
}
