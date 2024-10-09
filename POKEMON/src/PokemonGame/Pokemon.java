package PokemonGame;

public class Pokemon {
    public static void main(String[] args) throws Exception {    
        WaterPokemon myWaterPokemon = new WaterPokemon(5);
        FirePokemon myFirePokemon = new FirePokemon(5);
        PlantPokemon myPlantPokemon = new PlantPokemon(5);
        System.out.println(PokemonType.randomPokChoosing());
    }
}
