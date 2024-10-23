package FILESTASK;

import java.util.Random;

public class PlantPok extends PokemonSel{
    public PlantPok(int maxPokLim){
        PlantPok.pName = new String[maxPokLim];
        //ASIGNING A NAME FOR EACH POSITION OF WNAME ARRAY
        pName[0] = "Bulbasaur";
        pName[1] = "Chikorita";
        pName[2] = "Treecko";
        pName[3] = "Rowlet";
        pName[4] = "Sprigatito";
        //SELECTING THE POWERS EACH POKEMON WILL HAVE
        Random random = new Random();
        int atkNbr = random.nextInt(0, 7);
            pAttack[0] = Attack[atkNbr];
            pAttack[1] = Attack[atkNbr];
            pAttack[2] = Attack[atkNbr];
            pAttack[3] = Attack[atkNbr];
            pAttack[4] = Attack[atkNbr];
            //MANUALY SELECTING THE SIZE OF THE POKEMON 
                pSize[0] = PokemonSel.pokS[0];
                pSize[1] = PokemonSel.pokS[0];
                pSize[2] = PokemonSel.pokS[1];
                pSize[3] = PokemonSel.pokS[0];
                pSize[4] = PokemonSel.pokS[2];
        }   
    }