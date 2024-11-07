package FILESTASK;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class FileCreator {
    public static String userFileFinder(String userName) throws Exception {
        /*VARIABLES*/
        String fileDataReading = " "; 
        int rows = 0;
        /*OPENING FILE WITH PARENT*/
        File FileMapDir = new File("C:/Users/PC1/Documents/les javas gabinete/FilesTask/src/FILESTASK/");/*OBTAINING THE INFORMATION COMING IN FORM SRC*/
        try {/*READING THE FILE WHICH CONTAINS THE PLAYERS NAME */
                    File inFileMap = new File(FileMapDir, userName + ".txt"); 
                    if(inFileMap.exists()){/*SPECIFIED FILE EXISTS CONDITION*/
                        System.out.println("BIENVENIDO DE VUELTA " + userName);
                        FileReader ReadingFile = new FileReader(inFileMap);
                        BufferedReader bufRead = new BufferedReader(ReadingFile);
                        String readFile = " ";
                        System.out.println("\n");
                        for(int i=0; i < inFileMap.length();i++){
                            if(readFile==null){
                                break;
                            }
                            else{
                                readFile = bufRead.readLine();
                                rows = rows + 1;
                            }         
                        }
                        int tRows = rows - 1;
                        /*THIS CONVERTS DATA FORM THE FILE TO STRING*/
                        /*FILE READER FOR VARIABLE BUFREAD1*/
                        FileReader ReadingFile1 = new FileReader(inFileMap);
                        BufferedReader bufReader1 = new BufferedReader(ReadingFile1);
                        List <String> playerData = new ArrayList <String>(); 
                        int limit = 0;
                        System.out.println("ESTAS SON TUS ESTADISTICAS");
                        while(limit<tRows){
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            String tempLineReader = " ";
                            tempLineReader = bufReader1.readLine().toString();
                            playerData.add(tempLineReader);
                            fileDataReading = playerData.get(limit);
                            System.out.println(fileDataReading);
                            limit++;
                        }
                    }
                    else{/*SPECIFIED FILE DOES NOT EXIST*/
                        System.out.println("EL USUARIO " + userName + " AUN NO HABIA JUGADO ESTE ADIVINA QUIEN\t\tCREANDO UN ARCHIVO NUEVO PARA LAS ESTADISTICAS");
                        for(int i=0;i<3;i++){
                            System.out.print('.');
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        inFileMap = new File(FileMapDir, userName + ".txt");
                    }
        }finally{
            System.out.println("");
        }
        return "COMENCEMOS A JUGAR!";
    }
    public static String finalScoreBoard(String score, String winsOrLoses, String userName){
        String tempUserName = userName;
        List <String> finalUserData = new ArrayList<String>();
        /*MANUALLY SAVING THE DATA INSIDE A LIST*/
        finalUserData.add(userName);
        finalUserData.add("ESTE ES TU PUNTAJE: "+ score);
        finalUserData.add(winsOrLoses);
        File inFileMap = new File("C:/Users/PC1/Documents/les javas gabinete/FilesTask/src/FILESTASK/" , tempUserName + ".txt");
        if(tempUserName!=" "){/*IF THE PLAYER DECIDED TO SAVE HIS DATA*/
            long currentTime = System.currentTimeMillis();
            Date currentDate = new Date(currentTime);
            String currentDateTime = currentDate.toString();
            finalUserData.add(currentDateTime);
            FileWriter myFileWriter = null;
            PrintWriter myPrintWriter = null;
            System.out.println("ESTOY GUARDANDO TUS DATOS.");
            try {
                myFileWriter = new FileWriter(inFileMap);
                myPrintWriter = new PrintWriter(myFileWriter);
                for(int i=0;i<finalUserData.size();i++){
                    String finalWriter = finalUserData.get(i);
                    myPrintWriter.println(finalWriter);
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                //close resources
                try {
                    myFileWriter.close();
                    myPrintWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{/*IF THE USER DID NOT WANT TO SAVE HIS DATA*/
            System.out.println("DEBIDO A QUE NO SE INICIO SESION NO SE GUARDARAN LOS DATOS");
        }
        return " ";
    }
}
