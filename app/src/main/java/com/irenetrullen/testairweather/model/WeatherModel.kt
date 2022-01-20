package com.irenetrullen.testairweather.model

data class WeatherModel(val name: String,
                        val username: String,
                        val phone: String){
    override fun toString(): String {
        return "$name ($username) - $phone"
    }
}