package com.example.toyin.foodfly.Tabs;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.example.toyin.foodfly.ObjectClasses.Food;
import com.example.toyin.foodfly.Adapter.Food_Adapter;
import com.example.toyin.foodfly.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toyin on 24/06/2017.
 */

public class Foreign extends Activity {

    public RecyclerView recyclerView;
    public Food_Adapter food_adapter;
    public List<Food> foodList;
    public LinearLayout item1, item2;

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    //
    public void populate_recycler(){
        String title = "FRIED Sausage";
        String description = "Have you ever imagined frying a chicken with its life in it. This is the meal for you";
        int price = 180;
        int image = R.drawable.food3;

        for(int i = 0; i < 20; i++){
            Food food = new Food(price, description, image, title);
            foodList.add(food);
        }
    }

    @Override
    protected  void onCreate(Bundle savedInstasnceState){
        super.onCreate(savedInstasnceState);
        setContentView(R.layout.activity_foreign);

        foodList = new ArrayList<>();
        populate_recycler();
        food_adapter = new Food_Adapter(this, foodList);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_foreign);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(0), true));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(food_adapter);

        food_adapter.notifyDataSetChanged();
    }



    }


