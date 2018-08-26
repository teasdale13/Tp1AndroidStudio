package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import com.example.kevinteasdaledube.tp1androidstudio.R;

public class Activity_Mp4 extends AppCompatActivity {

    String url;
    VideoView videoView;
    int stopPosition = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_mp4 );

        ImageView imageView = (ImageView) findViewById( R.id.imageViewType );
        imageView.setImageResource( R.drawable.mp4 );
        imageView.setMaxHeight( 400 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );

        Media monMedia = (Media) getIntent().getSerializableExtra( "info" );
        Mp4 monMp4 = (Mp4) monMedia;

        String title = monMp4.getTitle();
        url = monMp4.getUrl();

        final Button btnPlay = (Button) findViewById( R.id.buttonPlay );
        Button btnPause = (Button) findViewById( R.id.buttonPause );
        Button btnStop = (Button) findViewById( R.id.buttonStop );


        btnPlay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoView = (VideoView) findViewById( R.id.videoView );
                videoView.setVideoURI( Uri.parse( url ) );
                videoView.seekTo( stopPosition );
                videoView.start();
                btnPlay.setEnabled( false );

            }
        } );

        btnPause.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
                stopPosition = videoView.getCurrentPosition();
                btnPlay.setEnabled( true );
            }
        } );

        btnStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
                stopPosition = 0;
                btnPlay.setEnabled( true );
            }
        } );


    }

}
