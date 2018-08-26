package com.example.kevinteasdaledube.tp1androidstudio.models;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlPullParserTool {

    private String title,author,summary,artist,isbn,localization,barcode,url;
    private final static String TAG_ARTIST = "artist";
    private final static String TAG_BARCODE = "barcode";
    private final static String TAG_URL = "url";
    private final static String TAG_TITLE = "title";
    private final static String TAG_AUTHOR = "author";
    private final static String TAG_SUMMARY = "summary";
    private final static String TAG_ISBN = "isbn";
    private final static String TAG_LOCATION = "localization";
    private final static String TAG_BOOK = "book";
    private final static String TAG_CD = "cd";
    private final static String TAG_DVD = "dvd";
    private final static String TAG_MP3 = "mp3";
    private final static String TAG_MP4 = "mp4";

    public List<Media> medias = new ArrayList<Media>(  );

    public List<Media> getMedias() {
        return medias;
    }

    public List<Media> getMediaFromFile(InputStream is) throws XmlPullParserException, IOException {


        String text = " ";

        XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp =   xmlFactory.newPullParser();
        xpp.setInput(is, "utf-8");
        int event = xpp.getEventType();

        while (event != XmlPullParser.END_DOCUMENT){
            String tagName = xpp.getName();

            switch (event){

                case XmlPullParser.TEXT:
                    text = xpp.getText().trim();
                    break;

                case XmlPullParser.END_TAG:
                     if (tagName.equalsIgnoreCase(TAG_TITLE)){
                        title = text;
                    }else if (tagName.equalsIgnoreCase(TAG_AUTHOR)){
                        author = text;
                    }else if (tagName.equalsIgnoreCase(TAG_SUMMARY)){
                        summary = text;
                    }else if (tagName.equalsIgnoreCase(TAG_ISBN)){
                        isbn = text;
                    }else if (tagName.equalsIgnoreCase(TAG_LOCATION)){
                        localization = text;
                    }else if (tagName.equalsIgnoreCase( TAG_ARTIST )){
                         artist = text;
                    }else if (tagName.equalsIgnoreCase( TAG_BARCODE )){
                         barcode = text;
                    }else if (tagName.equalsIgnoreCase( TAG_URL )){
                         url = text;
                    }else if (tagName.equalsIgnoreCase( TAG_BOOK )){
                         medias.add(new Book(author, summary, isbn, localization, title));
                    }else if (tagName.equalsIgnoreCase( TAG_CD )){
                         medias.add( new Cd( artist,barcode, localization,title));
                    }else if (tagName.equalsIgnoreCase( TAG_DVD )){
                         medias.add( new DVD(barcode, summary, localization, title) );
                    }else if (tagName.equalsIgnoreCase( TAG_MP3 )){
                         medias.add( new Mp3( title,artist,url ) );
                    }else if (tagName.equalsIgnoreCase( TAG_MP4 )){
                         medias.add( new Mp4( title,url));
                     }
                    break;
                default:
                    break;

            }
            event = xpp.next();
        }

        return medias;
    }

}
