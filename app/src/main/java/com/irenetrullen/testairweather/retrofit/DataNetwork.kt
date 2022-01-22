package com.irenetrullen.testairweather.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataNetwork {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TypicodeAPI::class.java)
    }
}