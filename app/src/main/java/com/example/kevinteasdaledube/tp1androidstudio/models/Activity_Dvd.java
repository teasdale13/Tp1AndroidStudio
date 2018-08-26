package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinteasdaledube.tp1androidstudio.R;

public class Activity_Dvd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_dvd );

        ImageView imageView = (ImageView) findViewById( R.id.imageViewDvd);
        imageView.setImageResource( R.drawable.dvd );
        imageView.setMaxHeight( 400 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );

        TextView textViewTitle = (TextView) findViewById( R.id.textViewTitleDvd );
        TextView textViewSummary = (TextView) findViewById( R.id.textViewSummaryDvd ) ;
        TextView textViewBarcode = (TextView) findViewById( R.id.textViewBarcodeDvd ) ;
        TextView textViewLoca = (TextView) findViewById( R.id.textViewLocaDvd );

        Media monMedia = (Media) getIntent().getSerializableExtra( "info");
        DVD monDvd = (DVD) monMedia;
        String title = monDvd.getTitle();
        String summary = monDvd.getSummary();
        String barCode = monDvd.getBarcode();
        String localization = monDvd.getLocalization();

        textViewBarcode.setText("Barcode:  " + barCode );
        textViewLoca.setText("Localisation:  " + localization );
        textViewSummary.setText( summary );
        textViewTitle.setText("Titre:  " + title );


    }
}
