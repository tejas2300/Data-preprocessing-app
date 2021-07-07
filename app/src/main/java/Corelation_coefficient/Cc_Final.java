package Corelation_coefficient;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dmdw1.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Cc_Final extends AppCompatActivity {

    Button donebtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        final String at1=getIntent().getStringExtra("atrs1") ;
        final String at2=getIntent().getStringExtra("atrs2") ;
        final double r=getIntent().getDoubleExtra("rr",0);

        TextView textViewr=findViewById(R.id.finalr);
        TextView textViewfinal=findViewById(R.id.finatextview);

        donebtn=findViewById(R.id.donebtn);
//        test=findViewById(R.id.buttontest);
//
//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2=new Intent (Cc_Final.this,PCA_AnswerTable.class);
//
//                intent2.putExtra("atrans1",at1);
//                intent2.putExtra("atrans2",at2);
//                startActivity(intent2);
//            }
//        });

        DecimalFormat df=new DecimalFormat("0.00");

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainactivity();
            }
        });


        df.setRoundingMode(RoundingMode.UP);
        textViewr.setText("r("+at1+","+at2+")= "+ df.format(r));
        if(r>0&&r>0.60)
            textViewfinal.setText("Final Result: Our result is "+df.format(r)+" or "+df.format(r*100)+"% which is positively correlated and grater than 0.60  hence strongly positive  ");
        else if(r>0&&r<0.40)
            textViewfinal.setText("Final Result: Our result is "+df.format(r)+" or "+df.format(r*100)+"% which is positively correlated and less than 0.40  hence weekly positive  ");
        else if(r<0&&r>0.60)
            textViewfinal.setText("Final Result: Our result is "+df.format(r)+" or "+df.format(r*100)+"% which is negatively correlated and grater than -0.60  hence Weekly negative  ");
        else if(r<0&&r<0.40)
            textViewfinal.setText("Final Result: Our result is "+df.format(r)+" or "+df.format(r*100)+"% which is negatively correlated and less than -0.40  hence Strongly  negative  ");
        else if (r>0&& 0.40<r&&r<0.60)
            textViewfinal.setText("Final Result: Our result is "+df.format(r)+" or "+df.format(r*100)+"% which is positively correlated and between 0.40 and 0.60 hence moderate");
        else if (r<0&& 0.40<r&&r<0.60)
            textViewfinal.setText("Final Result: Our result is "+df.format(r)+" or "+df.format(r*100)+"% which is negatively correlated and between 0.40 and 0.60 hence moderate");
    }

    public void openMainactivity(){
        Intent intent =new Intent(this, Cc_Firstpage.class);
        this.startActivity(intent);
    }
}