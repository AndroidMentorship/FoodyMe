package com.example.toyin.foodfly.Tabs;

import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.toyin.foodfly.Authentication.Login;
import com.example.toyin.foodfly.Item.ComboOrder;
import com.example.toyin.foodfly.R;
import com.example.toyin.foodfly.Tabs.Drinks;
import com.example.toyin.foodfly.Tabs.Foreign;
import com.example.toyin.foodfly.Tabs.Indegenious;

/**
 * Created by Toyin on 24/06/2017.
 */

public class Category extends TabActivity {

//    private ImageView image;
    private ImageButton fab;
    private ImageView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        logout = (ImageView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutMessage();
            }
        });
        //Dealing with the float action button
        fab = (ImageButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category.this, ComboOrder.class);
                startActivity(intent);
            }
        });

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

    public void logoutMessage(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Category.this);
        alertDialogBuilder.setTitle("Logout");
        alertDialogBuilder.setMessage("Logout to login with a different account.")
                .setCancelable(false)
                .setPositiveButton("Logout", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Category.this, Login.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setIcon(android.R.drawable.ic_secure).show();

    }

    @Override
    public void onBackPressed(){
        //Nothing happens when back is pressed.
    }
}
