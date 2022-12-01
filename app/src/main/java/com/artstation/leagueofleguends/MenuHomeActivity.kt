package com.artstation.leagueofleguends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artstation.leagueofleguends.databinding.ActivityMenuHomeBinding

class MenuHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        onclick()
    }
    private fun onclick() {
        binding.btnchamps.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}