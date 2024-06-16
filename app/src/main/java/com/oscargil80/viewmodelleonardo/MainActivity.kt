package com.oscargil80.viewmodelleonardo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.oscargil80.viewmodelleonardo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    private  val viewModel  = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      binding.btnInc.setOnClickListener {
          viewModel.incrementarValor()
      }


        binding.btnDec.setOnClickListener {
            viewModel.decrementarValor()
        }

        viewModel.count.observe(this){ countValue ->
            binding.tvValor.text = countValue.toString()
        }


    }
}