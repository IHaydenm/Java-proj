package MOUSELABYRINTH;

import java.util.List;

public class MouseLabyrinth {
    boolean hasFoundS = false;
    /*THESE VARIABLES ARE SET TO MARK THE SPAWNPOINT*/
    int spR = 0; 
    int spC = 0;
    /*THESE VARIABLES ARE SET TO MARK THE SPAWNPOINT*/
    /*THESE VARIABLES ARE THE PRESETS FOR THE MAP CONDITIONS*/
    char for0 = '0';
    char for1 = '1';
    char forF = 'F';
    int fileBorder;
    char[][] aviableMap;
    char[] gettingChar;
    int rows, columns;
    public MouseLabyrinth(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.fileBorder = columns;
        this.aviableMap = new char[rows][columns];
    }
    public String MousePathfinding(List <String> map){
        /*PLACING THE DATA FROM THE FILE INSIDE THE LOCAL VARIABLE AVIABLEMAP */
        int mapLenght = map.size();
        System.out.println("THIS IS THE MAP LENGHT FROM MOUSE LABYRINTH: " + mapLenght);
        gettingChar = new char[mapLenght];
        for(int i=0;i<rows-1;i++){
            gettingChar = map.get(i).toCharArray();/*THIS WILL GET THE STRING FROM MAP AND CONVERT THE DATA INTO CHARS*/
            for(int j=0;j<columns;j++){
                aviableMap[i][j] = gettingChar[j];
                System.out.print(gettingChar[j]);
            }
            System.out.print("\n");
        }/*PREVIOUS SECTION WILL CREATE THE MAP THAT WILL BE ANALIZED*/
        /*THIS SET OF THE CODE WILL FIND THE BEGINING OF THE MAP */
        for(int i=0;i<rows-1;i++){
            if(hasFoundS==true){
                break;
            }
                for(int j=0;j<columns;j++){
                    if(hasFoundS==true){
                        break;
                    }
                    else if(aviableMap[i][j]!='S'){
                        System.out.println("ESTOY BUSCANDO EL PUNTO DE PARTIDA...");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("ESTAS SON LAS COORDENADAS DE COMIENZO"+ "(" + i + ") (" + j + ")");
                        hasFoundS = true;
                        spC = j;
                        spR = i;
                    }
                }
            }/*MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER */
            boolean hasWon = false; /*VARIABLE THAT WILL OVERWRITE THE MOUSE SPAWNPOINT*/
            while(hasWon==false){
                System.out.println((fileBorder-1) + " " + (columns-1));
                for(int j=spC;j<columns;j++){
                    if(aviableMap[spR+1][j]==for0){
                        System.out.println("IM MOVING TO: (" + (spR+1) + ")" +  "(" + j + ")");
                        spR++;
                        spC = j;
                        j=0;
                        /*DELETE AFTER TESTS*/
                        System.out.println("THIS IS THE ROW VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 0 ON THE WAY: " + spR);
                        System.out.println("THIS IS THE COLUMN VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 0 ON THE WAY: " + spC);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(aviableMap[spR+1][j]==forF){
                        System.out.println("HE ENCONTRADO LA META!");
                        hasWon = true;
                    }
                    else if((spR+1)==(fileBorder-1) && (j)==(columns-1)){
                        System.out.println("I'LL HAVE TO GO BACK, THIS IS NOT THE WAY.");
                        boolean hasFoundNewWay = false;
                        while(hasFoundNewWay==false){
                            for(int k=spC;k<columns;k++){
                                if(aviableMap[spR-1][k]==for0){
                                    System.out.println("IM MOVING TO: (" + (spR-1) + ")" +  "(" + k + ")");
                                    spR++;
                                    spC = k;
                                    k=0;
                                    /*DELETE AFTER TESTS*/
                                    System.out.println("THIS IS THE ROW VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 0 ON THE WAY: " + spR);
                                    System.out.println("THIS IS THE COLUMN VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 0 ON THE WAY: " + spC);
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    if(aviableMap[spR-1][k+1]==for0){
                                        System.out.println("THERE IS A NEW PATH I HAVE DISCOVERED! MOVING THERE");
                                        hasFoundNewWay = true;
                                        spC = k+1;
                                    }
                            }
                                else if(aviableMap[spR-1][k]==for1){
                                    System.out.println("I CANNOT MOVE TO: (" + (spR-1) + ")" +  "(" + k + ")");
                                    /*DELETE AFTER TESTS*/
                                    System.out.println("THIS IS THE ROW VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 1 ON THE WAY: " + spR);
                                    System.out.println("THIS IS THE COLUMN VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 1 ON THE WAY: " + spC);
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                            }
                    }
                }
            }
                    else if(aviableMap[spR+1][j]==for1){
                        System.out.println("I CANNOT MOVE TO: (" + (spR+1) + ")" +  "(" + j + ")");
                        /*DELETE AFTER TESTS*/
                        System.out.println("THIS IS THE ROW VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 1 ON THE WAY: " + spR);
                        System.out.println("THIS IS THE COLUMN VALUE WHERE THE FINDER SITS AFTER ANALIZIS DECIDES THERES A 1 ON THE WAY: " + spC);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
    }
    }
    return " ";
}
}