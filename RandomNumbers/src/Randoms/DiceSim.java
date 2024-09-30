package Randoms;
import java.util.Scanner;
import java.util.Random;
public class DiceSim {
    int diceLim;
    public DiceSim(int diceLim){
        this.diceLim = diceLim;
    }
    public char DiceSimulation(){
        System.out.println("cuantas veces quieres que se lanze el dado?");
        Scanner sc2 = new Scanner(System.in);
        int throwCount = sc2.nextInt();
        for(int i=0; i<throwCount; i++){
            Random random = new Random();
            int ranNumber[] = new int[throwCount];
            ranNumber[i] = random.nextInt(1, diceLim);
            int a = i+1;
            System.out.println("\nEste es el lanzamiento numero "+ a + "  Este es el resultado: " + ranNumber[i]);
        }
        return ' ';
    }
}
