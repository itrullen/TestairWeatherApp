package com.irenetrullen.testairweather.retrofit

import com.irenetrullen.testairweather.model.WeatherModel
import retrofit2.http.GET

interface TypicodeAPI {

    @GET("?q=Barcelona,LTU&appid=7587eaff3affbf8e56a81da4d6c51d06")
    suspend fun getWeather(city : String): WeatherModel
}