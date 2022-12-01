package com.artstation.leagueofleguends

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.artstation.leagueofleguends.data.Champion
import com.artstation.leagueofleguends.databinding.ActivityDetailChampionBinding
import com.bumptech.glide.Glide
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
        val number = Random.nextInt(0, 3)
        Glide.with(this)
            .load(
                "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champion.name}_" + number + ".jpg"
            )
            .into(binding.image)
    }
}