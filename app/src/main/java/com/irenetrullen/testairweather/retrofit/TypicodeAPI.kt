package com.irenetrullen.testairweather.retrofit

import com.irenetrullen.testairweather.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface TypicodeAPI {

    //weather?q={cityname},LTU&appid=7587eaff3affbf8e56a81da4d6c51d06
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") appid: String = "7587eaff3affbf8e56a81da4d6c51d06"
    )
            : WeatherModel?
}