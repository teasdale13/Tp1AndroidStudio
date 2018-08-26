package com.example.kevinteasdaledube.tp1androidstudio;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.kevinteasdaledube.tp1androidstudio.models.Adapter;
import com.example.kevinteasdaledube.tp1androidstudio.models.Media;
import com.example.kevinteasdaledube.tp1androidstudio.models.XmlPullParserTool;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Media> medias = new ArrayList<Media>();
    String xmlFileUrl = "http://www.guroot.com/data.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        View view = (View) findViewById( R.id.main_view );
        Button btnPortail = (Button) findViewById( R.id.btnPortail );
        btnPortail.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundAsyncTask backgroundAsyncTask = new BackgroundAsyncTask();
                backgroundAsyncTask.execute(  );
            }
        } );



    }

    private class BackgroundAsyncTask extends AsyncTask<Void, Void, List<Media>> {

        URL url;

        public BackgroundAsyncTask() {

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected List<Media> doInBackground(Void... urls) {
            try {
                InputStream is;
                is = new URL( xmlFileUrl ).openStream();
                XmlPullParserTool parser = new XmlPullParserTool();
                medias.addAll( parser.getMediaFromFile( is ) );

            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return medias;
        }

        @Override
        protected void onPostExecute(List<Media> media) {
            super.onPostExecute( media );

            setContentView( R.layout.recycler_view );
            final RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerViewDisplay);
            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            rv.setAdapter(new Adapter( medias, MainActivity.this) );
        }

    }


}