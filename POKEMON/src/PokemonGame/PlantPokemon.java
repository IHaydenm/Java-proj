package PokemonGame;

import java.util.Random;

public class PlantPokemon extends PokemonType{
    String pokName;
    public PlantPokemon(int maxPokLim){
                pName[0] = "Bulbasaur";
                pName[1] = "Chikorita";
                pName[2] = "Treecko";
                pName[3] = "Rowlet";
                pName[4] = "Sprigatito";
                Random random = new Random();
                int atkNbr = random.nextInt(0, 7);
                pAttack[0] = Attack[atkNbr];
                pAttack[1] = Attack[atkNbr];
                pAttack[2] = Attack[atkNbr];
                pAttack[3] = Attack[atkNbr];
                pAttack[4] = Attack[atkNbr];
                pSize[0] = Size[0];
                pSize[1] = Size[0];
                pSize[2] = Size[1];
                pSize[3] = Size[0];
                pSize[4] = Size[2];
        }   
    }
