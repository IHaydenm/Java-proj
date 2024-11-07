package FILESTASK;
import java.util.Scanner;
public class mainFILESTASK {
    public static void main(String[] args) throws Exception {
        int op = 0;
        while((op!=1) || (op!=2)){
            System.out.println("HOLA! \tBIENVENIDO AL MENU DEL JUEGO ADIVINA QUIEN EDICION POKEMON.\tQUE QUIERES HACER?\n\n1. INICIAR SESION (PARA GUARDAR TUS PUNTAJES Y POSTERIORMENTE JUGAR)\t2. JUGAR SIN INICIAR SESION\n\nPARA ELEGIR INGRESA EL NUMERO DEL INCISO DE LA OPCION: ");
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();
            switch (op) {
                case 1:
                        System.out.println("\n\nCUAL ES TU NOMBRE DE USUARIO?\n\nTU NOMBRE: ");
                        Scanner sc1 = new Scanner(System.in);
                        String tempUserName = sc1.nextLine();
                        String userName = tempUserName.toUpperCase();
                        System.out.println(FileCreator.userFileFinder(userName));
                        WaterPok myWaterPokemon = new WaterPok(5);
                        FirePok myFirePokemon = new FirePok(5);
                        PlantPok myPlantPokemon = new PlantPok(5);
                        System.out.println(PokemonSel.PokemonSelection());
                        System.out.println(PokemonSel.GuessWho(userName));
                    break;
                case 2:
                        userName = " ";
                        WaterPok myWaterPokemon1 = new WaterPok(5);
                        FirePok myFirePokemon1 = new FirePok(5);
                        PlantPok myPlantPokemon1 = new PlantPok(5);
                        System.out.println(PokemonSel.PokemonSelection());
                        System.out.println(PokemonSel.GuessWho(userName));
                    break;
                default:
                System.out.println("TU INPUT NO FUE VALIDO, INTENTALO OTRA VEZ");
                    break;
            }
    }
}
}
