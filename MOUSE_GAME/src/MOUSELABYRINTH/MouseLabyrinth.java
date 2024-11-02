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
    char[][] aviableMap;
    char[] gettingChar;
    int rows, columns;
    public MouseLabyrinth(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
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
            
            if(aviableMap[spR][spC]==for0){
                
            }
        return " ";
    }
}
