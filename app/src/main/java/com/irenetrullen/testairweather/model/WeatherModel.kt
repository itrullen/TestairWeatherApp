package com.irenetrullen.testairweather.model

import java.sql.Date
import java.sql.Timestamp

data class WeatherModel(
    val name: String,
    val weather: List<WeatherDescriptionModel>,
    val main: WeatherMainModel,
    val dt: Long
) {

    override fun toString(): String {
        return "${Date(Timestamp(dt*1000).time)} \n$name (${weather[0].description}) - ${main.temp} F"
    }
}
