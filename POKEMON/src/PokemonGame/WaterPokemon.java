package PokemonGame;

import java.util.Random;

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
                Random random = new Random();
                int atkNbr = random.nextInt(0, 7);
                wAttack[0] = Attack[atkNbr];
                wAttack[1] = Attack[atkNbr];
                wAttack[2] = Attack[atkNbr];
                wAttack[3] = Attack[atkNbr];
                wAttack[4] = Attack[atkNbr];
                wSize[0] = Size[0];
                wSize[1] = Size[0];
                wSize[2] = Size[0];
                wSize[3] = Size[0];
                wSize[4] = Size[0];
        }   
    }
