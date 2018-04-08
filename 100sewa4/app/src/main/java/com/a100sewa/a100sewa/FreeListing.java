package com.a100sewa.a100sewa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FreeListing extends AppCompatActivity {

    Button btnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_listing);

        btnc = (Button)findViewById(R.id.btnc);

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent freelisting = new Intent(MainActivity.this,FreeListing.class);
                startActivity(FreeListing);
    }
}