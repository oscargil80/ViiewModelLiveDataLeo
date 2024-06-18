package com.oscargil80.viewmodelleonardo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.oscargil80.viewmodelleonardo.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInc.setOnClickListener { viewModel.incrementarValor() }

        binding.btnDec.setOnClickListener { viewModel.decrementarValor() }

        binding.btnStart.setOnClickListener { viewModel.displayStartCount() }

        lifecycleScope.launchWhenStarted {
            viewModel.maxProgres.collect {
                binding.circularProgressIndicator.max = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.StartCount.collect{
                Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.isRunnig.collect { isRunning ->
                if (isRunning) {
                    binding.btnInc.isEnabled = false
                    binding.btnDec.isEnabled = false
                    binding.btnStart.isEnabled = false
                } else {
                    binding.btnInc.isEnabled = true
                    binding.btnDec.isEnabled = true


                    binding.circularProgressIndicator.max = 100
                    binding.circularProgressIndicator.progress = 100
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.time.collect { timeValue ->
                binding.tvValor.text = timeValue.toString()

                if(timeValue == 0){
                    viewModel.restartTimer()
                }

                if(!viewModel.isRunnig.value){
                    binding.btnStart.isEnabled = timeValue >0
                }else{
                    binding.circularProgressIndicator.progress = timeValue
                }

            }
        }


    }
}