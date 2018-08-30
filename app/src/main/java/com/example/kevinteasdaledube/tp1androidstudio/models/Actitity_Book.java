package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinteasdaledube.tp1androidstudio.R;



public class Actitity_Book extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_book );

        Media monMedia = (Media) getIntent().getSerializableExtra( "info");


            TextView viewTitle = (TextView) findViewById( R.id.textViewTitle1 );
            TextView viewAuthor = (TextView) findViewById( R.id.textViewAuthor );
            TextView viewSummary = (TextView) findViewById( R.id.textViewSummary );
            TextView viewIsbn = (TextView) findViewById( R.id.textViewIsbn );
            TextView viewLoca = (TextView) findViewById( R.id.textView );

            Book monBook = (Book) monMedia;

            ImageView imageView = (ImageView) findViewById( R.id.imageView1);
            imageView.setImageResource( R.drawable.book_png_image );
            imageView.setMaxHeight( 400 );
            imageView.setAdjustViewBounds( true );
            imageView.setVisibility( View.VISIBLE );

            String author = monBook.getAuthor();
            String isbn = monBook.getIsbn();
            String summary = monBook.getSummary();
            String localization = monBook.getLocalization();
            String title = monBook.getTitle();

            viewTitle.setText("Titre : " + title );
            viewAuthor.setText("Auteur : " + author );
            viewSummary.setText( summary );
            viewLoca.setText("Localisation : " + localization );
            viewIsbn.setText("ISBN : " + isbn );












    }

}
