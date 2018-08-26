package com.example.kevinteasdaledube.tp1androidstudio.models;

import java.io.Serializable;

public class Mp4 extends Media implements Serializable {


    private String url;
    private type type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Mp4(String title, String url){
        super(title);
        this.setUrl( url );
        setMediaType( Media.type.MP4 );

    }
}
