package com.example.kevinteasdaledube.tp1androidstudio.models;

import java.io.Serializable;

public class DVD extends Media implements Serializable {


    private String barcode;
    private String summary;
    private String localization;



    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public DVD(String barcode, String summary, String localization, String title){
        super(title);
        this.setBarcode( barcode );
        this.setSummary( summary );
        this.setLocalization( localization );
        setMediaType( Media.type.DVD );


    }
}
