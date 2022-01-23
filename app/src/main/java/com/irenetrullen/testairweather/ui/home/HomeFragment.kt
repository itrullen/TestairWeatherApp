package com.irenetrullen.testairweather.ui.home

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.irenetrullen.testairweather.databinding.FragmentHomeBinding
import com.irenetrullen.testairweather.model.WeatherModel
import com.irenetrullen.testairweather.view.WeatherView

class HomeFragment : Fragment(), WeatherView {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUpViewModel()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpButtonListener()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun getWeather(city: String) {
        homeViewModel.getWeather(city)
    }

    private fun setUpViewModel() {
        homeViewModel.weatherModel.observe(viewLifecycleOwner, { cityWeatherInfo ->
            loadCityWeather(cityWeatherInfo)
        })

        homeViewModel.weatherIcon.observe(viewLifecycleOwner, { weatherIcon ->
            loadWeatherIcon(weatherIcon)
        })
    }

    private fun setUpButtonListener() {

        binding.btnSearch.setOnClickListener {
            getWeather(binding.editTextSearch.text.toString())
        }
    }

    override fun loadCityWeather(cityWeatherInfo: WeatherModel) {
        //request for weather icon
        homeViewModel.getWeatherIcon(cityWeatherInfo.weather[0].icon)
        //show weather info
        binding.lblYourResponseHere.text = cityWeatherInfo.toString()
    }

    override fun loadWeatherIcon(weatherIcon: Bitmap) {
        binding.imageViewWeatherIcon.setImageBitmap(weatherIcon)
    }
}