package MOUSELABYRINTH;

import java.util.List;

public class MouseLabyrinth {
    boolean hasFoundS = false;
    /*THESE VARIABLES ARE SET TO MARK THE SPAWNPOINT*/
    int spR = 0; 
    int spC = 0;
    int tempSpC = 0;
    int tempSpR = 0;
    /*THESE VARIABLES ARE SET TO MARK THE SPAWNPOINT*/
    /*THESE VARIABLES ARE THE PRESETS FOR THE MAP CONDITIONS*/
    char for0 = '0';
    char for1 = '1';
    char forF = 'F';
    char forA = 'A';
    int fileBorder;
    char[][] aviableMap;
    char[] gettingChar;
    String[] correctPath = new String[100];
    /*THIS VARIABLES ARE USED TO INDICATE THE CORRECT SET OF INSTRUCTIONS TO FOLLOW TO COMPLETE THE MAZE*/
    String up = "Arriba"; 
    String down = "Abajo"; 
    String right = "Derecha"; 
    String left = "Izquierda";
    int arrayTraverser = 0;
    int tempArrayTraverser = 0;
    int resetCounterR = 0;
    int resetCounterD = 0;
    int resetCounterL = 0;
    /*THIS VARIABLES ARE USED TO INDICATE THE CORRECT SET OF INSTRUCTIONS TO FOLLOW TO COMPLETE THE MAZE*/
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
        gettingChar = new char[mapLenght];
        System.out.println("TRABAJANDO EN LA SOLUCION DEL MAPA...");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("ESTAS SON LAS COORDENADAS DE COMIENZO "+ "(" + i + ") (" + j + ")");
                        hasFoundS = true;
                        spC = j;
                        spR = i;
                    }
                }
            }/*MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER MAP PATHFINDER */
            boolean hasWon = false; /*VARIABLE THAT WILL OVERWRITE THE MOUSE SPAWNPOINT*/
            while(hasWon==false){
                resetCounterD++;
                System.out.println("REVISANDO EL CAMINO");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*IF THE FINDER CAN MOVE DOWNWARDS*/
                if(aviableMap[spR+1][spC]==for0){
                    movingDownwards();
                }
                /*IF THE FINDER CAN MOVE DOWNNWARDS AND THIS MOVEMENT RESULTS IN THE FINISH LINE*/
                else if(aviableMap[spR+1][spC]==forF){
                    movingDownwards();
                    hasWon = true;
                    System.out.println("LLEGUE A LA META");
                }
                /*SAVING THE VALUE OF THE DIFERENT TANGENTS THE FINDER CAN TAKE*/
                else if(((aviableMap[spR][spC+1]==for0) && (aviableMap[spR][spC-1]==for0)) || ((aviableMap[spR-1][spC]==for0) && (aviableMap[spR][spC+1]==for0)) || ((aviableMap[spR+1][spC]==for0) && (aviableMap[spR][spC+1]==for0)) || ((aviableMap[spR-1][spC]==for0) && (aviableMap[spR][spC-1]==for0)) || ((aviableMap[spR-1][spC]==for0) && (aviableMap[spR][spC+1]==for0))){
                    System.out.println("ESTOY GUARDANDO EL ESTA POSICION PARA REGRESAR A ELLA SI LO NECESITO!");
                    tempSpC = spC;
                    tempSpR = spR;
                    System.err.println("EL VALOR DE LA POSICION DONDE EL PROGRAMA DECIDIO GUARDAR SU POSICION: " + tempSpC + " " + tempSpR);
                    tempArrayTraverser = arrayTraverser; /*SAVING HOW MANY ITEMS ARE INSIDE THE ARRAY ARRAYTRAVERSER IN CASE THE PATH THE FINDER TAKES IS NOT THE CORRECT ONE*/
                    movingToTheRight();
                }
                else if(resetCounterD==10){
                    resetFunc();
                }
                /*IF THE FINDER CANNOT MOVE DOWNWARDS*/
                else if(aviableMap[spR+1][spC]==for1 || aviableMap[spR+1][spC]==forA){
                    resetCounterD=0;
                    resetCounterR++;
                    System.out.println("NO PUDE MOVERME HACIA ABAJO INTENTARE MOVERME HACIA OTRA POSICION. ESTOY BUSCANDO OTRO CAMINO");
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*IF THE FINDER CAN GO TO THE RIGHT AND ITS A NEW PATH*/
                    if((aviableMap[spR][spC+1]==for0)){
                        movingToTheRight();
                    }
                    /*IF THE FINDER CAN GO TO THE RIGHT AND THIS MOVEMENT RESULTS IN THE FINISH LINE*/
                    else if(aviableMap[spR][spC+1]==forF){
                        movingToTheRight();
                        hasWon = true;
                    }
                    else if(resetCounterR==10){
                        resetFunc();
                    }
                    /*IF THE FINDER CANNOT GO TO THE RIGHT*/
                    else if(aviableMap[spR][spC+1]==for1 || aviableMap[spR][spC+1]==forA){
                        resetCounterR = 0;
                        resetCounterL++;
                        System.out.println("NO PUDE MOVERME HACIA LA DERECHA INTENTARE MOVERME HACIA OTRA POSICION. ESTOY BUSCANDO OTRO CAMINO");
                        try{
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        /*IF THE FINDER CAN GO TO THE LEFT */
                        if(aviableMap[spR][spC-1]==for0){
                            movingToTheLeft();
                        }
                        /*IF THE FINDER CAN GO TO THE LEFT AND THIS MOVEMENT RESULTS IN THE FINISH LINE*/
                        else if(aviableMap[spR][spC-1]==forF){
                            movingToTheLeft();
                            hasWon = true;
                        }
                        else if(resetCounterL==10){
                            resetFunc();
                        }
                        /*IF THE FINDER CANNOT GO TO THE LEFT*/
                        else if(aviableMap[spR][spC-1]==for1 || aviableMap[spR][spC-1]==forA){
                            resetCounterL = 0;
                            System.out.println("NO PUDE MOVERME HACIA LA IZQUIERDA INTENTARE MOVERME HACIA OTRA POSICION. ESTOY BUSCANDO OTRO CAMINO");
                            try{
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            /*IF THE FINDER CAN GO UPWARDS*/
                            if(aviableMap[spR-1][spC]==for0){
                                movingUpwards();
                            }
                            /*IF THE FINDER CAN GO UPWARDS AND THIS MOVEMENT RESULTS IN THE FINISH LINE */
                            else if(aviableMap[spR-1][spC]==forF){
                                movingUpwards();
                                hasWon = true;
                            }
                            else if(aviableMap[spR-1][spC]==for1 || aviableMap[spR-1][spC]==forA){
                                resetFunc();
                            }
                            else{
                                continue;
                            }      
                        }  
                        else{
                            continue;
                        } 
                    } 
                    else{
                        continue;
                    }  
                }else{
                    continue;
                }
            }
            int k = 1;
            for(String correctPathStrings : correctPath){
                System.out.println(k + ". " + correctPathStrings);
                k++;
            }
    return " ";
}


public void movingDownwards(){
    aviableMap[spR][spC] = 'A';
    spR++;
    System.out.println("ME MOVI HACIA ABAJO");
    correctPath[arrayTraverser] = down;
    arrayTraverser++;
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public void movingToTheRight(){
    aviableMap[spR][spC] = 'A';
    spC++;
    System.out.println("ME MOVI HACIA LA DERECHA");
    correctPath[arrayTraverser] = right;
    arrayTraverser++;
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public void movingToTheLeft(){
    aviableMap[spR][spC] = 'A';
    spC--;
    System.out.println("ME MOVI HACIA LA IZQUIERDA");
    correctPath[arrayTraverser] = left;
    arrayTraverser++;
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public void movingUpwards(){
    aviableMap[spR][spC] = 'A';
    spR--;
    System.out.println("ME MOVI HACIA ARRIBA");
    correctPath[arrayTraverser] = up;
    arrayTraverser++;
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public void resetFunc(){
    System.out.println("PARECE QUE ME QUEDE SIN CAMINO REGRESARE A UN PUNTO DONDE TENIA DOS OPCIONES");
    spC = tempSpC;
    spR = tempSpR;
    System.err.println("EL VALOR DE LA POSICION DONDE EL PROGRAMA DECIDIO GUARDAR SU POSICION: " + spC + " " + spR);
    for(int i = (tempArrayTraverser+1);i<correctPath.length;i++){
        correctPath[i] = " ";
    }
    resetCounterD = 0;
    resetCounterL = 0;
    resetCounterR = 0;
}
}/*MAIN CLASS KEY*/