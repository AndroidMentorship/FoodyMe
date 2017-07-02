package com.example.toyin.foodfly.Item;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.toyin.foodfly.R;
import com.example.toyin.foodfly.Tabs.Category;

/**
 * Created by Toyin on 02/07/2017.
 */

public class OnComplete extends AppCompatActivity {

    private Button okay_button;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        okay_button = (Button) findViewById(R.id.success);
        okay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnComplete.this, Category.class);
                startActivity(intent);
            }
        });
    }
}
