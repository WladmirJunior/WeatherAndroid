package com.wlad.weather.presentation.model

import com.wlad.weather.networking.model.Weather
import com.wlad.weather.networking.model.WeatherResponse

fun WeatherResponse.toPresentation() = WeatherModel(
    cityName = name,
    temp = main.temp.toString(),
    weather = weather.first().description
)