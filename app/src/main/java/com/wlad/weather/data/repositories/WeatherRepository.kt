package com.wlad.weather.data.repositories

import com.wlad.weather.networking.api.WeatherApi
import com.wlad.weather.networking.createWebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository {

    private val service = createWebService<WeatherApi>()

    suspend fun getWeather(city: String) = withContext(Dispatchers.IO) {
        service.retrieveWeather(city)
    }
}