package main.java.stacks.n.queues;
public class InvertString {
    String phrase;
    int finalValue;
    char[] arrPhrase;
    public InvertString(String phrase){
        this.phase = phrase;
        this.arrPhrase = new char[phrase.length()];
    }
    public void invertingString(){
        for(int i; i<=phrase.length(); i++){
            arrPhrase[i] = phrase.next().charAt(i); 
            }
            finalValue = phrase.length();
        for(int j; j<=phrase.length(); j++){
            System.out.println(arrPhrase[finalValue - j]);
            }
        }
    }