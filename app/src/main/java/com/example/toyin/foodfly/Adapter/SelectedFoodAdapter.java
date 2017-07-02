package com.example.toyin.foodfly.Adapter;

/**
 * Created by Toyin on 02/07/2017.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.toyin.foodfly.ObjectClasses.SelectedFood;
import com.example.toyin.foodfly.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toyin on 24/06/2017.
 */

public class SelectedFoodAdapter extends RecyclerView.Adapter<SelectedFoodAdapter.MyViewHolder> {

    private Context mContext;
    private List<SelectedFood> foodList;

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

    public SelectedFoodAdapter(Context mContext, List<SelectedFood> foodlist) {
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
        foodList= new ArrayList<>();
        final SelectedFood food = foodList.get(position);
        holder.title.setText(food.getSelectedTitle());
        holder.cardView.findViewById(R.id.cv);
        holder.description.setText(food.getSelectedDescription());
        holder.price.setText(food.getSelectedPrice());
        holder.thumbnail.setImageResource(food.getThumbnail());

//        // loading album cover using Glide library
        Glide.with(mContext).load(food.getThumbnail()).into(holder.thumbnail);

        //set a listener for your each item of your view.

            //You should not be able to make a click on each item here.
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), ItemDescription.class);
//                intent.putExtra("title", food.getTitle());
//                intent.putExtra("description", food.getDescription());
//                intent.putExtra("price", food.getPrice());
//                intent.putExtra("image", food.getThumbnail());
//                v.getContext().startActivity(intent);
//            }
//        });
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
