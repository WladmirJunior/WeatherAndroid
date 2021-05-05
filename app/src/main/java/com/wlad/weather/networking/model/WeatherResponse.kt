package com.wlad.weather.networking.model

data class WeatherResponse (
    val weather: List<Weather>,
    val main: Main,
    val name: String,
)


data class Main (
    val temp: Double,
)

data class Weather (
    val main: String,
    val description: String,
)