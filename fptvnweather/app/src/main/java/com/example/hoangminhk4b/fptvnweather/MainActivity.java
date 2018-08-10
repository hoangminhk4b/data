package com.example.hoangminhk4b.fptvnweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.hoangminhk4b.fptvnweather.api.APIManager;
import com.example.hoangminhk4b.fptvnweather.model.weatherHour;
import com.example.hoangminhk4b.fptvnweather.weather.weatherHourAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvLocation;
    TextView tvStatus;
    TextView tvTemperature;
    List<weatherHour> listDataHour;
    RecyclerView rvViewHour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rvViewHour=findViewById(R.id.rvWeatherHour);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        rvViewHour.setLayoutManager(linearLayoutManager);





    }
    private void init(){
        tvLocation=findViewById(R.id.tvLocation);
        tvStatus=findViewById(R.id.tvStatus);
        tvTemperature=findViewById(R.id.tvTemperature);
        getDataHour();
    }
    private void getDataHour(){
        Retrofit retrofit=new  Retrofit.Builder().baseUrl(APIManager.URL).addConverterFactory(GsonConverterFactory.create()).build();

        APIManager service=retrofit.create(APIManager.class);
        service.getDataHour().enqueue(new Callback<List<weatherHour>>() {
            @Override
            public void onResponse(Call<List<weatherHour>> call, Response<List<weatherHour>> response) {
                if(response.body() ==null) return;
                listDataHour=response.body();
                weatherHourAdapter weatherAdapter=new weatherHourAdapter(MainActivity.this,listDataHour);
                rvViewHour.setAdapter(weatherAdapter);
                weatherHour current=listDataHour.get(0);
                tvStatus.setText(current.getIconPhrase());
                tvTemperature.setText(current.getTemperature().getValue()+"");
            }

            @Override
            public void onFailure(Call<List<weatherHour>> call, Throwable t) {

            }
        });

    }
}
