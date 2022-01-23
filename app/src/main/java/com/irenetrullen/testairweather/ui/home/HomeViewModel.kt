package com.irenetrullen.testairweather.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irenetrullen.testairweather.model.WeatherModel
import com.irenetrullen.testairweather.retrofit.DataNetwork
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class HomeViewModel : ViewModel() {

    val weatherModel = MutableLiveData<WeatherModel>()
    val weatherIcon = MutableLiveData<Bitmap>()

    fun getWeather(city: String) {
        viewModelScope.launch {
            weatherModel.value = DataNetwork.retrofit.getWeather(city)
        }
        //TODO: Exception Handling
    }

    fun getWeatherIcon(iconName: String) {
        viewModelScope.launch {
            val body: ResponseBody =
                DataNetwork.retrofit.getWeatherIcon("http://openweathermap.org/img/wn/${iconName}@2x.png")
            val bytes = body.bytes()
            weatherIcon.value = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        }
        //TODO: Exception Handling
    }


}