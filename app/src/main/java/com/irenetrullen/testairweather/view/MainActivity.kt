package com.irenetrullen.testairweather.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.irenetrullen.testairweather.databinding.ActivityMainBinding
import com.irenetrullen.testairweather.model.WeatherModel
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
    }

    override fun loadCityWeather(cityWeatherInfo: WeatherModel) {
        binding.lblYourResponseHere.text = cityWeatherInfo.toString()
    }

    private fun setUpButtonListener() {

        binding.btnSearch.setOnClickListener {
            getWeather(binding.editTextSearch.text.toString())
        }
    }

}