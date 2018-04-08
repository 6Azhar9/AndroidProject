package com.a100sewa.a100sewa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.imageView);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        imageView.startAnimation(myanim);
        final Intent intent=new Intent(this,MainActivity.class);
        Thread timer =new Thread(){
            public void run() {
                try {
                    sleep(5000);
                }
                catch (InterruptedException exception)
                {
                    exception.printStackTrace();
                }
                finally{
                    startActivities(Intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
