package com.a100sewa.a100sewa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Share extends Fragment {
    Button btnf,btng,btnw;
    public Share() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false);
        btnf=(Button)findViewById(R.id.btnf);
        btng=(Button)findViewById(R.id.btng);
        btnw=(Button)findViewById(R.id.btnw);

        btnw.setOnClickListener(new View.OnClickListener());
           @Override
                   public void onClick(View view){
            Intent myIntent=new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            string shareBody="";
            string shareSub="";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
            myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(myIntent,"share using"));
            Intent btnw = new Intent(MainActivity.this,btnw.class);

        }
    }

}
