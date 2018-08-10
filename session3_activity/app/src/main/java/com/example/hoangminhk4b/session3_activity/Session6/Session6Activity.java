package com.example.hoangminhk4b.session3_activity.Session6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hoangminhk4b.session3_activity.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Session6Activity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvDate;
    ImageView ivCover;
    TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session6);

        tvTitle=findViewById(R.id.tvTitle);
        tvDate=findViewById(R.id.tvDate);
        ivCover=findViewById(R.id.ivCover);
        tvContent=findViewById(R.id.tvContent);
        getData();
    }
    private void getData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getNews().enqueue(new Callback<NewsItem>() {
            @Override
            public void onResponse(Call<NewsItem> call, Response<NewsItem> response) {
                if(response.body() == null) return;
                NewsItem model=(NewsItem) response.body();
                Log.d(Session6Activity.class.getSimpleName(),"Success");
                tvTitle.setText(model.getTitle());
                tvDate.setText(model.getDate());
                tvContent.setText(model.getContent());
                Glide.with(Session6Activity.this).load(model.getImage()).into(ivCover);

            }

            @Override
            public void onFailure(Call<NewsItem> call, Throwable t) {
                Toast.makeText(Session6Activity.this,"Co loi xay ra",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
