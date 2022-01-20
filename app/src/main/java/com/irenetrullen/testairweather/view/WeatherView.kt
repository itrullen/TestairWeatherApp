package com.irenetrullen.testairweather.view

import com.irenetrullen.testairweather.model.WeatherModel

interface WeatherView {
    fun loadCityWeather(cityWeatherInfo: WeatherModel)
}