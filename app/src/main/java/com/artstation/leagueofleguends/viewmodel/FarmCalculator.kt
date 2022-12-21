package com.artstation.leagueofleguends.viewmodel

import com.artstation.leagueofleguends.*
import kotlin.random.Random

class FarmCalculator {

    /*fun minionsCount (tiempo: Int, minions: Int):String{

        if (tiempo>10 && minions<80){
            var number = Random.nextInt(0, FARMEO_MAL.size - 1)
            return FARMEO_MAL.get(number)
        }
        else{
            var number = Random.nextInt(0, FARMEO_BUENO.size - 1)
            return FARMEO_BUENO.get(number)
        }
        return  AUDIOS.get(0)
    }*/

    fun killsCount (tiempo: Int, kills: Int):String {

        if (tiempo >= 1  && kills >= 1){
            var number = Random.nextInt(0, KILLS_BIEN.size - 1)
            return KILLS_BIEN.get(number)
        }
        else{
            var number = Random.nextInt(0, KILLS_MAL.size - 1)
            return KILLS_MAL.get(number)
        }
        return  AUDIOS.get(0)

    }

    fun deadCount ( deads: Int):String  {


            var number = Random.nextInt(0, MUERTES_MAL.size - 1)
            return MUERTES_MAL.get(number).replace("**",deads.toString())

    }

}