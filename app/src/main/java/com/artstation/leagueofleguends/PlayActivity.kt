package com.artstation.leagueofleguends

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import com.artstation.leagueofleguends.data.ServerApi
import com.artstation.leagueofleguends.databinding.ActivityPlayBinding
import com.artstation.leagueofleguends.viewmodel.FarmCalculator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.random.Random


class PlayActivity : AppCompatActivity() {
    private var count = 0
    private var time = ""
    val handler = Handler(Looper.myLooper()!!)
    private var textToSpeech: TextToSpeech? = null
    lateinit var binding: ActivityPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        runnable.run()
        textToSpeech = TextToSpeech(applicationContext) { i ->
            if (i != TextToSpeech.ERROR) {
                textToSpeech!!.language = Locale.ROOT
            }
        }
    }


    private val runnable: Runnable = object : Runnable {
        var count = 0
        override fun run() {
            getChampions()

            if (count++ < 1000) {
                handler.postDelayed(this, 7000)
            }
        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.14:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getChampions() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ServerApi::class.java)
                .getChampions("")
            if (call != null) {
                val champion = call.body()?.players?.get(0)
                val game = call.body()?.game
                runOnUiThread {
                    binding.nameChampion.text =
                        champion?.championName + " / " + champion?.summonerName
                    var number = Random.nextInt(0, AUDIOS.size - 1)

                    binding.kills.text =
                        champion?.scores?.kills?.toString() + "/" + champion?.scores?.deaths?.toString() + "/" + champion?.scores?.assists?.toString()
                    game?.gameData?.gameTime?.let {
                        binding.time.text = it.div(60.0).toString().split(".")[0]
                        //textToSpeech?.speak(FarmCalculator().minionsCount(it.div(60.0).toString().split(".")[0].toInt(), game.allPlayers.get(0).scores.creepScore.toInt()), TextToSpeech.QUEUE_ADD, null)
                        textToSpeech?.speak(FarmCalculator().killsCount(it.div(60.0).toString().split(".")[0].toInt(), game.allPlayers.get(0).scores.kills.toInt()), TextToSpeech.QUEUE_ADD, null)
                        textToSpeech?.speak(FarmCalculator().deadCount( game.allPlayers.get(0).scores.deaths.toInt()), TextToSpeech.QUEUE_ADD, null)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

}