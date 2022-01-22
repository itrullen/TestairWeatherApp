package com.irenetrullen.testairweather.view

import android.graphics.Bitmap
import com.irenetrullen.testairweather.model.WeatherModel

interface WeatherView {
    fun loadCityWeather(cityWeatherInfo: WeatherModel)
    fun loadWeatherIcon(weatherIcon : Bitmap)
}