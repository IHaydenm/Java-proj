package com.mycompany.ui.restaurant;
import java.util.Scanner;
public class Appetizers {
    int aptop;
    int checknum;
    double frenchF = 2;
    double cheeseF = 2;
    double curlyF = 2;
    double onionR = 1.5;
    double chickenT = 3;
    double garlicB = 1.5;
    String conf;
    double price;
    double check[] = new double[100]; //counting on the fact of a restaurant not having more than 60 tables for customers
    String size;
    public Appetizers(String size, int checknum){
        this.size = size;
        this.checknum = checknum;
    }
    public double getAppetizersPrice(){
        System.out.println("==Appetizers menu==\n\n1. French fries\n2. Cheese fries\n3. Curly fries\n4. Onion rings\n5. Chicken tenders\n6. Garlic bread.\n (TO SELECT AN OPTION TYPE ITS NUMBER)\n\n Your selecction: ");
        Scanner getapt = new Scanner(System.in);
        aptop = getapt.nextInt();
            switch (aptop) {
                case 1:
                    if (size.equals("small")){
                        frenchF = frenchF-1;
                    }
                    else if (size.equals("regular")) {
                       frenchF = 2;
                    }
                    else if (size.equals("big")) {
                        frenchF = frenchF+5;
                    }
                    System.out.println("French fries are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                    Scanner getconf = new Scanner(System.in);
                    conf = getconf.nextLine();
                    String confL = conf.toLowerCase();
                    if (confL.equals("yes")){
                        check[checknum] = check[checknum] + frenchF;
                        System.out.println("Added to the check");
                    }
                    else{
                        break;
                    }
                    break;
                case 2:
                    if (size.equals("small")){
                        cheeseF = cheeseF-1;
                    }
                    else if (size.equals("regular")) {
                        cheeseF = 2;
                    }
                    else if (size.equals("big")) {
                        cheeseF = cheeseF+5;
                    }
                    System.out.println("Cheese fries are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                    Scanner getconf1 = new Scanner(System.in);
                    conf = getconf1.nextLine();
                    String confL1 = conf.toLowerCase();
                    if (confL1.equals("yes")){
                            check[checknum] = check[checknum] + cheeseF;
                        System.out.println("Added to the check");
                    }
                    else{
                        break;
                    }
                    break;
                case 3:
                for(int i=0;i<=1;i++){
                    curlyF = 2;
                }
                    if (size.equals("small")){
                        curlyF = curlyF-1;
                    }
                    else if (size.equals("regular")) {
                        curlyF = 2;
                    }
                    else if (size.equals("big")) {
                        curlyF = curlyF+5;
                    }
                    System.out.println("Curly fries are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                        Scanner getconf2 = new Scanner(System.in);
                        conf = getconf2.nextLine();
                        String confL2 = conf.toLowerCase();
                        if (confL2.equals("yes")){
                                check[checknum] = check[checknum] + curlyF;
                            System.out.println("Added to the check");
                        }
                        else{
                            break;
                        }
                        break;   
                case 4:
                for(int i=0;i<=1;i++){
                    onionR = 1.5;
                }
                    if (size.equals("small")){
                        onionR = onionR-1;
                    }
                    else if (size.equals("regular")) {
                        onionR = 2;
                    }
                    else if (size.equals("big")) {
                        onionR = onionR+5;
                    }
                    System.out.println("Onion rings are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                        Scanner getconf3 = new Scanner(System.in);
                        conf = getconf3.nextLine();
                        String confL3 = conf.toLowerCase();
                        if (confL3.equals("yes")){
                                check[checknum] = check[checknum] + onionR;
                            System.out.println("Added to the check");
                        }
                        else{
                            break;
                        }
                        break;
                case 5:
                for(int i=0;i<=1;i++){
                    chickenT = 3;
                }
                    if (size.equals("small")){
                        chickenT = chickenT-1;
                    }
                    else if (size.equals("regular")) {
                        chickenT = 3;
                    }
                    else if (size.equals("big")) {
                        chickenT = chickenT+3;
                    }
                    System.out.println("Chicken tender are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                        Scanner getconf4 = new Scanner(System.in);
                        conf = getconf4.nextLine();
                        String confL4 = conf.toLowerCase();
                        if (confL4.equals("yes")){
                            check[checknum] = check[checknum] + chickenT;
                            System.out.println("Added to the check");
                        }
                        else{
                            break;
                        }
                        break;
                case 6:
                for(int i=0;i<=1;i++){
                    garlicB = 1.5;
                }
                    if (size.equals("small")){
                        garlicB = garlicB-1;
                    }
                    else if (size.equals("regular")) {
                        garlicB = 1.5;
                    }
                    else if (size.equals("big")) {
                        garlicB = garlicB+1.5;
                    }
                    System.out.println("Chicken tender are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                        Scanner getconf5 = new Scanner(System.in);
                        conf = getconf5.nextLine();
                        String confL5 = conf.toLowerCase();
                        if (confL5.equals("yes")){
                                check[checknum] = check[checknum] + garlicB;
                            System.out.println("Added to the check");
                        }
                        else{
                            break;
                        }
                        break;
                default:
                    System.out.println("The input was unintelligible. Try again.");
                break;
            }
        return check[checknum];
    }
}
