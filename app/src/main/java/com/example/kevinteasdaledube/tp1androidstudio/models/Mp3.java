package com.example.kevinteasdaledube.tp1androidstudio.models;

import java.io.Serializable;

public class Mp3 extends Media implements Serializable {

    private String artist;
    private String url;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Mp3(String title, String artist, String url) {
        super( title);
        this.setArtist( artist );
        this.setUrl( url );
        setMediaType( Media.type.MP3 );
    }
}
