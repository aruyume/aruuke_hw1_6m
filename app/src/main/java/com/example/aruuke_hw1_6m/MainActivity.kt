package com.example.aruuke_hw1_6m

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.aruuke_hw1_6m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[CounterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupClickListeners()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.counterData.observe(this) { data ->
            binding.tvResult.text = data.toString()
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            btnInc.setOnClickListener {
                viewModel.onIncrement()
            }
            btnDec.setOnClickListener {
                viewModel.onDecrement()
            }
        }
    }
}