package com.wlad.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wlad.weather.data.repositories.WeatherRepository
import com.wlad.weather.presentation.model.WeatherModel
import com.wlad.weather.presentation.model.toPresentation
import kotlinx.coroutines.launch

class WeatherViewModel(): ViewModel() {

    private val repository = WeatherRepository()

    private val _weather = MutableLiveData<WeatherModel>()

    val weather: LiveData<WeatherModel> get() = _weather

    fun getWeather(city: String) {
        viewModelScope.launch {
            val result = repository.getWeather(city)
            _weather.postValue(result.toPresentation())
        }
    }
}