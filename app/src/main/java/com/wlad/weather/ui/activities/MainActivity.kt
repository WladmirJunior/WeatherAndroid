package com.wlad.weather.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wlad.weather.databinding.ActivityMainBinding
import com.wlad.weather.presentation.ViewModelFactory
import com.wlad.weather.presentation.WeatherViewModel
import com.wlad.weather.presentation.model.WeatherModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory()
        ).get(WeatherViewModel::class.java)

        subscribeObservers()

        viewModel.getWeather("Belo Horizonte")
    }

    private fun subscribeObservers() {
        viewModel.weather.observe(this) {
            binding.cityText.text = it.cityName
            binding.tempText.text = "${it.temp} ºC"
            binding.weatherText.text = it.weather
        }
    }
}

