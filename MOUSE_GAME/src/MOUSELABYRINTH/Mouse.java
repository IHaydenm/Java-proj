package MOUSELABYRINTH;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mouse {
    public static void main(String[] args) throws Exception {
        /*VARIABLES*/
        int rows = 0;
        int columns = 0;
        String fileDataReading = " "; /*OPENING FILE WITH PARENT*/
        File FileMapDir = new File("C:/Users/PC1/Documents/les javas gabinete/MOUSE_GAME/src/MOUSELABYRINTH/");/*OBTAINING THE INFORMATION COMING IN FORM SRC*/
        String[] ArchNames = FileMapDir.list();
        for(int i=0; i < ArchNames.length; i++){/*GIVING AN ARRAY THE NAMES FORM THE FILES INSIDE THE PARENT*/
            System.out.println(i+1 + ". " + ArchNames[i]);/*LISTING FILES INSIDE REPOSITORY*/
        } /*ERRASE AFTER TESTS */
        System.out.println("ESTOS SON LOS ARCHIVOS\n\nPOR FAVOR ELIJE UN .TXT PARA TRABAJARLO COMO MAPA PARA EL RATON.\n\nTIENES QUE ESCRIBIR EL NUMERO DEL ARCHIVO QUE SE MUESTRA A LA IZQUIERDA DE SU NOMBRE.");
        try (Scanner sc = new Scanner(System.in)) {/*MAKING THE USER SELECT THE FILE INSIDE THE PARENT DIRECTORY */
            int op = sc.nextInt();
                    File inFileMap = new File("C:/Users/PC1/Documents/les javas gabinete/MOUSE_GAME/src/MOUSELABYRINTH/", ArchNames[op-1]);
                    if(inFileMap.exists()){/*SPECIFIED FILE EXISTS CONDITION */
                        System.out.println("EL ARCHIVO EXISTE");
                        /*FILE READER FOR VARIABLE BUFREAD*/
                        FileReader ReadingFile = new FileReader(inFileMap);
                        BufferedReader bufRead = new BufferedReader(ReadingFile);
                        String readFile = " ";
                        System.out.print("Loading preview of the map");
                        for(int p=0;p<3;p++){
                            System.out.print(".");
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("\n");
                        for(int i=0; i < inFileMap.length();i++){
                            if(readFile==null){
                                break;
                            }
                            else{
                                readFile = bufRead.readLine();
                                System.out.println(readFile);
                                rows = rows + 1;
                                try {
                                    Thread.sleep(800);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }         
                        }
                        FileReader tempReaderForColumns = new FileReader(inFileMap);
                        try (BufferedReader temBufferedForColumns = new BufferedReader(tempReaderForColumns)) {
                            String tempColumnsQuantity = temBufferedForColumns.readLine();
                            columns = tempColumnsQuantity.length();
                        }
                    }
                        else{/*SPECIFIED FILE DOES NOT EXIST */
                            System.out.println("EL ARCHIVO NO EXISTE.");
                            System.exit(0);
                         }
                        int tRows = rows - 1;
                        /*THIS CONVERTS DATA FORM THE FILE TO STRING*/
                        /*FILE READER FOR VARIABLE BUFREADPRE1*/
                        FileReader ReadingFilePre1 = new FileReader(inFileMap);
                        BufferedReader bufReadPrel = new BufferedReader(ReadingFilePre1);
                        List <String> numbers = new ArrayList <String>(); 
                        int limit = 0;
                        System.out.println("Este es el mapa cargado: ");
                        while(limit<tRows){
                            String tempLineReader = " ";
                                tempLineReader = bufReadPrel.readLine().toString();
                                numbers.add(tempLineReader);
                                fileDataReading = numbers.get(limit);
                                System.out.println(fileDataReading);
                                limit++;
                            }
                            MouseLabyrinth myLabyrinth = new MouseLabyrinth(rows, columns);
                            System.out.println(myLabyrinth.MousePathfinding(numbers));
                }
                public class Mouse {
    public static void main(String[] args) throws Exception {
        System.out.println(MouseFileOpener.FileOpening());

    }
}
}
}
