package MOUSELABYRINTH;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
<<<<<<< HEAD

import java.util.*;
=======
>>>>>>> 74dda7b (test on the way)
public class MouseFileOpener {
    public static char FileOpening()throws Exception{
        /*VARIABLES*/
        int rows = 0;
        int columns = 0;
<<<<<<< HEAD
        String fileDataReading = " "; /*OPENING FILE WITH PARENT*/
        File FileMapDir = new File("C:/Users/katco/Documents/les javas/MOUSE_GAME/src/MOUSELABYRINTH");/*OBTAINING THE INFORMATION COMING IN FORM SRC*/
        String[] ArchNames = FileMapDir.list();
        for(int i=0; i < ArchNames.length; i++){/*GIVING AN ARRAY THE NAMES FORM THE FILES INSIDE THE PARENT*/
            System.out.println(i+1 + ". " + ArchNames[i]);/*LISTING FILES INSIDE REPOSITORY*/
        } /*ERRASE AFTER TESTS */
        System.out.println("ESTOS SON LOS ARCHIVOS\n\nPOR FAVOR ELIJE UN .TXT PARA TRABAJARLO COMO MAPA PARA EL RATON.\n\nTIENES QUE ESCRIBIR EL NUMERO DEL ARCHIVO QUE SE MUESTRA A LA IZQUIERDA DE SU NOMBRE.");
        try (Scanner sc = new Scanner(System.in)) {/*MAKING THE USER SELECT THE FILE INSIDE THE PARENT DIRECTORY */
            int op = sc.nextInt();
                    File inFileMap = new File("C:/Users/katco/Documents/les javas/MOUSE_GAME/src/MOUSELABYRINTH/", ArchNames[op-1]);
                    if(inFileMap.exists()){/*SPECIFIED FILE EXISTS CONDITION */
                        System.out.println("EL ARCHIVO EXISTE");
                        /*FILE READER FOR VARIABLE BUFREAD*/
                        FileReader ReadingFile = new FileReader(inFileMap);
                        BufferedReader bufRead = new BufferedReader(ReadingFile); 
                        String readFile = " ";
=======
        int tRows = 0;
        File FileMapDir = new File("C:/Users/katco/Documents/les javas/MOUSE_GAME/src/MOUSELABYRINTH");/*OBTAINING THE INFORMATION COMING IN FORM SRC*/
        String[] ArchNames = FileMapDir.list();
        for(int i=0; i < ArchNames.length; i++){
            System.out.println(i+1 + ". " + ArchNames[i]);/*LISTING FILES INSIDE REPOSITORY*/
        } /*ERRASE AFTER TESTS */
        System.out.println("ESTOS SON LOS ARCHIVOS\n\nPOR FAVOR ELIJE UN .TXT PARA TRABAJARLO COMO MAPA PARA EL RATON.\n\nTIENES QUE ESCRIBIR EL NUMERO DEL ARCHIVO QUE SE MUESTRA A LA IZQUIERDA DE SU NOMBRE.");
        try (Scanner sc = new Scanner(System.in)) {
            int op = sc.nextInt();
                    File inFileMap = new File("C:/Users/katco/Documents/les javas/MOUSE_GAME/src/MOUSELABYRINTH/", ArchNames[op-1]);
                    if(inFileMap.exists()){
                        System.out.println("EL ARCHIVO EXISTE");
                        FileReader ReadingFile = new FileReader(inFileMap);
                        BufferedReader bufRead = new BufferedReader(ReadingFile);
                        String readFile = bufRead.readLine();
                        System.out.println(readFile);
                        String read4columns = bufRead.readLine();
                        columns = read4columns.length();
>>>>>>> 74dda7b (test on the way)
                        for(int i=0; i < inFileMap.length();i++){
                            if(readFile==null){
                                break;
                            }
<<<<<<< HEAD
                            else{
                                readFile = bufRead.readLine();
                                System.out.println(readFile);
                                rows = rows + 1;
                            }         
                        }
                    }
                        else{/*SPECIFIED FILE DOES NOT EXIST */
                            System.out.println("EL ARCHIVO NO EXISTE.");
                         }
                        int tRows = rows - 1;
                        System.out.println(tRows + " " + columns);
                        MouseLabyrinth myLabyrinth = new MouseLabyrinth(rows, columns);
                        
                
                        /*THIS CONVERTS DATA FORM THE FILE TO STRING*/
                        /*FILE READER FOR VARIABLE BUFREADPRE1*/
                        FileReader ReadingFilePre1 = new FileReader(inFileMap);
                        BufferedReader bufReadPrel = new BufferedReader(ReadingFilePre1);
                        List <String> numbers = new ArrayList <String>(); 
                        int limit = 0;
                        while(limit<tRows){
                            String tempLineReader = " ";
                                tempLineReader = bufReadPrel.readLine().toString();
                            
                                numbers.add(tempLineReader);
                                fileDataReading = numbers.get(limit);
                                System.out.println("The string of mr sex is " + fileDataReading);
                                limit++;
                            }
                }
            return ' ';
    }
}
=======
                                readFile = bufRead.readLine();
                                System.out.println(readFile);
                                rows = rows + 1;  
                        }
                        tRows = rows + 1;
                        System.out.println(tRows + " " + columns);
                        MouseLabyrinth myLabyrinth = new MouseLabyrinth(tRows, columns);
                    }
                    else{
                        System.out.println("EL ARCHIVO NO EXISTE.");
                    }
                }
            return ' ';
        }
        
    }
>>>>>>> 74dda7b (test on the way)
