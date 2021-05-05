package com.wlad.weather.networking.api

import com.wlad.weather.networking.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather?appid=$APP_KEY&units=metric&lang=pt_br")
    suspend fun retrieveWeather(@Query("q") city: String): WeatherResponse

    companion object {
        const val APP_KEY = "fa3c2cd288dda1f3c55f38aef75c1f0c"
    }
}