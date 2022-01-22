package com.irenetrullen.testairweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irenetrullen.testairweather.retrofit.DataNetwork
import com.irenetrullen.testairweather.model.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val weatherModel = MutableLiveData<WeatherModel>()

    fun getWeather(city : String) {
        viewModelScope.launch {
            weatherModel.value = DataNetwork.retrofit.getWeather(city)
        }
        //TODO: Exception Handling
    }
}