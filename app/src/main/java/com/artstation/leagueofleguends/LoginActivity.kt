package com.artstation.leagueofleguends

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.artstation.leagueofleguends.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        onclick()
    }

    private fun onclick() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MenuHomeActivity::class.java))
            finish()
        }
    }

}