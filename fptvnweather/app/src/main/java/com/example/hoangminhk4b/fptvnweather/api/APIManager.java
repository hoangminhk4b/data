package com.example.hoangminhk4b.fptvnweather.api;

import com.example.hoangminhk4b.fptvnweather.model.weatherHour;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String URL="http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=EGm3gEX6VL2fdddzVMvvfR3QtOSrVFeY&language=vi-vn&metric=true")
    Call <List<weatherHour>> getDataHour();

    @GET("forecasts/v1/daily/5day/353412?apikey=EGm3gEX6VL2fdddzVMvvfR3QtOSrVFeY&language=vi-vn&metric=true")
    Call <List<weatherHour>> getDataDay();
}
