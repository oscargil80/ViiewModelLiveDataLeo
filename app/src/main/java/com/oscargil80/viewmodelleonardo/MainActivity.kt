package com.oscargil80.viewmodelleonardo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.oscargil80.viewmodelleonardo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val viewModel = MainViewModel()

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

        lifecycleScope.launchWhenStarted {
            viewModel.count.collect { Value ->
                binding.tvValor.text = Value.toString()
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.event.collect{
                if(it)     {
                    Toast.makeText(this@MainActivity, "Numero Invalido", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}