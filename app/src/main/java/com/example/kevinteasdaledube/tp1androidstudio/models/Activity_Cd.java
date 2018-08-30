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

        TextView textViewTitle = (TextView) findViewById( R.id.textViewTitleCd );
        TextView textViewArtist = (TextView) findViewById( R.id.textViewArtistCd );
        TextView textViewBarCode = (TextView) findViewById( R.id.textViewBarCodeCd);
        TextView textViewLoca = (TextView) findViewById( R.id.textViewLocaCd );

        //récupération des extras passés entre les activitées
        Media monMedia = (Media) getIntent().getSerializableExtra( "info");
        Cd monCd = (Cd) monMedia;

        //reglage visuel de l'image
        ImageView imageView = (ImageView) findViewById( R.id.imageViewCd);
        imageView.setImageResource( R.drawable.disk );
        imageView.setMaxHeight( 600 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );

        //assignation des String
        String title = monCd.getTitle();
        String artist = monCd.getArtist();
        String barCode = monCd.getBarCode();
        String localization = monCd.getLocalization();

        //assignation des String au textview
        textViewTitle.setText("Titre :  " + title );
        textViewArtist.setText("Artiste :  " + artist );
        textViewLoca.setText("Localisation :  " + localization );
        textViewBarCode.setText("Barcode :  " + barCode );




    }

}
