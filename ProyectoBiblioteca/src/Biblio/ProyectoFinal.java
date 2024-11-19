package Biblio;
import java.util.*;


public class ProyectoFinal{
        public static void main(String[] args) throws Exception {
        /*VARIABLES*/
        int op = 0;
        Boolean keepsGoing = true;
        /*VARIABLES*/
        /*USER OBJECT*/
        Usuario myUsuario = new Usuario();
        /*USER OBJECT*/
        while (keepsGoing) {
        /*THIS SECTION OF THE PROGRAM WILL ASK THE USER WHICH OPTION OF THE AVIABLE WILL HE USE*/
        System.out.println("BIENVENIDO A LA INTERFAZ DE LA BIBLIOTECA.\n\nESTE ES EL MENU DE OPCIONES: \n\n1. REVISAR SI EL USUARIO YA SE ENCUENTRA EN EL SISTEMA DE LA BIBLIOTECA\t\t2. ");
        try {
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("EL VALOR QUE HA INSERTADO ES INVALIDO, INTENTE OTRA VEZ INTRODUCIENDO UN VALOR NUMERICO VALIDO.");
        }
        switch (op) {
            case 1:
                System.out.println(myUsuario.CheckForUser());
                break;
            case 2:
                break;
            default:
                break;
        }
    } 
}
}
