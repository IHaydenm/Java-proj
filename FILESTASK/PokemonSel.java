package FILESTASK;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public abstract class PokemonSel{
    int maxPokLim;
    /*VARIABLES*/
    static String[] pName; 
    static String[] fName;
    static String[] wName;
    static String fire = "fuego";
    static String water = "agua";
    static String plant = "planta";
    /*variables for subclasses: NAME*/
    static String[] fAttack = new String[5];
    static String[] fSize = new String[5];
    static String[] wAttack = new String[5];
    static String[] wSize = new String[5];
    static String[] pAttack = new String[5];
    static String[] pSize = new String[5]; 
    /*attack variables */
    static String chosenPokName;
    /*variable will be recieving the value of NAME*/
    static String[] pokS = new String[3];{
        pokS[0] = "small";
        pokS[1] = "mediano";
        pokS[2] = "grande";
    }
    /*variables for each sub class SIZE*/
    static String[] Attack = new String[8];{
    Attack[0] = "hydro pump";
    Attack[1] = "solar beam";
    Attack[2] = "eruption";
    Attack[3] = "flamethrower";
    Attack[4] = "aqua jet";
    Attack[5] = "whirlpool";
    Attack[6] = "synthesis";
    Attack[7] = "petal dance";
    }
    /*variables for each attack a pokemon can recieve*/
    static String score = "100";
    static String wins = "GANASTE LA PARTIDA, MUY BIEN JUGADO!";
    static String loses = "PERDISTE LA PARTIDA, INTENTALO OTRA VEZ, TU PUEDES!";
    /*variable for the score and won or lost games*/
    /*VARIABLES*/
    public static String PokemonSelection(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    /*LITTLE DELAY UX PURPOSE haha*/
        Random random = new Random();
            int pokSelect = random.nextInt(1,4);
            System.out.println(pokSelect);
            if(pokSelect==1){
                Random random1 = new Random();
                int chosenPok = random1.nextInt(0,5);
                chosenPokName = pName[chosenPok];
                System.out.println(pSize[chosenPok]); /*CLEAR AFTER TESTS */
                System.out.println(pAttack[chosenPok]); /*CLEAR AFTER TESTS */
            }
            else if(pokSelect==2){
                Random random2 = new Random();
                int chosenPok = random2.nextInt(0,5);
                chosenPokName = wName[chosenPok];
                System.out.println(wSize[chosenPok]); /*CLEAR AFTER TESTS */
                System.out.println(wAttack[chosenPok]); /*CLEAR AFTER TESTS */
            }
            else if(pokSelect==3){
                Random random3 = new Random();
                int chosenPok = random3.nextInt(0,5);
                chosenPokName = fName[chosenPok];
                System.out.println(pSize[chosenPok]); /*CLEAR AFTER TESTS */
                System.out.println(fAttack[chosenPok]); /*CLEAR AFTER TESTS */
            }
        return chosenPokName; /*CLEAR AFTER TESTS*/
        }
    @SuppressWarnings("resource")
    public static char GuessWho(String userName){
        /*variables*/
        int op;
        String tempUserName = userName;
        System.out.println(userName + tempUserName);
        String tempNameSpace = " ";
        /*variables for for attempts and win condition */
        int guess = 0;
        int attempts = 5;
        boolean attemptsBool = true;
        while((guess!=1) && (attemptsBool==true)){
            /*THE GAME MUST KEEP GOING UNTIL EITHER THE POKEMON IS GUESSED OR THE USER RUNS OUT OF attempts*/
            System.out.println("\nCOMENCEMOS!\tPARA ADIVINAR TENDRAS QUE ELEJIR UNA DE LAS SIGUIENTES OPCIONES.\tTIENES" + " " + (attempts) + " " + "INTENTOS\n\n1.NOMBRE DEL POKEMON.\t2.TAMAÑO DEL POKEMON\t3.TIPO DEL POKEMON.\t4.ATAQUE DEL POKEMON\n");
            System.out.println("ESCRIBE EL NUMERO DEL INCISO DE LA OPCION PARA ACCESAR EL MENU DE OPCIONES\n\nTU OPCION: ");
            /*READING THE VARIABLE FOR IF CONDITION*/
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();
            /*ALL OPTIONS SHOWN IN LISTS*/
            /*SWITCH CASE FOR OPTIONS*/
            
            switch (op) {
                case 1: /*OPTION FOR NAMES*/
                    /*FIRE TYPE*/
                    System.out.println("FIRE TYPE\n");
                    for(int i=0;i<5;i++){
                        int j = i;
                        int k;
                        k = j+1;/*VARIABLES FOR INDEX*/
                        System.out.print(k + ". "+fName[i] + ("  "));
                    }
                    System.out.println("\n");
                    System.out.println("WATER TYPE\n");
                    for(int i=0;i<5;i++){
                        int j = i;
                        int k;
                        k = j+1;/*VARIABLES FOR INDEX*/
                        System.out.print(k + ". " + wName[i] + ("  "));
                    }
                    System.out.println("\n");
                    System.out.println("PLANT TYPE\n");
                    for(int i=0;i<5;i++){
                        int j = i;
                        int k;
                        k = j+1;/*VARIABLES FOR INDEX*/
                        System.out.print(k + ". " + pName[i] + ("  "));
                    }
                    System.out.println("\n\nPARA SELECCIONAR EL POKEMON ESCRIBE SU NOMBRE: ");
                    Scanner sc1 = new Scanner(System.in);/*SAVING THE INPUT OF THE USER*/
                    String pPokeName = sc1.nextLine();
                    String checkPokemonName = pPokeName.toLowerCase();
                        if(checkPokemonName.equals(chosenPokName)){
                            System.out.println("EL POKEMON ES " + chosenPokName);
                            guess = 1; /*THE PLAYER WINS BY GUESSING THE POKEMON NAME*/
                            if(attempts>=4){/*DEFINING THE SCORE*/
                                FileCreator.finalScoreBoard(score, wins, tempUserName);
                            }
                            else{
                                score = "50";
                                FileCreator.finalScoreBoard(score, wins, tempUserName);
                            }
                        }
                        else if(!checkPokemonName.equals(chosenPokName)){
                            System.out.println("EL NOMBRE DEL POKEMON POR ADIVINAR NO ES  " + checkPokemonName + ("\tINTENTA DE NUEVO\n"));
                            attempts--; 
                        }
                    break;
                case 2: /*OPTION FOR SIZES*/
                    System.out.println("\nESTAS SON LAS OPCIONES:\n\na) SMALL\tb) MEDIANO\tc) GRANDE\n");
                    System.out.println("TIPO FUEGO\n");
                    int listerF = 0;
                    for(int i=0;i<5;i++){
                            System.out.println((listerF+1) + ". " + fName[i] + "\t" +fSize[i]);
                            listerF++;
                    }
                    System.out.println("\nTIPO AGUA\n");
                    int listerW = 0;
                    for(int j=0;j<5;j++){
                            System.out.println((listerW+1) + ". " + wName[j] + "\t" +wSize[j]);
                            listerW++;
                    }
                    System.out.println("\nTIPO PLANTA\n");
                    int listerP = 0;
                    for(int k=0;k<5;k++){
                            System.out.println((listerP+1) + ". " + pName[k] + "\t" +pSize[k]);
                            listerP++;
                    }
                    System.out.println("\n\nESCRIBE EL TAMAÑO QUE CREES QUE TIENE EL POKEMON: ");
                    Scanner sc2 = new Scanner(System.in);
                    String getPokemonSize = sc2.nextLine();/*SAVING THE INPUT OF THE USER*/
                    String checkPokemonSize = getPokemonSize.toLowerCase();/*CHANGING TO LOWER CASE*/
                    /*CHECKING SIZE FOR THE FIRE TYPE POKEMONS*/
                    System.out.println("\n\n");
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(fName[i])){
                            tempNameSpace = fSize[i];/*ALOCATING THE SIZE OF THE CHOSEN POKEMON*/
                        }
                        else{
                            continue;
                        }
                        }
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(wName[i])){
                            tempNameSpace = wSize[i];/*ALOCATING THE SIZE OF THE CHOSEN POKEMON*/
                        }
                        else{
                            continue;
                        }
                        }  
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(pName[i])){
                            tempNameSpace = pSize[i];/*ALOCATING THE SIZE OF THE CHOSEN POKEMON*/
                        }
                        else{
                            continue;
                        }
                        }  
                        if(checkPokemonSize.equals(tempNameSpace)){/*IF THE USER IS CORRECT*/
                            System.out.println("EL TAMAÑO DEL POKEMON ES " + checkPokemonSize + " ESTOS POKEMON SON LOS QUE RESTAN: ");
                            int counterF = 0;
                            for(int i=0;i<5;i++){
                                if(fSize[i].equals(checkPokemonSize)){
                                    System.out.println((counterF+1) + ". " + fName[i] + "\t" +fSize[i]);
                                    counterF++;
                                }
                            }
                            System.out.println("\n");
                            int counterW = 0;
                            for(int j=0;j<5;j++){
                                if(wSize[j].equals(checkPokemonSize)){
                                    System.out.println((counterW+1) + ". " + wName[j] + "\t" + wSize[j]);
                                    counterW++;
                                }
                            }
                            System.out.println("\n");
                            int counterP = 0;
                            for(int k=0;k<5;k++){ 
                                if(pSize[k].equals(checkPokemonSize)){
                                    System.out.println((counterP+1) + ". " + pName[k] + "\t" + pSize[k]);
                                    counterP++;
                                }
                            }
                        }
                    else{/*USER IS WRONG*/
                            System.out.println("EL TAMAÑO " + checkPokemonSize + " NO ES LA DEL POKEMON POR ADIVINAR.\n\n ESTOS POKEMON SON LOS QUE RESTAN: ");
                            int counterF = 0;
                            for(int i=0;i<5;i++){
                                if(!fSize[i].equals(checkPokemonSize)){
                                    System.out.println((counterF+1) + ". " + fName[i] + "\t" + fSize[i] );
                                    counterF++;
                                }
                            }
                            System.out.println("\n");
                            int counterW = 0;
                            for(int j=0;j<5;j++){
                                if(!wSize[j].equals(checkPokemonSize)){
                                    System.out.println((counterW+1) + ". " + wName[j] + "\t" +wSize[j] );
                                    counterW++;
                                }
                            }
                            System.out.println("\n");
                            int counterP = 0;
                            for(int k=0;k<5;k++){
                                if(!pSize[k].equals(checkPokemonSize)){
                                    System.out.println((counterP+1) + ". " + pName[k] + "\t" +pSize[k]);
                                    counterP++;
                                }
                            }
                            attempts--;
                            if(attempts==0){
                                attemptsBool = false;
                            }
                            /*CHECKING THE CONDITION OF THE ATEMPTS */
                        }
                    break;
                case 3:/*OPTION FOR POKEMON TYPE*/
                    System.out.println("ESTAS SON LAS OPCIONES:\n\na) TIPO FUEGO\tb) TIPO AGUA\t TIPO PLANTA\n");
                    System.out.println("TIPO FUEGO\n");
                    int typeF = 0;
                    for(int i=0;i<5;i++){
                            System.out.println((typeF+1) + ". " + fName[i]);
                            typeF++;
                    }
                    System.out.println("\nTIPO AGUA\n");
                    int typeW = 0;
                    for(int j=0;j<5;j++){
                            System.out.println((typeW+1) + ". " + wName[j]);
                            typeW++;
                    }
                    System.out.println("\nTIPO PLANTA\n");
                    int typeP = 0;
                    for(int k=0;k<5;k++){
                            System.out.println((typeP+1) + ". " + pName[k]);
                            typeP++;
                    }
                    System.out.println("\n\nESCRIBE EL TIPO QUE CREES QUE TIENE EL POKEMON: ");
                    Scanner sc3 = new Scanner(System.in);
                    String getPokemonSize1 = sc3.nextLine();/*SAVING THE INPUT OF THE USER*/
                    String checkPokemonSize1 = getPokemonSize1.toLowerCase();/*CHANGING TO LOWER CASE*/
                    /*CHECKING SIZE FOR THE FIRE TYPE POKEMONS*/
                    System.out.println("\n\n");
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(fName[i])){
                            tempNameSpace = fire;/*ALOCATING THE SIZE OF THE CHOSEN POKEMON IN THIS SECTION TEMPNAMESPACE WILL REFER TO THE POKEMON TYPE*/
                        }
                        else{
                            continue;
                        }
                        }
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(wName[i])){
                            tempNameSpace = water;/*ALOCATING THE SIZE OF THE CHOSEN POKEMON IN THIS SECTION TEMPNAMESPACE WILL REFER TO THE POKEMON TYPE*/
                        }
                        else{
                            continue;
                        }
                        }  
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(pName[i])){
                            tempNameSpace = plant;/*ALOCATING THE SIZE OF THE CHOSEN POKEMON IN THIS SECTION TEMPNAMESPACE WILL REFER TO THE POKEMON TYPE*/
                        }
                        else{
                            continue;
                        }
                        }  
                        if(checkPokemonSize1.equals(tempNameSpace)){/*IF THE USER IS CORRECT*/
                            System.out.println("EL TIPO DEL POKEMON ES " + checkPokemonSize1 + " ESTOS POKEMON SON LOS QUE RESTAN: ");
                            int counterF = 0;
                            for(int i=0;i<5;i++){
                                if(fire.equals(checkPokemonSize1)){
                                    System.out.println((counterF+1) + ". " + fName[i] + "\t" +fSize[i]);
                                    counterF++;
                                }
                            }
                            System.out.println("\n");
                            int counterW = 0;
                            for(int j=0;j<5;j++){
                                if(water.equals(checkPokemonSize1)){
                                    System.out.println((counterW+1) + ". " + wName[j] + "\t" + wSize[j]);
                                    counterW++;
                                }
                            }
                            System.out.println("\n");
                            int counterP = 0;
                            for(int k=0;k<5;k++){ 
                                if(plant.equals(checkPokemonSize1)){
                                    System.out.println((counterP+1) + ". " + pName[k] + "\t" + pSize[k]);
                                    counterP++;
                                }
                            }
                        }
                    else{/*USER IS WRONG*/
                            System.out.println("EL TIPO " + checkPokemonSize1 + " NO ES EL TIPO DEL POKEMON POR ADIVINAR.\n\n ESTOS POKEMON SON LOS QUE RESTAN: ");
                            int counterF = 0;
                            for(int i=0;i<5;i++){
                                if(!fire.equals(checkPokemonSize1)){
                                    System.out.println((counterF+1) + ". " + fName[i] + "\t" + fSize[i] );
                                    counterF++;
                                }
                            }
                            System.out.println("\n");
                            int counterW = 0;
                            for(int j=0;j<5;j++){
                                if(!water.equals(checkPokemonSize1)){
                                    System.out.println((counterW+1) + ". " + wName[j] + "\t" +wSize[j] );
                                    counterW++;
                                }
                            }
                            System.out.println("\n");
                            int counterP = 0;
                            for(int k=0;k<5;k++){
                                if(!plant.equals(checkPokemonSize1)){
                                    System.out.println((counterP+1) + ". " + pName[k] + "\t" +pSize[k]);
                                    counterP++;
                                }
                            }
                            attempts--;
                            if(attempts==0){
                                attemptsBool = false;
                            }
                            /*CHECKING THE CONDITION OF THE ATEMPTS */
                        }
                    break;
                case 4:/*OPTIONS FOR ATTACK TYPES*/
                    System.out.println("ESTAS SON LAS OPCIONES:\n\na) HYDRO PUMP\nb) SOLAR BEAM\nc) ERUPTION\nd) FLAMETHROWER\ne) AQUA JET\nf) WHIRLPOOL\ng) SYNTHESIS\nh) PETAL DANCE");
                    System.out.println("TIPO FUEGO\n");
                    int attackF = 0;
                    for(int i=0;i<5;i++){
                            System.out.println((attackF+1) + ". " + fName[i] + "\t" +fAttack[i]);
                            attackF++;
                    }
                    System.out.println("\nTIPO AGUA\n");
                    int attackW = 0;
                    for(int j=0;j<5;j++){
                            System.out.println((attackW+1) + ". " + wName[j] + "\t" +wAttack[j]);
                            attackW++;
                    }
                    System.out.println("\nTIPO PLANTA\n");
                    int attackP = 0;
                    for(int k=0;k<5;k++){
                            System.out.println((attackP+1) + ". " + pName[k] + "\t" +pAttack[k]);
                            attackP++;
                    }
                    System.out.println("\n\nESCRIBE EL TAMAÑO QUE CREES QUE TIENE EL POKEMON: ");
                    Scanner sc4 = new Scanner(System.in);
                    String getPokemonSize3 = sc4.nextLine();/*SAVING THE INPUT OF THE USER*/
                    String checkPokemonSize3 = getPokemonSize3.toLowerCase();/*CHANGING TO LOWER CASE*/
                    /*CHECKING SIZE FOR THE FIRE TYPE POKEMONS*/
                    System.out.println("\n\n");
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(fName[i])){
                            tempNameSpace = fAttack[i];/*ALOCATING THE SIZE OF THE CHOSEN POKEMON IN THIS CASE TEMPNAMESPACE WILL REFER TO THE POKEMON ATTACK*/
                        }
                        else{
                            continue;
                        }
                        }
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(wName[i])){
                            tempNameSpace = wAttack[i];/*ALOCATING THE SIZE OF THE CHOSEN POKEMON IN THIS CASE TEMPNAMESPACE WILL REFER TO THE POKEMON ATTACK*/
                        }
                        else{
                            continue;
                        }
                        }  
                    for(int i=0;i<5;i++){
                        if (chosenPokName.equals(pName[i])){
                            tempNameSpace = pAttack[i];/*ALOCATING THE SIZE OF THE CHOSEN POKEMON IN THIS CASE TEMPNAMESPACE WILL REFER TO THE POKEMON ATTACK*/
                        }
                        else{
                            continue;
                        }
                        }  
                        if(checkPokemonSize3.equals(tempNameSpace)){/*IF THE USER IS CORRECT*/
                            System.out.println("EL ATAQUE DEL POKEMON ES " + checkPokemonSize3 + " ESTOS POKEMON SON LOS QUE RESTAN: ");
                            int counterF = 0;
                            for(int i=0;i<5;i++){
                                if(fAttack[i].equals(checkPokemonSize3)){
                                    System.out.println((counterF+1) + ". " + fName[i] + "\t" +fAttack[i]);
                                    counterF++;
                                }
                            }
                            System.out.println("\n");
                            int counterW = 0;
                            for(int j=0;j<5;j++){
                                if(wAttack[j].equals(checkPokemonSize3)){
                                    System.out.println((counterW+1) + ". " + wName[j] + "\t" + wAttack[j]);
                                    counterW++;
                                }
                            }
                            System.out.println("\n");
                            int counterP = 0;
                            for(int k=0;k<5;k++){ 
                                if(pAttack[k].equals(checkPokemonSize3)){
                                    System.out.println((counterP+1) + ". " + pName[k] + "\t" + pAttack[k]);
                                    counterP++;
                                }
                            }
                        }
                    else{/*USER IS WRONG*/
                            System.out.println("EL ATAQUE " + checkPokemonSize3 + " NO ES LA DEL POKEMON POR ADIVINAR.\n\n ESTOS POKEMON SON LOS QUE RESTAN: ");
                            int counterF = 0;
                            for(int i=0;i<5;i++){
                                if(!fAttack[i].equals(checkPokemonSize3)){
                                    System.out.println((counterF+1) + ". " + fName[i] + "\t" + fAttack[i] );
                                    counterF++;
                                }
                            }
                            System.out.println("\n");
                            int counterW = 0;
                            for(int j=0;j<5;j++){
                                if(!wAttack[j].equals(checkPokemonSize3)){
                                    System.out.println((counterW+1) + ". " + wName[j] + "\t" + wAttack[j] );
                                    counterW++;
                                }
                            }
                            System.out.println("\n");
                            int counterP = 0;
                            for(int k=0;k<5;k++){
                                if(!pAttack[k].equals(checkPokemonSize3)){
                                    System.out.println((counterP+1) + ". " + pName[k] + "\t" + pAttack[k]);
                                    counterP++;
                                }
                            }
                            attempts--;
                            if(attempts==0){/*LOSING CONDITION*/
                                attemptsBool = false;
                                FileCreator.finalScoreBoard(score, loses, tempUserName);
                            }
                            /*CHECKING THE CONDITION OF THE ATEMPTS */
                        }
                break;
                default:
                    System.out.println("TU INPUT NO FUE LEGIBLE. EL NUMERO DE INTENTOS NO SE VERA AFECTADO. POR FAVOR INTENTA DE NUEVO.");
                    break;
                }
            }
            return ' ';
}
}

    

