package com.example.kevinteasdaledube.tp1androidstudio.models;

import java.io.Serializable;

public class Book extends Media implements Serializable {

    private String author;
    private String summary;
    private String isbn;
    private String localization;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }


    public Book(String author, String summary, String isbn, String localization, String title){
        super(title);
        this.setAuthor( author );
        this.setSummary( summary );
        this.setIsbn( isbn );
        this.setLocalization( localization );
        setMediaType( Media.type.Book );

    }

}
