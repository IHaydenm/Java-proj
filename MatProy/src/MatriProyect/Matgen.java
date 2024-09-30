package MatriProyect;
import java.util.Scanner;
public class Matgen {
    int row, column;
    int[][] matrx;
    int[][] matrx1;
    int[][] addedMat;
    public Matgen(int row, int column){
        this.row = row;
        this.column = column;
        this.matrx = new int[row][column];
        this.matrx1 = new int[row][column];
        this.addedMat = new int[row][column];
    }
    public char MatFiller(){
        for(int i=0; i<row; i++){
                for(int j=0;j<column; j++){
                System.out.println("Enter the value for the matrix no.1 at the position(" + i + ',' + j + ')');
                Scanner sc = new Scanner(System.in);
                int expVal = sc.nextInt();
                matrx[i][j] = expVal;
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0;j<column; j++){
            System.out.println("Enter the value for the matrix no.2 at the position(" + i + ',' + j + ')');
            Scanner sc = new Scanner(System.in);
            int expVal = sc.nextInt();
            matrx1[i][j] = expVal;
        }
    }
        return ' ';
    }
    public char MatPrint(){
        for(int i=0; i<row; i++){
            for(int j=0;j<column; j++){
                System.out.print(matrx[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n");
        for(int i=0; i<row; i++){
            for(int j=0;j<column; j++){
                System.out.print(matrx1[i][j] + " ");
            }
            System.out.println("");
        }
        return '\n';
    }
    public char MatAdder(){
        System.out.println("\n\n");
        if(row==column){
            for (int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(i==j){
                        addedMat[i][j] = matrx[i][j] + matrx1[i][j]; 
                    }
                    else{
                        addedMat[i][j] = 0;
                    }
                    System.out.print(addedMat[i][j] + " ");
                }
                System.out.println("");
            }
        }
        else{
            System.out.println("no se puede hacer esta operacion ya que "+row+" no equivale a "+column);
        }
        return ' ';
    }
}