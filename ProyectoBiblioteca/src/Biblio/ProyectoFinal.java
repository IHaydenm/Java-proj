package Biblio;
import java.util.*;


public class ProyectoFinal{
        public static void main(String[] args) throws Exception {
        /*VARIABLES*/
        Scanner sc = new Scanner(System.in);
        int op = 0;
        Boolean keepsGoing = true;
        /*VARIABLES*/
        /*USER OBJECT*/
        Usuario myUsuario = new Usuario();
        Libros myLibros = new Libros();
        Prestamos myPrestamos =new Prestamos() {
            
        };
        /*USER OBJECT*/
        while (keepsGoing) {
        /*THIS SECTION OF THE PROGRAM WILL ASK THE USER WHICH OPTION OF THE AVIABLE WILL HE USE*/
        System.out.println("BIENVENIDO A LA INTERFAZ DE LA BIBLIOTECA.\n\nESTE ES EL MENU DE OPCIONES: \n\n1. REVISAR SI EL USUARIO YA SE ENCUENTRA EN EL SISTEMA DE LA BIBLIOTECA\t\t2. REVISAR EL CATALOGO DE LIBROS\n\n3. ENTRAR AL SISTEMA DE PEDIDOS");
        try {
            sc = new Scanner(System.in);
            op = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("EL VALOR QUE HA INSERTADO ES INVALIDO, INTENTE OTRA VEZ INTRODUCIENDO UN VALOR NUMERICO VALIDO.");
        }
        switch (op) {
            case 1:
                Boolean goes = true;
                System.out.println(myUsuario.CheckForUser(goes));
                break;
            case 2:
                goes = true;
                System.out.println(myLibros.CheckForBook(goes));
                break;
            case 3:
                goes = true;
                System.out.println(myPrestamos.AsksForBook(goes));
                break;
            default:
            System.out.println("NO EXISTE UNA OPCION CON EL INDICE QUE INTRODUJO. INTENTE OTRA VEZ");
                break;
        }
    } 
}
}
