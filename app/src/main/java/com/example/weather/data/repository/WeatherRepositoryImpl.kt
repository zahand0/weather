package com.example.weather.data.repository

import android.util.Log
import com.example.weather.data.mappers.toWeatherInfo
import com.example.weather.data.remote.WeatherApi
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.domain.util.Resource
import com.example.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    companion object {
        private const val TAG = "WeatherRepositoryImpl"
    }

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        Log.d(TAG, "getWeatherData: We're in")
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            Log.e(TAG, "error during loading data from api", e )
            Resource.Error(e.message ?:"An unknown error occurred.")
        }
    }
}