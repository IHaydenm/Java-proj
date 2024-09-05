package com.mycompany.ui.restaurant;
import java.util.Scanner;
public class UIRestaurant {
    public static void main(String[] args) {
        String cont = "waiter1";
        String contOr;
        int opti;
        String size;
        int checknum;
        do{
            System.out.println("Welcome. Please enter your password");
            Scanner pass = new Scanner(System.in);
            contOr = pass.nextLine();
        }while(!(contOr).equals(cont));
        while(true){
            System.out.println("Which table is being served. (TYPE THE TABLE NUMBER)\n\nTable number: ");
            Scanner getchecknum = new Scanner(System.in);
            checknum = getchecknum.nextInt();
            System.out.println("Welcome to 'MyFoods' this are the current options: \n\n1. Appetizers\n2. Lunchs\n3.Meals\n4. Drinks\n5. Desserts\n\nwaiter");
            Scanner getopti = new Scanner(System.in);
            opti = getopti.nextInt();
            switch(opti){
                case 1:
                    System.out.println("Select the portion size Select its size: 'small'   'regular'   'big'. (TYPE THE SIZE)\n\n Your selecction: ");
                        Scanner getSize = new Scanner(System.in);
                        size = getSize.nextLine();
                        Appetizers nappetizer = new Appetizers(size, checknum);
                        System.out.println(nappetizer.getAppetizersPrice());
                    break;
                case 2:
                    //Lunchs
                    break;
                case 3:
                    //Meals
                    break;
                case 4:
                    //drinks
                    break;
                case 5:
                    //Desserts
                    break;
                case 6: 
                    //reset bill
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("The input was unintelligible. Try again.");
            }
        }
    }
}
