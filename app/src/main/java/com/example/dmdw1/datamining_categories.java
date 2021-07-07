package com.example.dmdw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Corelation_coefficient.Cc_Firstpage;

import Principle_Comp_Analysis.PCA_Firstpage;
import linear_regration.Lr_Firstpage;

public class datamining_categories extends AppCompatActivity {


    private TextView cctv,pcatv,lr_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datamining_categories);
    cctv=findViewById(R.id.cctv);
    pcatv=findViewById(R.id.pcatv);
    lr_tv=findViewById(R.id.lr_tv);

    cctv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =new Intent(datamining_categories.this, Cc_Firstpage.class);
            startActivity(intent);
        }
    });

    pcatv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =new Intent(datamining_categories.this, PCA_Firstpage.class);
            startActivity(intent);

        }
    });


    lr_tv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =new Intent(datamining_categories.this, Lr_Firstpage.class);
            startActivity(intent);

        }
    });




    }
}