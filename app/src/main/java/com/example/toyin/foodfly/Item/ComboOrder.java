package com.example.toyin.foodfly.Item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toyin.foodfly.Adapter.SelectedFoodAdapter;
import com.example.toyin.foodfly.Authentication.Login;
import com.example.toyin.foodfly.ObjectClasses.SelectedFood;
import com.example.toyin.foodfly.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toyin on 02/07/2017.
 */

public class ComboOrder extends AppCompatActivity {

    public RecyclerView recyclerView;
    public SelectedFoodAdapter food;
    private Button order;
    private ImageView logout;
    public TextView price;
    public String title_string, description_string;
    public int price_int, image_int;
    public List<SelectedFood> foodList;


    //Get the details of the selected meals.
    public void getData(){
        SharedPreferences prefs = this.getSharedPreferences("preference", Context.MODE_PRIVATE);
        title_string = prefs.getString("title", "");
        description_string = prefs.getString("description", "");
        price_int = prefs.getInt("price", 0);
        image_int = prefs.getInt("image", 0);

        SelectedFood selectedFood = new SelectedFood(price_int, description_string, image_int, title_string);
        foodList.add(selectedFood);
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combo_order);


        //Populate the foodList Array
        foodList = new ArrayList<>();
        getData();

        //Set the price to the price of the just gotten food.
        price = (TextView) findViewById(R.id.total_price);
        price.setText(price_int + "");

        //Create an instance of the class SelectedFoodAdapter
        food = new SelectedFoodAdapter(this, foodList);

        //Wiring the recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.combo_recycler);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(0), true));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(food);



        //Wire widgets together
        order = (Button) findViewById(R.id.order_button);
        logout = (ImageView) findViewById(R.id.logout);
        price = (TextView) findViewById(R.id.total_price);

        //Response on clicking on logout button on the top right coner of the screen.
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutMessage();
            }
        });


        //On clicking on the place order button.
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComboOrder.this, OnComplete.class);
                startActivity(intent);
            }
        });


        int assume_integer_has_been_set = 0;


        food.notifyDataSetChanged();

    }

    //Tries to confirm if the user really wants to logout or not.
    public void logoutMessage(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ComboOrder.this);
        alertDialogBuilder.setTitle("Logout");
        alertDialogBuilder.setMessage("Logout to login with a different account.")
                .setCancelable(false)
                .setPositiveButton("Logout", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ComboOrder.this, Login.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setIcon(android.R.drawable.ic_secure).show();

    }


    //A class to help with the animation of my recyclerView.
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
}
