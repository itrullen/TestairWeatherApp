package com.irenetrullen.testairweather.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()

    val text: LiveData<String> = _text

    fun updateCityName(cityName: String){
        _text.value = cityName
    }

}