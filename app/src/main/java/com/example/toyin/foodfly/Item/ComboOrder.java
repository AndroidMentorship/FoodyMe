package com.example.toyin.foodfly.Item;

import android.content.DialogInterface;
import android.content.Intent;
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
    public List<SelectedFood> foodList;
    private Button order;
    private ImageView logout;
    private TextView price;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combo_order);

        foodList = new ArrayList<>();
        food = new SelectedFoodAdapter(this, foodList);
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
