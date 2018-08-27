package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinteasdaledube.tp1androidstudio.R;

import java.io.IOException;

public class Activity_Mp3 extends AppCompatActivity {

    String url;
    ProgressBar progressBar;
    int currentPosition;
    Button btnPause;
    Button btnStop;
    Button btnPlay;
    MediaPlayer mediaPlayer;
    boolean isPlaying = true;
    boolean fisrtTime = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_mp3 );
        progressBar = (ProgressBar)findViewById( R.id.progressBar ) ;
        progressBar.setVisibility( View.INVISIBLE );




        ImageView imageView = (ImageView) findViewById( R.id.imageViewMp3);
        imageView.setImageResource( R.drawable.mp3 );
        imageView.setMaxHeight( 400 );
        imageView.setAdjustViewBounds( true );
        imageView.setVisibility( View.VISIBLE );
        TextView textViewTitle = (TextView) findViewById( R.id.textViewTitleMp3 );
        TextView textViewArtist = (TextView)findViewById( R.id.textViewArtistMp3 );
        Media monMedia = (Media) getIntent().getSerializableExtra( "info");

        Mp3 monMp3 = (Mp3) monMedia;
        String title = monMp3.getTitle();
        String artist = monMp3.getArtist();

        textViewTitle.setText("Titre: " + title);
        textViewArtist.setText("Artiste: " + artist );




        url = monMp3.getUrl().trim();
        mediaPlayer = new MediaPlayer();

        btnPause = (Button) findViewById( R.id.buttonPauseMp3 );
        btnPause.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    mediaPlayer.pause();
                    currentPosition = mediaPlayer.getCurrentPosition();
                    btnPlay.setEnabled( true );
                    btnPause.setEnabled( false );
                    isPlaying = false;
                }

            }
        } );

        btnStop = (Button) findViewById( R.id.buttonStopMp3 );
        btnStop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mediaPlayer.stop();
                    currentPosition = 0;
                    fisrtTime = true;
                    btnPlay.setEnabled( true );
            }
        } );


        btnPlay = (Button) findViewById( R.id.buttonPlay );
        btnPlay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fisrtTime){
                    Mp3Player mp3Player = new Mp3Player();
                    mp3Player.execute( );
                    fisrtTime = false;
                }

                if (!isPlaying) {
                    mediaPlayer.seekTo( currentPosition );
                    mediaPlayer.start();
                }
                btnPause.setEnabled( true );
                btnPlay.setEnabled( false );
            }
        } );


    }


    private class Mp3Player extends AsyncTask<Void,Void,Void>{

        private Mp3Player(){

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast toast = Toast.makeText( Activity_Mp3.this, "Téléchargement en cours", Toast.LENGTH_LONG );
            toast.show();
            progressBar.setMax( 10 );
            progressBar.setVisibility( View.VISIBLE );
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                mediaPlayer.setAudioStreamType( AudioManager.STREAM_MUSIC );
                mediaPlayer.setDataSource( url );
                mediaPlayer.prepare();
                int count = 0;
                while (count < 11){
                    progressBar.setProgress( count );
                    Thread.sleep( 500 );
                    count++;
                }
                progressBar.setVisibility( View.INVISIBLE );
                mediaPlayer.start();



            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

    }
}