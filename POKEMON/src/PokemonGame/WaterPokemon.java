package PokemonGame;

public class WaterPokemon extends PokemonType{
    String pokName;
    String[] size = {"small","medium","big"};
    public WaterPokemon(int maxPokLim){
        this.maxPokLim = maxPokLim;
        wName[0] = "Squirtle";
        wName[1] = "Totodile";
        wName[2] = "Mudkip";
        wName[3] = "Froakie";
        wName[4] = "Quaxli";
    }
}