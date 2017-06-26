package com.example.toyin.foodfly;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Toyin on 24/06/2017.
 */

public class Food_Adapter extends RecyclerView.Adapter<Food_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Food> foodList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, price;
        public ImageView thumbnail;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cv);
            title = (TextView) view.findViewById(R.id.food_title);
            description = (TextView) view.findViewById(R.id.food_description);
            price = (TextView) view.findViewById(R.id.food_price);
            thumbnail = (ImageView) view.findViewById(R.id.food_image);

        }
    }

    public Food_Adapter(Context mContext, List<Food> foodlist) {
        this.mContext = mContext;
        this.foodList = foodlist;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.title.setText(food.getTitle());
        holder.cardView.findViewById(R.id.cv);
        holder.description.setText(food.getDescription());
        holder.price.setText(food.getPrice());
        holder.thumbnail.setImageResource(food.getThumbnail());

//        // loading album cover using Glide library
        Glide.with(mContext).load(food.getThumbnail()).into(holder.thumbnail);

        //set a listener for your each item of your view.
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemDescription.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
