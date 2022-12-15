package com.artstation.leagueofleguends

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.artstation.leagueofleguends.databinding.ActivityAbilityChampionBinding


class AbilityChampionActivity : AppCompatActivity() {
    lateinit var binding: ActivityAbilityChampionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbilityChampionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}