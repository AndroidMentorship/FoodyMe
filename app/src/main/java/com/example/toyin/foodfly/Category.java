package com.example.toyin.foodfly;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.toyin.foodfly.Tabs.Drinks;
import com.example.toyin.foodfly.Tabs.Foreign;
import com.example.toyin.foodfly.Tabs.Indegenious;

/**
 * Created by Toyin on 24/06/2017.
 */

public class Category extends TabActivity {

//    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        //SEt the back button.
//        image = (ImageView) findViewById(R.id.back_button);
//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(this, )
//            }
//        });

        /*
        TODO: Add the logout clickable icon here.
        * */

        TabHost tabHost = getTabHost();
        // Tab for Foreign foods
        TabHost.TabSpec foreign_spec = tabHost.newTabSpec("Foreign");
        foreign_spec.setIndicator("Foreign");
        Intent foreign_intent = new Intent(this, Foreign.class);
        foreign_spec.setContent(foreign_intent);

        // Tab for Indigenous foods
        TabHost.TabSpec indigenous_spec = tabHost.newTabSpec("Indigenous");
        indigenous_spec.setIndicator("Indigenous");
        Intent indigenous_intent = new Intent(this, Indegenious.class);
        indigenous_spec.setContent(indigenous_intent);

        // Tab for Drinks
        TabHost.TabSpec drinks_spec = tabHost.newTabSpec("Drinks");
        drinks_spec.setIndicator("Drinks");
        Intent drink_intent = new Intent(this, Drinks.class);
        drinks_spec.setContent(drink_intent);

        tabHost.setCurrentTab(0);

        // Adding all TabSpec to TabHost
        tabHost.addTab(foreign_spec); // Adding foreign tab
        tabHost.addTab(indigenous_spec); // Adding indigenous tab
        tabHost.addTab(drinks_spec); // Adding drinks tab
    }


    @Override
    public void onBackPressed(){
    }
}
