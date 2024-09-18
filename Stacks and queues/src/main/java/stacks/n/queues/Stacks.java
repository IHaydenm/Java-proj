package main.java.stacks.n.queues;
public class Stacks {
    int max = 20;
    char stack = new char[max];
    int top;
    public Stacks(int max, int top){
        this.max = max;
        this.top = top;
    }
    public char pop(){
        if (top == 0){
            System.out.println("The stack is currently empty");
            return("");
        }
        else{
            top--;
            return("" + stack[]);
        }
    }


}
