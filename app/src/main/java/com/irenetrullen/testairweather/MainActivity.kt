package com.irenetrullen.testairweather

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.irenetrullen.testairweather.databinding.ActivityMainBinding
import com.irenetrullen.testairweather.model.WeatherModel
import com.irenetrullen.testairweather.view.WeatherView
import com.irenetrullen.testairweather.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity(), WeatherView {

    private lateinit var binding: ActivityMainBinding
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setUpViewModel()
        setUpButtonListener()

    }

    private fun getWeather(city: String) {
        weatherViewModel.getWeather(city)
    }

    private fun setUpViewModel() {
        weatherViewModel.weatherModel.observe(this, { cityWeatherInfo ->
            loadCityWeather(cityWeatherInfo)
        })

        weatherViewModel.weatherIcon.observe(this, { weatherIcon ->
            loadWeatherIcon(weatherIcon)
        })
    }

    override fun loadCityWeather(cityWeatherInfo: WeatherModel) {
        //request for weather icon
        weatherViewModel.getWeatherIcon(cityWeatherInfo.weather[0].icon)
        //show weather info
        binding.lblYourResponseHere.text = cityWeatherInfo.toString()

    }

    override fun loadWeatherIcon(weatherIcon: Bitmap) {
        binding.imageViewWeatherIcon.setImageBitmap(weatherIcon)
    }

    private fun setUpButtonListener() {

        binding.btnSearch.setOnClickListener {
            getWeather(binding.editTextSearch.text.toString())
        }
    }

}