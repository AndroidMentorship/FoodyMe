package com.example.toyin.foodfly.Authentication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toyin.foodfly.R;

/**
 * Created by Toyin on 24/06/2017.
 */

public class SignUp extends AppCompatActivity {

    private TextView signed_already;
    private EditText username, email, pass1, pass2;
    private Button signup;
    private CheckBox terms_condition;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Wire the widget features on the signup page to the xml path
        signed_already = (TextView) findViewById(R.id.signed_already);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        pass1 = (EditText) findViewById(R.id.password_one);
        pass2 = (EditText) findViewById(R.id.password_two);
        signup = (Button) findViewById(R.id.signup_button);
        terms_condition = (CheckBox) findViewById(R.id.check_term);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(pass1.toString().trim() != pass2.toString().trim()){
//                    Toast.makeText(getApplicationContext(), "The passwords you entered are not the same.", Toast.LENGTH_SHORT).show();
//                }
//                else{
                    Intent intent = new Intent(SignUp.this, Login.class);
                    startActivity(intent);

//                }
            }
        });

        //Assigning click listenes
        signed_already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });


    }
}
