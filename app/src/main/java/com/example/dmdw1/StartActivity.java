package com.example.dmdw1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class StartActivity extends AppCompatActivity {
private View view;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        this.setTitle("ATSM System");

        //play Animation
        ImageView img = findViewById(R.id.img2);
        img.setImageResource(R.drawable.dmdw);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        img.setAnimation(anim);
        openActivity1();
    }

        @Override
        public void finish() {
            super.finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        }
        private void openActivity1() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent=new Intent(StartActivity.this,datamining_categories.class);
                    startActivity(intent);
                    StartActivity.this.finish();
                }
            }).start();
        }



    }
