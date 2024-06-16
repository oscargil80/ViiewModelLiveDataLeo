package com.oscargil80.viewmodelleonardo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.oscargil80.viewmodelleonardo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    private  var  viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         viewModel = ViewModelProvider(this@MainActivity).get(viewModel::class.java)
        binding.tvValor.text = viewModel.getinitialCounter().toString()
        binding.btnCounter.setOnClickListener {
          binding.tvValor.text = viewModel.getUpdateCounter().toString()
        }

    }
}