import java.util.Scanner;
public class Matgen {
    int row, column;
    int[][] matrx;
    public Matgen(int row, int column){
        this.row = row;
        this.column = column;
        this.matrx = new int[row][column];
    }
    public char MatFiller(){
        for(int i=0; i<row; i++){
                for(int j=0;j<column; j++){
                System.out.println("Enter the value for the matrix position at (" + i + ',' + j + ')');
                Scanner sc = new Scanner(System.in);
                int expVal = sc.nextInt();
                matrx[i][j] = expVal;
            }
        }
        return '\n';
    }
    public char MatPrint(){
        for(int i=0; i<row; i++){
            for(int j=0;j<column; j++){
                System.out.print(matrx[i][j] + " ");
            }
            System.out.println("");
        }
        return '\n';
    }
}