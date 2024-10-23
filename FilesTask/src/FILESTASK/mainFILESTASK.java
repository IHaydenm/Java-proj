package FILESTASK;
public class mainFILESTASK {
    public static void main(String[] args) throws Exception {
        System.out.println("HOLA! \tBienvenido al menu del juego Adivina quien edicion pokemon.\n\nEspera un segundo mientras se selecciona el pokemon.");
        WaterPok myWaterPokemon = new WaterPok(5);
        FirePok myFirePokemon = new FirePok(5);
        PlantPok myPlantPokemon = new PlantPok(5);
        System.out.println(PokemonSel.PokemonSelection());
        System.out.println(PokemonSel.GuessWho());
    }
}
