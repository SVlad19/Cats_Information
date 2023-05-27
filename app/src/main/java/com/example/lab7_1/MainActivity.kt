package com.example.lab7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab7_1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder().
        baseUrl("https://catfact.ninja").
        addConverterFactory(GsonConverterFactory.create()).
        build()

        val catAPI = retrofit.create(CatAPI::class.java)

        binding.ivFirstCat.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                val cat = catAPI.getFact()
                runOnUiThread{
                    binding.tvFact.text = cat.fact
                }
            }
        }

        binding.ivSecondCat.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                val cat = catAPI.getFact()
                runOnUiThread{
                    binding.tvFact.text = cat.fact
                }
            }
        }


    }
}