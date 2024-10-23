package FILESTASK;

import java.util.Random;

public class FirePok extends PokemonSel{
    public FirePok(int maxPokLim){
        FirePok.fName = new String[maxPokLim];
        //ASIGNING A NAME FOR EACH POSITION OF FNAME ARRAY
        fName[0] = "Charmander";
        fName[1] = "Cyndaquil";
        fName[2] = "Torchic";
        fName[3] = "Litten";
        fName[4] = "Fuecoco";
        //SELECTING THE POWERS EACH POKEMON WILL HAVE
        Random random = new Random();
        int atkNbr = random.nextInt(0, 8);
            fAttack[0] = Attack[atkNbr];
            fAttack[1] = Attack[atkNbr];
            fAttack[2] = Attack[atkNbr];
            fAttack[3] = Attack[atkNbr];
            fAttack[4] = Attack[atkNbr];
            //MANUALY SELECTING THE SIZE OF THE POKEMON
                fSize[0] = PokemonSel.pokS[0];
                fSize[1] = PokemonSel.pokS[1];
                fSize[2] = PokemonSel.pokS[0];
                fSize[3] = PokemonSel.pokS[2];
                fSize[4] = PokemonSel.pokS[2];
        }   
    }
