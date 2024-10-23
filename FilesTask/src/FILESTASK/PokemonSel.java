package FILESTASK;
import java.util.Random;
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
        pokS[0] = "pequeño";
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
        return chosenPokName;
        }
    public static char GuessWho(){
        System.out.println("\nCOMENCEMOS!\tPARA ADIVINAR TENDRAS QUE ELEJIR UNA DE LAS SIGUIENTES OPCIONES.\n\n1.NOMBRE DEL POKEMON.\t2.TAMAÑO DEL POKEMON\t3.TIPO DEL POKEMON.\t4.ATAQUE DEL POKEMON\n");
        /*ALL OPTIONS SHOWN IN LISTS*/
        System.out.println("\nPOKEMON DE FUEGO\na) CHARMANDER\tb) CYNDAQUIL\nc) TORCHIC\td) LITTEN\ne) FUECOCO\n\nPOKEMON DE AGUA\na) SQUIRTLE\tb) TOTODILE\nc) MUDKIP\td) FROAKIE\ne) QUAXIL\n\nPOKEMON DE PLANTA\na) BULBASAUR\tb) CHIKORITA\nc) TREECKO\td) ROWLET\ne) SPRIGATITO");
        /*NAMES*/
        return ' ';
    }
}
    

