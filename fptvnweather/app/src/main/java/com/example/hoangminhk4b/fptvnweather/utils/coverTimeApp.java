package com.example.hoangminhk4b.fptvnweather.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class coverTimeApp {
    public coverTimeApp() {
    }

    public String convertTimeHour(String input) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }
    private String convertTimeDay(String input){
        SimpleDateFormat inFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date=null;
        try{
            date=inFormat.parse(input);
        }catch (ParseException e){
            e.printStackTrace();
        }
        SimpleDateFormat outFormat=new SimpleDateFormat("EEE");
        String goal=outFormat.format(date);
        return goal;
    }
}
