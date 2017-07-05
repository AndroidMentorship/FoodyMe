package com.example.toyin.foodfly.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.toyin.foodfly.R;

/**
 * Created by Toyin on 02/07/2017.
 */

public class AccountDetail extends AppCompatActivity {

    public EditText name, bank, pin, number, cv1;
    public Button done;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_details);

        name = (EditText) findViewById(R.id.acc_name);
        bank = (EditText) findViewById(R.id.bank_name);
        pin = (EditText) findViewById(R.id.pin);
        number = (EditText) findViewById(R.id.acc_number);
        cv1 = (EditText) findViewById(R.id.cv);

        //Direct the user to the login page once he is done signing up.
        done = (Button) findViewById(R.id.account_button);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountDetail.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
