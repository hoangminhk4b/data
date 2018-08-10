package com.example.hoangminhk4b.appnhac.app.Utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ListMusicJsoup {
    private String url;
    private Connection con;
    private Document doc;

    public ListMusicJsoup(String url){
        this.url=url;
    }

    public Document getDocumentHTML() throws IOException {
        con= Jsoup.connect(url);
        return con.get();
    }

}
