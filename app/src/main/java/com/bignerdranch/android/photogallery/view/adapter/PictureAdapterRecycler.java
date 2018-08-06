package com.bignerdranch.android.photogallery.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bignerdranch.android.photogallery.R;
import com.bignerdranch.android.photogallery.model.PictureItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PictureAdapterRecycler extends RecyclerView.Adapter<PictureAdapterRecycler.MyViewHolder> {
    private List<PictureItem> pictureItems;

    public PictureAdapterRecycler(List<PictureItem> pictureItems) {
        this.pictureItems = pictureItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.recycler_item_picture, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        //method with() already is not exist, instead get()
        Picasso.get()
                .load(pictureItems.get(position).getUrl())
                .placeholder(R.drawable.bill_up_close)
                .into(myViewHolder.pictureImageView);
    }

    @Override
    public int getItemCount() {
        return pictureItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView pictureImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.image_view_picture);
        }
    }
}
