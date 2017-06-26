package com.example.toyin.foodfly;

/**
 * Created by Toyin on 25/06/2017.
 */

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,
                               long id) {

        Toast.makeText(parent.getContext(), parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
