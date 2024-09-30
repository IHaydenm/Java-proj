import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) throws Exception {
        int row, column;
        while(true){
            System.out.println("Hey! How many rows does your matrix has:  ");
            Scanner sc = new Scanner(System.in);
            row = sc.nextInt();
            System.out.println("And what about the columns? How many columns does your matrix has:  ");
            Scanner sc1 = new Scanner(System.in);
            column = sc1.nextInt();
            Matgen[] mymatrx = new Matgen[2];
            mymatrx[0] = new Matgen(row, column);
            mymatrx[1] = new Matgen(row, column);
            System.out.println(mymatrx[0].MatFiller());
            System.out.println("Matrix number 1 has been filled\n");
            System.out.println(mymatrx[1].MatFiller());
            System.out.println("Matrix number 2 has been filled\n");
            System.out.println("\n" + mymatrx[0].MatPrint());
            System.out.println("\n" + mymatrx[1].MatPrint());
        }
    }
}
