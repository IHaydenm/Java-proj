package FILESTASK;

import java.util.Random;

public class FirePok extends PokemonSel{
    public FirePok(int maxPokLim){
        FirePok.fName = new String[maxPokLim];
        //ASIGNING A NAME FOR EACH POSITION OF FNAME ARRAY
        fName[0] = "charmander";
        fName[1] = "cyndaquil";
        fName[2] = "torchic";
        fName[3] = "litten";
        fName[4] = "fuecoco";
        int atkNbr = 0;
        //SELECTING THE POWERS EACH POKEMON WILL HAVE
        Random random = new Random();
        for(int i=0;i<5;i++){
            atkNbr = random.nextInt(0, 7);
            fAttack[i] = Attack[atkNbr];
       }
            //MANUALY SELECTING THE SIZE OF THE POKEMON
                fSize[0] = PokemonSel.pokS[0];
                fSize[1] = PokemonSel.pokS[1];
                fSize[2] = PokemonSel.pokS[0];
                fSize[3] = PokemonSel.pokS[2];
                fSize[4] = PokemonSel.pokS[2];
        }   
    }
