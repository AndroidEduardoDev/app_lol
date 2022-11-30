package com.artstation.leagueofleguends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artstation.leagueofleguends.data.Champion
import com.artstation.leagueofleguends.databinding.ActivityDetailChampionBinding
import com.bumptech.glide.Glide

class DetailChampionActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailChampionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailChampionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        val champion: Champion = intent.extras?.get("champ") as Champion
        binding.name.text = champion.name
        binding.description.text = champion.champion?.blurb

        Glide.with(this)
            .load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champion.name}_0.jpg")
            .into(binding.image)
    }
}