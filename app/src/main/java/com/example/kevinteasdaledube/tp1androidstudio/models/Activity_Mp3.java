package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.media.AudioManager;
import android.media.MediaPlayer;
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
import android.widget.Toast;

import com.example.kevinteasdaledube.tp1androidstudio.R;

import java.io.IOException;



public class Activity_Mp3 extends AppCompatActivity implements Jouable {

    static String url;
    static ImageView imageView;
    int currentPosition;
    Button btnPause;
    Button btnStop;
    Button btnPlay;
    static boolean isPlaying = true;
    boolean firstTime = true;
    boolean onStop = false;
    static MediaPlayer mediaPlayer;
    static RotateAnimation anim;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_mp3 );
        imageView = (ImageView)findViewById( R.id.note );

        ImageView imageView = (ImageView) findViewById( R.id.imageViewMp3);
        imageView.setImageResource( R.drawable.mp3 );
        imageView.setMaxHeight( 400 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );
        TextView textViewTitle = (TextView) findViewById( R.id.textViewTitleMp3 );
        TextView textViewArtist = (TextView)findViewById( R.id.textViewArtistMp3 );

        //récupération des extras passé entre activitée
        Media monMedia = (Media) getIntent().getSerializableExtra( "info");
        Mp3 monMp3 = (Mp3) monMedia;
        String title = monMp3.getTitle();
        String artist = monMp3.getArtist();

        textViewTitle.setText("Titre : " + title);
        textViewArtist.setText("Artiste : " + artist );

        url = monMp3.getUrl();

        //boutons
        btnPause = (Button) findViewById( R.id.buttonPauseMp3 );
        btnPause.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pause();
            }
        } );

        btnStop = (Button) findViewById( R.id.buttonStopMp3 );
        btnStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stop();
            }
        } );

        btnPlay = (Button) findViewById( R.id.buttonPlay );
        btnPlay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Play();
            }
        } );
    }

    @Override
    public void Play() {
        if (firstTime){
            mediaPlayer = new MediaPlayer();
            Mp3Player mp3Player = new Mp3Player();
            mp3Player.execute();
            firstTime = false;
        }

        if (!isPlaying ) {
            mediaPlayer.seekTo( currentPosition );
            mediaPlayer.start();
            isPlaying = true;

        }
        btnPlay.setEnabled( false );
        btnPause.setEnabled( true );

    }

    @Override
    public void Stop() {
        mediaPlayer.stop();
        mediaPlayer.release();
        btnPlay.setEnabled( true );
        firstTime = true;
    }

    @Override
    public void Pause() {
        if (isPlaying) {
            mediaPlayer.pause();
            currentPosition = mediaPlayer.getCurrentPosition();
            btnPlay.setEnabled( true );
            btnPause.setEnabled( false );
            isPlaying = false;
            onStop = true;
        }
    }

    private static class Mp3Player extends AsyncTask<Void,Void,Void>{

        private Mp3Player(){

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                mediaPlayer.setAudioStreamType( AudioManager.STREAM_MUSIC );
                mediaPlayer.setDataSource( url );
                mediaPlayer.prepare();
                int count = 0;
                anim = new RotateAnimation(0f, 360f,Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                while (count < 8){
                    anim.setInterpolator(new LinearInterpolator());
                    anim.setRepeatCount( Animation.INFINITE);
                    anim.setDuration(925);
                    imageView.startAnimation(anim);
                    count++;
                    Thread.sleep( 900 );
                }
                anim.cancel();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;

        }

    }

}