package PokemonGame;

import java.util.Random;

public class FirePokemon extends PokemonType{
    String pokName;
    String[] size = {"small","medium","big"};
    public FirePokemon(int maxPokLim){
        fName[0] = "Charmander";
        fName[1] = "Cyndaquil";
        fName[2] = "Torchic";
        fName[3] = "Litten";
        fName[4] = "Fuecoco";
                Random random = new Random();
                int atkNbr = random.nextInt(0, 7);
                fAttack[0] = Attack[atkNbr];
                fAttack[1] = Attack[atkNbr];
                fAttack[2] = Attack[atkNbr];
                fAttack[3] = Attack[atkNbr];
                fAttack[4] = Attack[atkNbr];
                fSize[0] = Size[0];
                fSize[1] = Size[1];
                fSize[2] = Size[0];
                fSize[3] = Size[2];
                fSize[4] = Size[2];
        }   
    }
