package PokemonGame;
import java.util.Random;
import java.util.Scanner;

public abstract class PokemonType {
    int maxPokLim;
    static String[] pName = new String[5];
    static String[] fName = new String[5];
    static String[] wName = new String[5];
    static String chosenPokName;
    static String pokType;
    public static char randomPokChoosing(){
        System.out.println("Se esta seleccionando el pokemon de manera aleatorea. Espera un segundo");
            Random random = new Random();
            int pokSelect = random.nextInt(1,3);
            if(pokSelect==1){
                Random random1 = new Random();
                int chosenPok = random.nextInt(0,4);
                chosenPokName = pName[chosenPok];
            }
            else if(pokSelect==2){
                Random random2 = new Random();
                int chosenPok = random.nextInt(0,4);
                chosenPokName = wName[chosenPok];
            }
            else if(pokSelect==3){
                Random random3 = new Random();
                int chosenPok = random.nextInt(0,4);
                chosenPokName = fName[chosenPok];
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int tries=4;
            do{
            System.out.println("Tienes que adivinar el pokemon\tPuedes preguntar por el tamaño del pokemon, su clase, que ataque realiza y su nombre\n\n tienes 4 intentos en total, te quedan" +tries+".\n\nInput:  ");
            Scanner sc = new Scanner(System.in);
            String opChange = sc.nextLine();
            String op = opChange.toLowerCase();
            String wClass = "agua";
            String fClass = "fuego";
            String pClass = "planta";
            String sSize = "pequeño";
            String mSize = "mediano";
            String bSize = "grande";
            String hydro = "hydro pump";
            String solar = "solar beam";
            String eruption = "eruption";
            String flameT = "flamethrower";
            String aqua = "aqua jet";
            String Whirl = "whirlpool";
            String Synth = "synthesis";
            String Petal = "petal";
            if(op.equals(wClass)){
                System.out.println("La clase del pokemon es de agua\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(wName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(pClass)) {
                System.out.println("La clase del pokemon es de fuego\t Estos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(fName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(fClass)) {
                System.out.println("La clase del pokemon es de planta\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if(op.equals(hydro)){
                System.out.println("El ataque del pokemon es hydro pump\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(wName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(solar)) {
                System.out.println("El ataque del pokemon es solar beam\t Estos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(fName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(eruption)) {
                System.out.println("El ataque del pokemon es eruption\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(flameT)) {
                System.out.println("El ataque del pokemon es flamethrower\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }else if (op.equals(aqua)) {
                System.out.println("El ataque del pokemon es aqua jet\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(Whirl)) {
                System.out.println("El ataque del pokemon es whirlpool\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(Synth)) {
                System.out.println("El ataque del pokemon es synthesis\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(Petal)) {
                System.out.println("El ataque del pokemon es petal dance\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if(op.equals(sSize)){
                System.out.println("El tamaño del pokemon es pequeño\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(wName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(mSize)) {
                System.out.println("El tamaño del pokemon es mediano\t Estos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(fName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else if (op.equals(bSize)) {
                System.out.println("El tamaño del pokemon es grande\tEstos son los pokemon que restan");
                for(int i=0;i<=4;i++){
                System.out.println(pName[i]);
                }
                System.out.println("Puedes preguntar por el tamaño del pokemon, que ataque realiza y su nombre\n\n tienes" + tries + "intentos.\n\nInput:  ");
                
            }
            else{
                System.out.println("Tu opcion fue erronea. Intenta de nuevo");
                tries--;
            }
        }while(tries!=0);
        return ' ';
    }
}
