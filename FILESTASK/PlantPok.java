package FILESTASK;

import java.util.Random;

public class PlantPok extends PokemonSel{
    public PlantPok(int maxPokLim){
        PlantPok.pName = new String[maxPokLim];
        //ASIGNING A NAME FOR EACH POSITION OF WNAME ARRAY
        pName[0] = "bulbasaur";
        pName[1] = "chikorita";
        pName[2] = "treecko";
        pName[3] = "rowlet";
        pName[4] = "sprigatito";
        int atkNbr = 0;
        //SELECTING THE POWERS EACH POKEMON WILL HAVE
        Random random = new Random();
        for(int i=0;i<5;i++){
            atkNbr = random.nextInt(0, 7);
            pAttack[i] = Attack[atkNbr];
       }
            //MANUALY SELECTING THE SIZE OF THE POKEMON 
                pSize[0] = PokemonSel.pokS[0];
                pSize[1] = PokemonSel.pokS[0];
                pSize[2] = PokemonSel.pokS[1];
                pSize[3] = PokemonSel.pokS[0];
                pSize[4] = PokemonSel.pokS[2];
        }   
    }