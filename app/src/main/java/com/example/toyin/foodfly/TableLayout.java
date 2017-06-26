package com.example.toyin.foodfly;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.example.toyin.foodfly.Tabs.Drinks;
import com.example.toyin.foodfly.Tabs.Foreign;
import com.example.toyin.foodfly.Tabs.Indegenious;

/**
 * Created by Toyin on 24/06/2017.
 */

public class TableLayout extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
//        ViewPager pager = (ViewPager) findViewById(R.id.pager);
//        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
//
//        pager.setAdapter(adapter);
//        tabs.setupWithViewPager(pager);



    }
}
