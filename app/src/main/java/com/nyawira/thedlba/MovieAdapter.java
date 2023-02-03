package com.nyawira.thedlba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<MovieItem>list;

    public MovieAdapter(List<MovieItem>list){
        this.list=list;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieItemViewHolder, int position) {
        MovieItem movieItem = list.get(position);
        ImageView imageView = movieItemViewHolder.getImageView();

        Ion.with(movieItemViewHolder.itemView.getContext()).load(movieItem.getPosterUrl()).intoImageView(imageView);


//        String imageUrl = String.valueOf(list.get(position));
//        Picasso.get().load(imageUrl).into(holder.getImageView());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
