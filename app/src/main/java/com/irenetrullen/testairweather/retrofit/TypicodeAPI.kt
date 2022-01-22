package com.irenetrullen.testairweather.retrofit

import com.irenetrullen.testairweather.model.WeatherModel
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface TypicodeAPI {

    //weather?q={cityname},LTU&appid=7587eaff3affbf8e56a81da4d6c51d06
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") appid: String = "7587eaff3affbf8e56a81da4d6c51d06"
    ): WeatherModel

    //http://openweathermap.org/img/wn/{icon_name}@2x.png
    @GET
    suspend fun getWeatherIcon(@Url url: String): ResponseBody
}