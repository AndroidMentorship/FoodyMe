package com.example.toyin.foodfly.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.toyin.foodfly.Item.ItemDescription;
import com.example.toyin.foodfly.ObjectClasses.Food;
import com.example.toyin.foodfly.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toyin on 24/06/2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    public Context mContext;
    public List<Food> foodList = new ArrayList<>();
    public String desc, titl;
    public int pricc, imag;

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

    public FoodAdapter(Context mContext, List<Food> foodlist) {
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
        titl = foodList.get(position).getTitle();
        desc = foodList.get(position).getDescription();
        pricc = foodList.get(position).getPrice();
        imag = foodList.get(position).getThumbnail();
        holder.title.setText(titl);
        holder.cardView.findViewById(R.id.cv);
        holder.description.setText(desc);
        holder.price.setText(pricc + "");
        holder.thumbnail.setImageResource(imag);

//        // loading album cover using Glide library
        Glide.with(mContext).load(foodList.get(position).getThumbnail()).into(holder.thumbnail);

        //set a listener for your each item of your view.
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemDescription.class);
                intent.putExtra("title", titl);
                intent.putExtra("description", desc);
                intent.putExtra("price", pricc);
                intent.putExtra("image", imag);
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
