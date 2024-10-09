package main.java.stacks.n.queues;
import java.util.Scanner;
import main.java.stacks.n.queues.Stacks;
public class Stacksnqueues {
    
    public static void main(String[] args) {
        int numChar, op;
        int top;
        String word;
        System.out.println("Numero de caracteres que vamos a guardar:  ");
        Scanner sc = new Scanner(System.in);
        numChar = sc.nextInt();
        top = 0;
        Stacks mystack = new Stacks(numChar, top);
        Queues myqueue = new Queues(numChar, top);
        while (true) {
            System.out.println("Opciones: 1. introducir caracteres al stack\t2. Sacar ultimo valor del stack\t3. Introducir caracteres a la queue\t4. Sacar primer valor de la queue\nSu opcion:  ");
            Scanner sc1 = new Scanner(System.in);
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println(mystack.inChars());
                    break;
                case 2:
                    System.out.println(mystack.pop());   
                    break;
                case 3:
                    System.out.println(myqueue.inChars());
                    break;
                case 4:
                    System.out.println(myqueue.delete());
                    break;
                case 5:
                    System.out.println("cual es la palabra que deseas invertir:  ");
                    Scanner sc2 = new Scanner(System.in);
                    word = sc2.nextLine();
                    InvertString myString = InvertString(word);
                    System.out.println(myString.invertingString());
                    break;
                default:
                    System.out.println("invalido, intente devuelta");
                    break;
            }   
        }
}
} 