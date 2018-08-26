package com.example.kevinteasdaledube.tp1androidstudio.models;

import java.io.Serializable;

public class Cd extends Media implements Serializable{


    private String artist;
    private String barCode;
    private String localization;


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public Cd(String artist, String barCode, String localization, String title){
        super(title);
        this.setArtist( artist );
        this.setBarCode( barCode );
        this.setLocalization( localization );
        setMediaType( Media.type.CD );
    }

}
