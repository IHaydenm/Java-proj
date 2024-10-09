package Randoms;
import java.util.Random;
import java.util.Scanner;
public class RandomsNumbers {
    public static void main(String[] args) {
        while(true){
        System.out.println("Si quieres sumar numeros seudoaleatoreos, lee A). Si quieres hacer una secuencia de numeros seudoaleatoreos pares lee B). Si quieres simular un lanzado de dados lee C)\n\n A) Cuantos numeros vamos a sumar? tiene que ser un numero par.\n\n B) Cuantos numeros vamos a querer imprimir.\n\n C) De cuantos lados es tu dado?\n\nTU OPCION:");
        Scanner sc = new Scanner(System.in);
        int numLim = sc.nextInt();
        NumberSec myNumSec = new NumberSec(numLim);
        DiceSim myDice = new DiceSim(numLim);
        System.out.println("\nQue quieres hacer.\n1.Imprimir sumas de numeros seudoaleatoreos\n2.Imprimir una secuencia de numeros seudoaleatoreos unicamente pares\n3.Lanzar un dado!\n\nTU OPCION:  ");
        Scanner sc1 = new Scanner(System.in);
        int op = sc1.nextInt();
        switch (op) {
            case 1:
                int randomNum[] =  new int[numLim];
                for(int i=0; i<numLim; i++){
                    Random random = new Random();
                    randomNum[i] = random.nextInt(-100, 100);
                    System.out.println("This is a random number!  "+ randomNum[i]);
                }
                for(int j=1; j<numLim; j++){
                    int addition;
                    addition = randomNum[j-1] + randomNum[j];
                    System.out.println("This is an addition!  "+ addition);
                }
            break;
            case 2:
                System.out.println(myNumSec.NumberSecGen());
            break;
            case 3:
                System.out.println("\n" +myDice.DiceSimulation()+"\n\n");
            break;
            case 100:
                System.exit(0);
                sc.close();
                sc1.close();
            break;
            default:
            System.out.println("What");
            
                break;
        }
    }   
    }
    }

