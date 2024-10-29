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
    public static char GuessWho(){
        /*variables*/
        int op;
        String tempNameSpace = " ";
        /*variables for for attempts and win condition */
        int guess = 0;
        int attmps = 5;
        do{
            /*THE GAME MUST KEEP GOING UNTIL EITHER THE POKEMON IS GUESSED OR THE USER RUNS OUT OF ATTEMPTS*/
            System.out.println("\nCOMENCEMOS!\tPARA ADIVINAR TENDRAS QUE ELEJIR UNA DE LAS SIGUIENTES OPCIONES.\tTIENES 5 INTENTOS\n\n1.NOMBRE DEL POKEMON.\t2.TAMAÑO DEL POKEMON\t3.TIPO DEL POKEMON.\t4.ATAQUE DEL POKEMON\n");
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
                        }
                        else if(!checkPokemonName.equals(chosenPokName)){
                            System.out.println("EL NOMBRE DEL POKEMON POR ADIVINAR NO ES  " + checkPokemonName + ("\tINTENTA DE NUEVO\n"));
                            attmps = attmps--; 
                        }
                    break;
                case 2: /*OPTION FOR SIZES*/
                    System.out.println("a) SMALL\tb) MEDIANO\tc) GRANDE");
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
                            for(int i=0;i<5;i++){
                                if(!fSize[i].equals(checkPokemonSize)){
                                    System.out.println(fName[i] + fSize[i]);/*CLEAR SECOND SECTION AFTER TESTS*/
                                }
                            }
                            for(int j=0;j<5;j++){
                                if(!wSize[j].equals(checkPokemonSize)){
                                    System.out.println(wName[j] + wSize[j]);/*CLEAR SECOND SECTION AFTER TESTS*/
                                }
                            }
                            for(int k=0;k<5;k++){ 
                                if(!pSize[k].equals(checkPokemonSize)){
                                    System.out.println(pName[k] + pSize[k]);/*CLEAR SECOND SECTION AFTER TESTS*/
                                }
                            }
                        }
                    else{/*USER IS WRONG*/
                            System.out.println("EL TAMAÑO " + checkPokemonSize + " NO ES LA DEL POKEMON POR ADIVINAR.\n\n ESTOS POKEMON SON LOS QUE RESTAN: ");
                            for(int i=0;i<5;i++){
                                if(!fSize[i].equals(checkPokemonSize)){
                                    System.out.println(fName[i] + fSize[i]);/*CLEAR SECOND SECTION AFTER TESTS*/
                                }
                            }
                            for(int j=0;j<5;j++){
                                if(!wSize[j].equals(checkPokemonSize)){
                                System.out.println(wName[j] + wSize[j]);/*CLEAR SECOND SECTION AFTER TESTS*/
                                }
                            }
                            for(int k=0;k<5;k++){
                                if(!pSize[k].equals(checkPokemonSize)){
                                System.out.println(pName[k] + pSize[k]);/*CLEAR SECOND SECTION AFTER TESTS*/
                                }
                            }
                            }
                    break;
                case 3:/*OPTION FOR POKEMON TYPE*/
                    System.out.println("a) TIPO FUEGO\tb) TIPO AGUA\t TIPO PLANTA");
                    break;
                case 4:/*OPTIONS FOR ATTACK TYPES*/
                    System.out.println("a) HYDRO PUMP\nb) SOLAR BEAM\nc) ERUPTION\nd) FLAMETHROWER\ne) AQUA JET\nf) WHIRLPOOL\ng) SYNTHESIS\nh) PETAL DANCE");
                default:
                    System.out.println("Tu input no fue el correcto. El numero de intentos no se verá afectado. Por favor intenta de nuevo.");
                    break;
                }
            }while(guess!=1);
            return ' ';
}
}

    

