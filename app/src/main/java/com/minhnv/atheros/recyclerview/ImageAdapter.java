package com.minhnv.atheros.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    Context context;
    ArrayList<Image> images;

    public ImageAdapter(Context context, ArrayList<Image> images) {
        this.context = context;
        this.images = images;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.image_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 6;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                images.get(position).getImage(), opts);
        holder.image.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SquareImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (SquareImageView) itemView.findViewById(R.id.imgView);

        }
    }
}
