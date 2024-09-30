package Randoms;
import java.util.Random;
public class NumberSec{
    int numberGen[];
    int numLim1;
    public NumberSec(int numLim1){
        this.numLim1 = numLim1;
        numberGen = new int[numLim1];
    }
    public char NumberSecGen(){
        for(int i=0; i<numLim1; i++){
            Random random = new Random();
            numberGen[i] = random.nextInt(-100, 100);
            if(numberGen[i]%2 == 0){
            System.out.println(numberGen[i]);
            }
            else{
                i--;
            }
        }
        return(' ');
    }
}