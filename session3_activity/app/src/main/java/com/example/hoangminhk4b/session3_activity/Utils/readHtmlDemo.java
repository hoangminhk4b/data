package com.example.hoangminhk4b.session3_activity.Utils;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class readHtmlDemo extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
        Connection connection= Jsoup.connect(strings[0]);
        connection.maxBodySize(0);
        try {
            Document document= connection.get();
            Log.d("URL",document.toString());
            publishProgress(document.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
