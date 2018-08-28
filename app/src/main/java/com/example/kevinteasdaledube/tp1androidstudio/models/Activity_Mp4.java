package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import com.example.kevinteasdaledube.tp1androidstudio.R;

public class Activity_Mp4 extends AppCompatActivity implements Jouable {

    String url;
    VideoView videoView;
    int stopPosition = 0;
    Button btnPlay;
    Button btnStop;
    Button btnPause;

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

        btnPlay = (Button) findViewById( R.id.buttonPlay );
        btnPause = (Button) findViewById( R.id.buttonPause );
        btnStop = (Button) findViewById( R.id.buttonStop );


        btnPlay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Play();

            }
        } );

        btnPause.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pause();
            }
        } );

        btnStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stop();
            }
        } );
    }

    @Override
    public void Play() {
        videoView = (VideoView) findViewById( R.id.videoView );
        videoView.setVideoURI( Uri.parse( url ) );
        videoView.seekTo( stopPosition );
        videoView.start();
        btnPlay.setEnabled( false );
    }

    @Override
    public void Stop() {
        videoView.stopPlayback();
        stopPosition = 0;
        btnPlay.setEnabled( true );
    }

    @Override
    public void Pause() {
        videoView.pause();
        stopPosition = videoView.getCurrentPosition();
        btnPlay.setEnabled( true );
    }
}
