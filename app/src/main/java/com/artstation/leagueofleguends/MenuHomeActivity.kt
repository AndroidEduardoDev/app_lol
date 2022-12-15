package com.artstation.leagueofleguends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.ViewCompat.setBackground
import com.artstation.leagueofleguends.databinding.ActivityMenuHomeBinding
import com.bumptech.glide.Glide
import kotlin.random.Random

class MenuHomeActivity : AppCompatActivity() {

    companion object {
        val fondo = arrayOf(
            "background-aram2022.jpg282",
            "background-bandle_city.jpg",
            "background-bilgewater.jpg",
            "background-conqueror.jpg",
            "background-copilot.jpg",
            "background-default.jpg",
            "background-demacia.jpg",
            "background-freljord.jpg",
            "background-ionia.jpg",
            "background-ixtal.jpg",
            "background-landing.jpg",
            "background-lobby.jpg",
            "background-mount_targon.jpg",
            "background-msi2021.jpg",
            "background-msi2022.jpg",
            "background-noxus.jpg",
            "background-piltover.jpg",
            "background-preseason2022.jpg",
            "background-roster.jpg",
            "background-shadow_isles.jpg",
            "background-shurima.jpg",
            "background-toast.jpg",
            "background-void.jpg",
            "background-worlds2020.jpg",
            "background-worlds2021.jpg",
            "background-worlds2022.jpg",
            "background-zaun.jpg",
        )
    }

    lateinit var binding: ActivityMenuHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        onclick()

        val randomIndex = Random.nextInt(fondo.size);
        val randomElement = fondo[randomIndex]
        Glide.with(this)
            .load("https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/background/${randomElement}")
            .centerCrop()
            .into(binding.back)
    }

    private fun onclick() {
        binding.btnchamps.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.play.setOnClickListener {
            startActivity(Intent(this, PlayActivity::class.java))
        }
        setBackgroundGlide(binding.btnchamps)
        setBackgroundGlide(binding.runes)
    }

    private fun setBackgroundGlide(view: ImageView) {
        Glide.with(this)
            .load("https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/rewards-modal/champion-container.png")
            .into(view)
    }
}