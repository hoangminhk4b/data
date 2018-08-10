package com.example.hoangminhk4b.fptvnweather.weather;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hoangminhk4b.fptvnweather.R;
import com.example.hoangminhk4b.fptvnweather.model.weatherHour;
import com.example.hoangminhk4b.fptvnweather.utils.coverTimeApp;

import java.util.List;

public class weatherHourAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<weatherHour> listDataHour;
    private coverTimeApp coverTimeApp;

    public weatherHourAdapter(Activity activity, List<weatherHour> listDataHour) {
        this.activity = activity;
        this.listDataHour = listDataHour;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.item_weather_hour,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vHolder=(ViewHolder) holder;
        weatherHour weatherHour=listDataHour.get(position);
        vHolder.tvHour.setText(coverTimeApp.convertTimeHour(weatherHour.getDateTime()));
        vHolder.tvTemperature.setText(weatherHour.getTemperature().getValue()+"");
        String url=String.format("http://developer.accuweather.com/sites/default/files/%02d-s.png",weatherHour.getWeatherIcon());
        Glide.with(activity).load(url).into(vHolder.ivWeatherIcon);
    }

    @Override
    public int getItemCount() {
        return listDataHour.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvHour;
        ImageView ivWeatherIcon;
        TextView tvTemperature;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHour=itemView.findViewById(R.id.tvHour);
            ivWeatherIcon=itemView.findViewById(R.id.ivWeatherIcon);
            tvTemperature=itemView.findViewById(R.id.tvTemperature);
        }
    }
}
