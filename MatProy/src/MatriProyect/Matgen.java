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
        System.out.println("\n");
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
            System.out.println("This opperation cannot be executed, for "+row+" does not equal "+column);
        }
        return ' ';
    }
    public char MaxNumber(){
        int op;
        String check4op;
        int prevMaxNumber = 0;
        int prevMaxNumber1 = 0;
        do{
        System.out.println("From which of the two matrix do you want to find the maximum value?\tNo. 1 or No. 2\n\nYOUR SELECTION: ");
        Scanner sc = new Scanner(System.in);
        op = sc.nextInt();
        if(op==1){
        for (int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int nwMaxNumber = matrx[i][j];
                if(nwMaxNumber>=prevMaxNumber){
                    prevMaxNumber = nwMaxNumber;
                }
                else{
                    System.out.println("Checking...");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){e.printStackTrace();}
                }
            }
        }
        System.out.println("This is the maximum value of the matrix " + prevMaxNumber);
        }
        else if(op==2){
            for (int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    int nwMaxNumber1 = matrx1[i][j];
                    if(nwMaxNumber1>=prevMaxNumber1){
                        prevMaxNumber1 = nwMaxNumber1;
                    }
                    else{
                        System.out.println("Checking...");
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e){e.printStackTrace();}
                    }
                }
            }
            System.out.println("This is the maximum value of the matrix " + prevMaxNumber1);
        }
        else{
            System.out.println("The input was unintelligible");
        }
        System.out.println("Do you wish to exit this menu? (WRITE DOWN THE OPTION)\n\nYES or NO: ");
        Scanner sc1 = new Scanner(System.in);
        String checkop = sc1.nextLine();
        check4op = checkop.toLowerCase();
    }while(!check4op.equals("yes"));
    return ' ';
}
}