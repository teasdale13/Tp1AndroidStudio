package com.example.kevinteasdaledube.tp1androidstudio.models;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kevinteasdaledube.tp1androidstudio.R;

import java.util.List;


public class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.ViewHolder> {

    private static List<Media> mediaList;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView mediaType;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.textViewTitle1 );
            mediaType = view.findViewById( R.id.textViewMediaType );

        }
    }

    public RecyclerViewAdapter(List<Media> myDataset) {
        mediaList = myDataset;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate( R.layout.cell_layout, parent, false);
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