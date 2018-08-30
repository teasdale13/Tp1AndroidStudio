package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.example.kevinteasdaledube.tp1androidstudio.R;

public class Activity_Mp4 extends AppCompatActivity implements Jouable {

    String url;
    VideoView videoView;
    int stopPosition;
    Button btnPlay;
    Button btnStop;
    Button btnPause;
    TextView textViewTitle;
    boolean firstime = true;
    boolean onPause = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_mp4 );

        //propriétés de l'image
        ImageView imageView = (ImageView) findViewById( R.id.imageViewType );
        imageView.setImageResource( R.drawable.mp4 );
        imageView.setMaxHeight( 400 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );

        Media monMedia = (Media) getIntent().getSerializableExtra( "info" );
        Mp4 monMp4 = (Mp4) monMedia;

        String title = monMp4.getTitle();
        url = monMp4.getUrl();

        //Widgets
        textViewTitle = (TextView)findViewById( R.id.textViewTitleMp4 );
        textViewTitle.setText("Titre : " + title );
        textViewTitle.setVisibility( View.VISIBLE );
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
        if (firstime) {
            videoView = (VideoView) findViewById( R.id.videoView );
            videoView.setVideoURI( Uri.parse( url ) );
            videoView.start();
            btnPlay.setEnabled( false );
            firstime = false;
        }if (onPause){
            videoView.seekTo( stopPosition );
            videoView.start();
            onPause = false;
            btnPlay.setEnabled( false );
        }
    }

    @Override
    public void Stop() {
        videoView.stopPlayback();
        btnPlay.setEnabled( true );
        firstime = true;
        btnPause.setEnabled( true );
    }

    @Override
    public void Pause() {
        videoView.pause();
        stopPosition = videoView.getCurrentPosition();
        btnPlay.setEnabled( true );
        onPause = true;
    }
}
