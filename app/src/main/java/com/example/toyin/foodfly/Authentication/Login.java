package com.example.toyin.foodfly.Authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.toyin.foodfly.Tabs.Category;
import com.example.toyin.foodfly.R;

/**
 * Created by Toyin on 23/06/2017.
 */

public class Login extends AppCompatActivity {

    private EditText email, password;
    private Button login_button;
    private TextView forgot_password, create_account;
    public String username, passwod;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //On registering, getting the user's detail and automatically filling it in.
        SharedPreferences prefs = this.getSharedPreferences("preference", Context.MODE_PRIVATE);
        username = prefs.getString("username", "");
        passwod = prefs.getString("password", "");

        //Wire the button and login details together
        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
        login_button = (Button) findViewById(R.id.login_button);

        //Set automatically after registration.
        email.setText(username);
        password.setText(passwod);

        //Forgot and create account handle
        forgot_password = (TextView) findViewById(R.id.forgot_p);
        create_account = (TextView) findViewById(R.id.create_account);

        //Set a click listener to the create account text to go to the sign up page
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Login.this, SignUp.class);
                startActivity(intent1);
            }
        });

        //set a clik on the forgot password.
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*TODO:
                    Need to send a new password to the provided email address on the page or via number. I should be back here before 5am
                    Not functional Yet.
            * */
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(email.toString() == EMAIL || password.toString() == PASS){
                    Intent intent2 = new Intent(Login.this, Category.class);
                    startActivity(intent2);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "Please check your login details again, the one you entered is incorrect", Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}