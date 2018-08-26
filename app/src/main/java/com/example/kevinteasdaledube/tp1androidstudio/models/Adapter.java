package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kevinteasdaledube.tp1androidstudio.R;

import java.io.Serializable;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{


    private static List<Media> mediaList;
    private Context context;



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , Serializable {

        private final TextView title;
        private final TextView mediaType;
        ViewGroup viewGroup;


        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener( this );
            //view.setOnLongClickListener( this );
            viewGroup = (ViewGroup) view.findViewById( R.id.detailLayout);
            title = view.findViewById(R.id.textViewTitle1 );
            mediaType = view.findViewById( R.id.textViewMediaType );
        }



        @Override
        public void onClick(View v) {
            Intent intent;
            Media myMedia = mediaList.get( getLayoutPosition() );
            if(Media.type.Book.equals( myMedia.getMediaType() )){
                intent = new Intent( context, Actitity_Book.class );
                //L'objet, qui implémente Serializable peut etre passé entre 2 activity.
                intent.putExtra( "info", myMedia );
                context.startActivity( intent );
            }
            if (Media.type.CD.equals( myMedia.getMediaType() )){
                intent = new Intent( context, Activity_Cd.class );
                //L'objet, qui implémente Serializable peut etre passé entre 2 activity.
                intent.putExtra( "info", myMedia );
                context.startActivity( intent );
            }
            if (Media.type.DVD.equals( myMedia.getMediaType() )){
                intent = new Intent( context, Activity_Dvd.class );
                //L'objet, qui implémente Serializable peut etre passé entre 2 activity.
                intent.putExtra( "info", myMedia );
                context.startActivity( intent );
            }
            if (Media.type.MP3.equals( myMedia.getMediaType() )){
                intent = new Intent( context, Activity_Mp3.class );
                //L'objet, qui implémente Serializable peut etre passé entre 2 activity.
                intent.putExtra( "info", myMedia );
                context.startActivity( intent );
            }
            if (Media.type.MP4.equals( myMedia.getMediaType() )){
                intent = new Intent( context, Activity_Mp4.class );
                //L'objet, qui implémente Serializable peut etre passé entre 2 activity.
                intent.putExtra( "info", myMedia );
                context.startActivity( intent );
            }
        }
    }

    public Adapter(List<Media> myDataset, Context context) {
        mediaList = myDataset;
        this.context = context;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            holder.title.setText( mediaList.get( position ).getTitle() );

           if (Media.type.Book.equals( mediaList.get( position ).getMediaType())) {

               holder.mediaType.setText( mediaList.get( position ).getMediaType().getType() );

            }else if (Media.type.CD.equals( mediaList.get( position ).getMediaType())){

               holder.mediaType.setText( mediaList.get( position ).getMediaType().getType() );

            }else if (Media.type.DVD.equals( mediaList.get( position ).getMediaType())){

               holder.mediaType.setText( mediaList.get( position ).getMediaType().getType() );
            }else if (Media.type.MP3.equals( mediaList.get( position ).getMediaType())){

               holder.mediaType.setText( mediaList.get( position ).getMediaType().getType() );

            }else if (Media.type.MP4.equals( mediaList.get( position ).getMediaType())){

               holder.mediaType.setText( mediaList.get( position ).getMediaType().getType() );
            }

    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }


}
