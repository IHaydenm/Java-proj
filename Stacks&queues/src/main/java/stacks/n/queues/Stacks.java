package main.java.stacks.n.queues;
import java.util.Scanner;

public class Stacks {
    int max;
    char stack[];
    int top;
    char lastVal;
    public Stacks(int max, int top){
        this.max = max;
        this.top = top;
        this.stack = new char[max];
    }
    public char inChars(){
        System.out.println("Escriba el caracter:  ");
        Scanner sc = new Scanner(System.in);
        stack[top]=sc.next().charAt(0);
        lastVal= stack[top];
        top++;
        return(lastVal);
    }
    public char pop(){
        if (top == 0){
            System.out.println("The stack is currently empty");
            return('#');
        }
        else{
            top--;
            lastVal = stack[top];
            return(lastVal);
        }
    }
}
