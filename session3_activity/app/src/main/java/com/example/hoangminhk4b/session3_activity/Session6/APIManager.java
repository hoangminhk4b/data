package com.example.hoangminhk4b.session3_activity.Session6;


import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String URL="http://tommyprivateguide.com";

    @GET("/data.json")
    Call<NewsItem> getNews();
}
