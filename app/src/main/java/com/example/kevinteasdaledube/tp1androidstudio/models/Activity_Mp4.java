package com.example.kevinteasdaledube.tp1androidstudio.models;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.example.kevinteasdaledube.tp1androidstudio.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

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
    static Animation anim;
    static Animation anim2;
    static ImageView imageViewBobine1;
    static ImageView imageViewBobine2;
    static ImageView imageViewProjecteur;
    AnimationMp4 animationMp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_mp4 );

        //propriétés de l'image
        final ImageView imageView = (ImageView) findViewById( R.id.imageViewType );
        imageView.setImageResource( R.drawable.mp4 );
        imageView.setMaxHeight( 400 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );

        imageViewProjecteur = (ImageView) findViewById(R.id.imageViewProjecteur);
        imageViewProjecteur.setImageResource( R.drawable.projector );
        imageViewProjecteur.setVisibility( View.INVISIBLE );
        imageViewProjecteur.setMaxHeight( 1000 );
        imageViewProjecteur.setAdjustViewBounds( true );


        imageViewBobine1 = (ImageView)findViewById( R.id.imageViewBobine1 ) ;
        imageViewBobine1.setImageResource( R.drawable.film );
        imageViewBobine1.setMaxHeight( 300 );
        imageViewBobine1.setAdjustViewBounds( true );
        imageViewBobine1.setVisibility( View.INVISIBLE );

        imageViewBobine2 = (ImageView)findViewById( R.id.imageViewBobine2 ) ;
        imageViewBobine2.setImageResource( R.drawable.film );
        imageViewBobine2.setMaxHeight( 250 );
        imageViewBobine2.setAdjustViewBounds( true );
        imageViewBobine2.setVisibility( View.INVISIBLE );

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
            animationMp4 = new AnimationMp4();
            animationMp4.execute(  );
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


        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START :
                        anim.cancel();
                        anim2.cancel();
                        imageViewProjecteur.setVisibility( View.INVISIBLE );
                        animationMp4.cancel(true);
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START :
                        animationMp4 = new AnimationMp4();
                        animationMp4.execute(  );
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END :
                        anim.cancel();
                        anim2.cancel();
                        imageViewProjecteur.setVisibility( View.INVISIBLE );
                        animationMp4.cancel( true );
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void Stop() {
        videoView.stopPlayback();
        btnPlay.setEnabled( true );
        firstime = true;
        btnPause.setEnabled( true );
        anim.cancel();
        anim2.cancel();
        imageViewProjecteur.setVisibility( View.INVISIBLE );
        animationMp4.cancel(true);
    }

    @Override
    public void Pause() {
        videoView.pause();
        stopPosition = videoView.getCurrentPosition();
        btnPlay.setEnabled( true );
        onPause = true;
    }

    public static class AnimationMp4 extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imageViewBobine1.setVisibility( View.VISIBLE );
            imageViewBobine2.setVisibility( View.VISIBLE );
            imageViewProjecteur.setVisibility( View.VISIBLE );
        }

        @Override
        protected Void doInBackground(Void... voids) {

            anim = new RotateAnimation(0f, 360f, RELATIVE_TO_SELF, 0.5f,
                    RELATIVE_TO_SELF, 0.5f);
            anim.setInterpolator(new LinearInterpolator());
            anim.setRepeatCount( Animation.INFINITE);
            anim.setDuration(925);
            imageViewBobine1.startAnimation(anim);
            imageViewBobine1.setVisibility( View.INVISIBLE );
            anim2 = new RotateAnimation(0f, 360f, RELATIVE_TO_SELF, 0.5f,
                    RELATIVE_TO_SELF, 0.5f);
            anim2.setInterpolator(new LinearInterpolator());
            anim2.setRepeatCount( Animation.INFINITE);
            anim2.setDuration(800);
            imageViewBobine2.startAnimation(anim2);

            imageViewBobine2.setVisibility( View.INVISIBLE );


            return null;
        }

    }
}
