package com.example.toyin.foodfly.Item;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toyin.foodfly.ObjectClasses.SelectedFood;
import com.example.toyin.foodfly.R;
import com.example.toyin.foodfly.Tabs.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toyin on 25/06/2017.
 */

public class ItemDescription extends AppCompatActivity implements Serializable {

    private ImageView bgHeader;
    private TextView title, price, description;
    private Button add;
    public String titl, descriptin;
    public int pric, image;
    public List<SelectedFood> selectedFoodList;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //Details of the content
        title = (TextView) findViewById(R.id.title);
        price = (TextView) findViewById(R.id.price);
        description = (TextView) findViewById(R.id.description);
        add = (Button) findViewById(R.id.button_add);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //SEtting the content of the collapse bar layout.
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("View and Description");
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.colorBg));
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.expandedappbar);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorAccent));

        //Getting the item of the clicked item
        titl = getIntent().getStringExtra("title");
        descriptin = getIntent().getStringExtra("description");
        pric = getIntent().getIntExtra("price", 0);
        image = getIntent().getIntExtra("image", 0);

        //Setting the collapsing bar image and the other details
        bgHeader = (ImageView) findViewById(R.id.bgheader);
        bgHeader.setImageResource(image);
        title.setText(titl);
        price.setText(pric + "");
        description.setText(descriptin);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSelectedData();  //Invoking the method getSelectedData.
                Intent intent = new Intent(ItemDescription.this, Category.class);
                startActivity(intent);
            }
        });
    }

    public void getSelectedData(){

        //Put selected content in selectedFood class.
        SharedPreferences sharedPreferences = getSharedPreferences("preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("title", titl);
        editor.putString("description", descriptin);
        editor.putInt("price", pric);
        editor.putInt("image", image);
        editor.commit();


    }
}