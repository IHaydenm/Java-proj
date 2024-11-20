package Proy_Final_Biblio;
public abstract class Libro {
    static String myPCPath = "C:/Users/katco/Documents/les javas/testui/src/Proy_Final_Biblio";
    String titulo;
    String autor;
    String[] genero = new String[4];{
        genero[0] = "epico";
        genero[1] = "lirico";
        genero[2] = "dramatico";
        genero[3] = "didactico";
    }
    String isbn;
}
