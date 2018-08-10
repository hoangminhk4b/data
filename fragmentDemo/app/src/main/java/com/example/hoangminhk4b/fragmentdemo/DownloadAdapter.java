package com.example.hoangminhk4b.fragmentdemo;

import android.app.Activity;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> data;
    Handler handler=new Handler();
    public DownloadAdapter(Activity activity, List<String> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=activity.getLayoutInflater();
        view=inflater.inflate(R.layout.item_listview,viewGroup,false);
        final Button btnDownload=view.findViewById(R.id.btndownload);
        final ProgressBar progressBar=view.findViewById(R.id.process);
        final RelativeLayout vlProgress=view.findViewById(R.id.rlProgress);
        final TextView tvValueProgress=view.findViewById(R.id.tvValueProgress);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add("http://mp3.zing.vn");
                btnDownload.setVisibility(View.INVISIBLE);
                vlProgress.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        downloadFile(data.get(i),progressBar,btnDownload,vlProgress,tvValueProgress);
                    }
                }).start();

            }
        });

        return view;
    }
    public void downloadFile(String url, ProgressBar progressBar, final Button button, final RelativeLayout rl, final TextView tv){
        OkHttpClient client=new OkHttpClient();
        Request request= new Request.Builder().url(url).build();
        Response response=null;
        float file_size=0;

        try {
            response=client.newCall(request).execute();
            file_size= response.body().contentLength();

            BufferedInputStream bufferedInputStream=new BufferedInputStream(response.body().byteStream());
            FileOutputStream fileOutputStream=new FileOutputStream(Environment.getExternalStorageDirectory()+"/Download/abc.mp3");

            byte[] data= new byte[8192];
            float total=0;
            int readByte=0;

            while ( (readByte = bufferedInputStream.read(data)) != -1 ){
                total = total + readByte;
                fileOutputStream.write( data, 0, readByte);
                final int runProgress=(int) ((total / file_size)*100);
                progressBar.setProgress(runProgress);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(runProgress+"");
                    }
                });

            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    rl.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.VISIBLE);
                }
            });

            fileOutputStream.flush();
            fileOutputStream.close();
            response.body().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
