package main.java.stacks.n.queues;
import java.util.Scanner;
public class Queues {
    int max;
    char queue[];
    int insert;
    char lastVal;
    public Queues(int max, int insert){
        this.max = max;
        this.insert = insert;
        this.queue = new char[max];
    }
    public void inChars(){
        System.out.println("Escriba el caracter:  ");
        Scanner sc = new Scanner(System.in);
        queue[insert]=sc.next().charAt(0);
        if (insert==max){
            System.out.println("The queue is full!");
        }else{
            lastVal = queue[insert];
            insert++;
        }
    }
    public char delete(){
        System.out.println("\nThe character in front of the queue");
        for(int i=0; i<=queue.length; i++){
            queue[insert-1] = queue[insert];
        }
        return(lastVal);
    }
}
