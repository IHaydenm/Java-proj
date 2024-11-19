package Biblio;
import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Libro {
    static String myPCPath = "C:/Users/katco/Documents/les javas/ProyectoBiblioteca/src/Biblio";
    String titulo;
    String autor;
    String[] genero = new String[4];{
        genero[0] = "epico";
        genero[1] = "lirico";
        genero[2] = "dramatico";
        genero[3] = "didactico";
    }
    String isbn;
public char AsksForBook(){
    System.out.println("QUE USUARIO QUIERE HACER EL PEDIR PRESTADO UN LIBRO?");
    File FileMapDir = new File(myPCPath);/*OBTAINING THE INFORMATION COMING IN FORM SRC*/
        String[] ArchNames = FileMapDir.list();
        for(int i=0; i < ArchNames.length; i++){/*GIVING AN ARRAY THE NAMES FORM THE FILES INSIDE THE PARENT*/
            System.out.println(i+1 + ". " + ArchNames[i]);/*LISTING FILES INSIDE REPOSITORY*/
        } /*ERRASE AFTER TESTS */
    return ' ';
}
}
