package com.artstation.leagueofleguends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.artstation.leagueofleguends.adapter.ChampionAdapter
import com.artstation.leagueofleguends.data.Champion
import com.artstation.leagueofleguends.data.ChampionApi
import com.artstation.leagueofleguends.databinding.ActivityHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        getChampions()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ddragon.leagueoflegends.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getChampions() {
        binding.recyclerChampion.layoutManager = GridLayoutManager(this, 2)
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ChampionApi::class.java)
                .getChampions("cdn/12.22.1/data/es_ES/champion.json")
            if (call != null) {
                val data = ArrayList<Champion>()
                call.body()?.data?.map { champion ->
                    data.add(
                        Champion(
                            "http://ddragon.leagueoflegends.com/cdn/12.22.1/img/champion/" + champion.value.image.full,
                            champion.value.name
                        )
                    )
                }
                runOnUiThread {
                    val adapter = ChampionAdapter(data)

                    binding.recyclerChampion.adapter = adapter
                }

            }

        }
    }
}


