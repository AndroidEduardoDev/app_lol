package com.artstation.leagueofleguends

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.webkit.URLUtil
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.artstation.leagueofleguends.data.Champion
import com.artstation.leagueofleguends.databinding.ActivityDetailChampionBinding
import com.bumptech.glide.Glide
import java.io.File
import kotlin.random.Random


class DetailChampionActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailChampionBinding
    private lateinit var champion: Champion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailChampionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        champion = intent.extras?.get("champ") as Champion
        binding.name.text = champion.name
        binding.description.text = champion.champion?.blurb
        binding.cancel.setOnClickListener { finish() }
        setImage()
    }


    private fun setImage() {
        var number = Random.nextInt(0, 3)
        var url =
            "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champion.champion?.id}_" + number + ".jpg"
        if (!URLUtil.isValidUrl(url)) {
            url =
                "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champion.champion?.id}_0.jpg"
        }
        Glide.with(this).load(url).into(binding.image)
        binding.btnE.setOnClickListener { setvideo("E") }
        binding.btnW.setOnClickListener { setvideo("W") }
        binding.btnR.setOnClickListener { setvideo("R") }
        binding.btnQ.setOnClickListener { setvideo("Q") }
        binding.cancelView.setOnClickListener {
            binding.cancelView.visibility = View.GONE
            binding.visualizer.visibility = View.GONE
            binding.loadingVideo.visibility = View.GONE
        }

    }

    private fun setvideo(s: String) {
        binding.visualizer.visibility = View.VISIBLE
        binding.cancelView.visibility = View.VISIBLE
        binding.loadingVideo.visibility = View.VISIBLE
        var uri: Uri = if (Integer.parseInt(champion.champion?.key) < 99) {
            Uri.parse("https://d28xe8vt774jo5.cloudfront.net/champion-abilities/00${champion.champion?.key}/ability_00${champion.champion?.key}_${s}1.webm")
        } else {
            Uri.parse("https://d28xe8vt774jo5.cloudfront.net/champion-abilities/0${champion.champion?.key}/ability_0${champion.champion?.key}_${s}1.webm")
        }
        binding.visualizer.setVideoURI(uri)
        binding.visualizer.start()
        binding.visualizer.setOnPreparedListener { mp ->
            mp.isLooping = true
            Handler(Looper.myLooper()!!).postDelayed({
                binding.loadingVideo.visibility = View.GONE
            }, 800)
            mp.setVolume(0f, 0f)
        }
    }

    override fun onDestroy() {
        binding.visualizer.start()
        super.onDestroy()
    }
}