package FILESTASK;

import java.util.Random;

public class WaterPok extends PokemonSel{
    public WaterPok(int maxPokLim){
        WaterPok.wName = new String[maxPokLim];
        //ASIGNING A NAME FOR EACH POSITION OF WNAME ARRAY
        wName[0] = "squirtle";
        wName[1] = "totodile";
        wName[2] = "mudkip";
        wName[3] = "froakie";
        wName[4] = "quaxli";
        //SELECTING THE POWERS EACH POKEMON WILL HAVE
        Random random = new Random();
        int atkNbr = random.nextInt(0, 7);
            wAttack[0] = Attack[atkNbr];
            wAttack[1] = Attack[atkNbr];
            wAttack[2] = Attack[atkNbr];
            wAttack[3] = Attack[atkNbr];
            wAttack[4] = Attack[atkNbr];
            //MANUALY SELECTING THE SIZE OF THE POKEMON
                wSize[0] = PokemonSel.pokS[0];
                wSize[1] = PokemonSel.pokS[0];
                wSize[2] = PokemonSel.pokS[0];
                wSize[3] = PokemonSel.pokS[0];
                wSize[4] = PokemonSel.pokS[0];
        }   
    }