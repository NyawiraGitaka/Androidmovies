package com.nyawira.thedlba;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view_item);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
