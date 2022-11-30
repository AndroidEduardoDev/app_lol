package com.artstation.leagueofleguends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView.OnQueryTextListener
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
    val dataChamp = ArrayList<Champion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        getChampions()
        binding.search.setOnQueryTextListener(object : OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(name: String): Boolean {
                if (!name.isNullOrEmpty()) {
                    val data = ArrayList<Champion>()
                    name?.let { names ->
                        dataChamp.map {
                            if (it.name.lowercase()
                                    .contains(names.lowercase()) && !data.contains(it)
                            )
                                data.add(it)
                        }
                        val adapter = ChampionAdapter(data)
                        binding.recyclerChampion.adapter = adapter

                    }
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                return false
            }

        })
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ddragon.leagueoflegends.com/")
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
                            champion.value.name,
                            champion.value
                        )
                    )
                    dataChamp.addAll(data)
                }
                runOnUiThread {
                    val adapter = ChampionAdapter(data)
                    binding.recyclerChampion.adapter = adapter
                }

            }

        }
    }

}


