package com.mycompany.ui.restaurant;
import java.util.Scanner;
public class Appetizers {
    int aptop;
    double frenchF = 2;
    double cheeseF = 2;
    double curlyF = 2;
    double onionR = 1.5;
    double chickenT = 3;
    double garlicB = 1.5;
    String conf;
    double price;
    String size;
    public Appetizers(String size){
        this.size = size;
    }
    public int getAppetizersPrice(){
        System.out.println("==Appetizers menu==\n\n1. French fries\n2. Cheese fries\n3. Curly fries\n4. Onion rings\n5. Chicken tenders\n6. Garlic bread.\n (TO SELECT AN OPTION TYPE ITS NUMBER)\n\n Your selecction: ");
        Scanner getapt = new Scanner(System.in);
        aptop = getapt.nextInt();
            switch (aptop) {
                case 1:
                    if (size.equals("small")){
                        frenchF = frenchF-1;
                    }
                    else if (size.equals("regular"))) {
                       continue;
                    }
                    else if (size.equals("big")) {
                        frenchF = frenchF+6;
                    }
                    System.out.println("French fries are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                    Scanner getconf = new Scanner(System.in);
                    conf = getconf.nextLine();
                    if (conf.equals(getconf)){
                        price = price+frenchF;
                        System.out.println("Added to the check");
                    }
                    else{
                        continue;
                    }
                    break;
                case 2:
                    System.out.println("Cheese fries are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                    Scanner getconf1 = new Scanner(System.in);
                    conf = getconf1.nextLine();
                    if (conf.equals(getconf)){
                        price = price+cheeseF;
                        System.out.println("Added to the check");
                    }
                    else{
                        continue;
                    }
                    break;
                case 3:
                    System.out.println("Curly fries are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                        Scanner getconf2 = new Scanner(System.in);
                        conf = getconf2.nextLine();
                        if (conf.equals(getconf)){
                            price = price+curlyF;
                            System.out.println("Added to the check");
                        }
                        else{
                            continue;
                        }
                        break;    
                case 4:
                    System.out.println("Onion rings are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                        Scanner getconf3 = new Scanner(System.in);
                        conf = getconf3.nextLine();
                        if (conf.equals(getconf)){
                            price = price+onionR;
                            System.out.println("Added to the check");
                        }
                        else{
                            continue;
                        }
                        break;
                case 5:
                    System.out.println("Chicken tender are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                        Scanner getconf4 = new Scanner(System.in);
                        conf = getconf4.nextLine();
                        if (conf.equals(getconf)){
                            price = price+chickenT;
                            System.out.println("Added to the check");
                        }
                        else{
                            continue;
                        }
                        break;
                case 6:
                    System.out.println("Chicken tender are going to be added to the check. Do you wish to continue? (TYPE YES OR NO)\n\nYes or no:  ");
                    Scanner getconf5 = new Scanner(System.in);
                    conf = getconf5.nextLine();
                    if (conf.equals(getconf)){
                        price = price+garlicB;
                        System.out.println("Added to the check");
                    }
                    else{
                        continue;
                    }
                    break;
                default:
                    System.out.println("The input was unintelligible. Try again.");
                break;
            }
        return price;
    }
}
