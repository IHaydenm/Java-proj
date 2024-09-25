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
            Matgen mymatrx = new Matgen(row, column);
            System.out.println(mymatrx.MatFiller());
            System.out.println("\n\n" + mymatrx.MatPrint());
        }
    }
}
