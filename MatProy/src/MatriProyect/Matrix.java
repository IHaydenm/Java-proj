package MatriProyect;
import java.util.Scanner;
public class Matrix {
    public static void main(String[] args){
        int row, column;
        while(true){
            System.out.println("Hey! How many rows does your matrix has:  ");
            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();
            System.out.println("And what about the columns? How many columns does your matrix has:  ");
            Scanner sc1 = new Scanner(System.in);
            column = sc1.nextInt();
            Matgen mymatrx = new Matgen(row, column);
            System.out.println(mymatrx.MatFiller());
            System.out.println("Matrix number 1 has been filled\n");
            System.out.println("Matrix number 2 has been filled\n");
            System.out.println("\n" + mymatrx.MatPrint());
            System.out.println("What are you trying to do?\n\n1.Add this two matrix.\t2.");
            Scanner sc2 = new Scanner(System.in);
            int op = sc2.nextInt();
            switch (op) {
                case 1:
                    System.out.println(mymatrx.MatAdder());                    
                    break;
                default:
                    break;
            }
        }        
    }
}
