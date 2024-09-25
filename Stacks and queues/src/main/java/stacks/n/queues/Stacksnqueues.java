package stacks.n.queues;
import java.util.Scanner;

import main.java.stacks.n.queues.Stacks;

public class Stacksnqueues {
    
    public static void main(String[] args) {
        int numChar, op;
        int top;
        System.out.println("Numero de caracteres que vamos a guardar:  ");
        Scanner sc = new Scanner(System.in);
        numChar = sc.nextInt();
        top = 0;
        Stacks mystack = new Stacks(numChar, top);
        Queues myqueue = new Queues(numChar, top);
        while (true) {
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
                default:
                    break;
            }   
        }
        
    }
}