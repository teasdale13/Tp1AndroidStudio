package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinteasdaledube.tp1androidstudio.R;

public class Activity_Cd extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_cd );

        TextView textViewTitle = (TextView) findViewById( R.id.textViewTitle1 );
        TextView textViewArtist = (TextView) findViewById( R.id.textViewArtist1 );
        TextView textViewBarCode = (TextView) findViewById( R.id.textViewBarCode1 );
        TextView textViewLoca = (TextView) findViewById( R.id.textViewLoca1 );

        Media monMedia = (Media) getIntent().getSerializableExtra( "info");

            Cd monCd = (Cd) monMedia;

        ImageView imageView = (ImageView) findViewById( R.id.imageViewCd);
        imageView.setImageResource( R.drawable.disk );
        imageView.setMaxHeight( 400 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );

        String title = monCd.getTitle();
        String artist = monCd.getArtist();
        String barCode = monCd.getBarCode();
        String localization = monCd.getLocalization();

        textViewTitle.setText("Titre:  " + title );
        textViewArtist.setText("Artiste:  " + artist );
        textViewLoca.setText("Localisation:  " + localization );
        textViewBarCode.setText("Barcode:  " + barCode );




    }

}
