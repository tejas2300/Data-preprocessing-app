package com.example.dmdw1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Matrix1Activity extends AppCompatActivity {
    private TextView cov11,cov12;
    private TextView cov21,cov22;

    private TextView cova11,cova12;
    private TextView cova21,cova22;

    private TextView covb11,covb12;
    private TextView covb21,covb22;
    private TextView x1y1,x1y1Values;
    private TextView x2y2,x2y2Values;
    private TextView FinalResult;


    private TextView qudratic1,qudratic2,qudratic3,a_b_c;
    Button matrix2btn;




// Matrix 2 .javA
    private TextView xyequation2_1,xyequation2_2;
    private TextView xyequation2_3,xyequation2_4;
    private TextView xyequation2_5,xyequation2_6;
    private TextView xyequation2_7,xyequation2_8;

    private TextView cove11,cove12,cove21,cove22;
    private TextView covf11,covf12,covf21,covf22;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix1);
        cov11=findViewById(R.id.cov11);
        cov12=findViewById(R.id.cov12);
        cov21=findViewById(R.id.cov21);
        cov22=findViewById(R.id.cov22);


        cova11=findViewById(R.id.cova11);
        cova12=findViewById(R.id.cova12);
        cova21=findViewById(R.id.cova21);
        cova22=findViewById(R.id.cova22);

        covb11=findViewById(R.id.covb11);
        covb12=findViewById(R.id.covb12);
        covb21=findViewById(R.id.covb21);
        covb22=findViewById(R.id.covb22);

        qudratic1=findViewById(R.id.qudratic1);
        qudratic2=findViewById(R.id.qudratic2);
        qudratic3=findViewById(R.id.qudratic3);
        a_b_c=findViewById(R.id.a_b_c);



        TextView λ1_λ2_value=findViewById(R.id.λ1_λ2_values);
        TextView COVC11=findViewById(R.id.covc11_λ);
        TextView COVC12=findViewById(R.id.covc12);
        TextView COVC21=findViewById(R.id.covc21);
        TextView COVC22=findViewById(R.id.covc22_λ);

        TextView COVD11=findViewById(R.id.covd11_λ);
        TextView COVD12=findViewById(R.id.covd12);
        TextView COVD21=findViewById(R.id.covd21);
        TextView COVD22=findViewById(R.id.covd22_λ);

        TextView xyequation1_1=findViewById(R.id.x_y_equation1_1);
        TextView xyequation1_2=findViewById(R.id.x_y_equation1_2);
//        TextView xyequation1_3=findViewById(R.id.x_y_equation1_3);
//        TextView xyequation1_4=findViewById(R.id.x_y_equation1_4);
        TextView xyequation1_5=findViewById(R.id.x_y_equation1_5);
        TextView xyequation1_6=findViewById(R.id.x_y_equation1_6);
        TextView xyequation1_7=findViewById(R.id.x_y_equation1_7);
        TextView xyequation1_8=findViewById(R.id.x_y_equation1_8);




        xyequation2_1=findViewById(R.id.x_y_equation2_1);
        xyequation2_2=findViewById(R.id.x_y_equation2_2);
        xyequation2_3=findViewById(R.id.x_y_equation2_3);
        xyequation2_4=findViewById(R.id.x_y_equation2_4);
        xyequation2_5=findViewById(R.id.x_y_equation2_5);
        xyequation2_6=findViewById(R.id.x_y_equation2_6);
        xyequation2_7=findViewById(R.id.x_y_equation2_7);
        xyequation2_8=findViewById(R.id.x_y_equation2_8);



        cove11=findViewById(R.id.cove11_λ);
        cove12=findViewById(R.id.cove12);
        cove21=findViewById(R.id.cove21);
        cove22=findViewById(R.id.cove22_λ);

        covf11=findViewById(R.id.covf11_λ);
        covf12=findViewById(R.id.covf12);
        covf21=findViewById(R.id.covf21);
        covf22=findViewById(R.id.covf22_λ);

        x1y1=findViewById(R.id.x1y1);
        x1y1Values=findViewById(R.id.x1y1values);
        x2y2=findViewById(R.id.x2y2);
        x2y2Values=findViewById(R.id.x2y2values);
        FinalResult=findViewById(R.id.Final_ev_result);



        String atribute1=getIntent().getStringExtra("atm1");
        String atribute2=getIntent().getStringExtra("atm2");


        double covx_x=getIntent().getDoubleExtra("covxx",0.0);
        double covx_y=getIntent().getDoubleExtra("covxy",0.0);
        double covy_x=getIntent().getDoubleExtra("covyx",0.0);
        double covy_y=getIntent().getDoubleExtra("covyy",0.0);

        covx_x=Math.round(covx_x*10000.00)/10000.00;
        covx_y=Math.round(covx_y*10000.00)/10000.00;
        covy_x=Math.round(covy_x*10000.00)/10000.00;
        covy_y=Math.round(covy_y*10000.00)/10000.00;



        cov11.setText("cov("+atribute1+","+atribute1+")");
        cov12.setText("cov("+atribute1+","+atribute2+")");
        cov21.setText("cov("+atribute2+","+atribute1+")");
        cov22.setText("cov("+atribute2+","+atribute2+")");


        cova11.setText(""+ covx_x);
        cova12.setText(""+ covx_y);
        cova21.setText(""+ covy_x);
        cova22.setText(""+ covy_y);


        covb11.setText(covx_x+"-λ");
        covb12.setText(covx_y+"");
        covb21.setText(covy_x+"");
        covb22.setText(covy_y+"-λ");



        double p=1;
        double q=Math.round(-(covy_y+covx_x)*10000.00)/10000.00;
        double r =Math.round(((covx_x * covy_y) - (covx_y * covx_y))*10000.00)/10000.00 ;



        qudratic1.setText("("+covx_x+"-λ)("+covy_y+"-λ)-("+covx_y+")²=0");
        qudratic2.setText("λ²-("+(covy_y+covx_x)+"λ)+("+Math.round(covx_x*covy_y*10000.00)/10000.00+")-("+Math.round(covx_y*covx_y*10000.00)/10000.00+")=0");
        qudratic3.setText("λ²-"+(covy_y+covx_x)+"λ+"+Math.round(r* 10000.00)/10000.00+"=0");
        a_b_c.setText("          a=1    ,    b="+Math.round(q*10000.00)/10000.00+"     ,    c="+Math.round(r*10000.00)/10000.00);


        double m=(q*q-4*p*r);
        double n=(-q);
        final double λ1=(n+Math.sqrt(m))/2*p;
        final double λ2=(n-Math.sqrt(m))/2*p;
        // Matrix 2 .java



        λ1_λ2_value.setText("   λ1 ="+Math.round(λ1*10000.00)/10000.00 +" ,  λ2 ="+Math.round(λ2*10000.00)/10000.00);

        COVC11.setText(""+(covx_x+""+(-Math.round(λ1*10000.00)/10000.00)));
        COVC12.setText(""+covx_y);
        COVC21.setText(""+covy_x);
        COVC22.setText(""+(covy_y+""+(-Math.round(λ1*10000.00)/10000.00)));
        double a=covx_x-(λ1);
        double b=covy_y-(λ1);

        COVD11.setText(""+Math.round(a*10000.00)/10000.00);
        COVD12.setText(""+covx_y);
        COVD21.setText(""+covy_x);
        COVD22.setText(""+Math.round(b*10000.00)/10000.00);

        xyequation1_1.setText(Math.round(a*10000.00)/10000.00+"X1+("+covx_y+")Y1=0");
        xyequation1_2.setText(covy_x+"X1+("+Math.round(b*10000.00)/10000.00+")Y1=0");


        final double div=Math.round((-covx_y)/a*10000.00)/10000.00;
        xyequation1_5.setText("X1="+div+"Y1");
        xyequation1_6.setText("("+div+"Y1)²+Y1²=1");

        double divplusone=Math.pow(div,2)+1;
        double div1=Math.round(1/divplusone*10000.00)/10000.00;
        xyequation1_7.setText("Y1²="+div1);
        xyequation1_8.setText("X1="+Math.round(div*Math.sqrt(div1)*10000.00)/10000.00+" , Y1="+Math.round(Math.sqrt(div1)*10000.00)/10000.00);

//        xyequation1_7.setText(Math.pow(div,2)+"Y1²+Y1²=1");
//        xyequation1_7.setText(Math.pow(div,2)+"Y1²+Y1²=1");
//        double λ2=Math.round(λ2*10000.00)/10000.00;

        cove11.setText(covx_x+"-"+(λ2));
        cove12.setText(covx_y+"");
        cove21.setText(covy_x+"");
        cove22.setText(covy_y+"-"+(λ2));

        covf11.setText(Math.round((covx_x-(λ2))*10000.00)/10000.00+"");
        covf12.setText(covx_y+"");
        covf21.setText(covy_x+"");
        covf22.setText(Math.round((covy_y-(λ2))*10000.00)/10000.00+"");


        double c=covx_x-(λ2);
        double d=covy_y-(λ2);


        xyequation2_1.setText(Math.round(c*10000.00)/10000.00+"X1+("+covx_y+")Y2=0");
        xyequation2_2.setText(covy_x+"X2+("+Math.round(d*10000.00)/10000.00+")Y2=0");

        final double div2=Math.round((-covx_y)/c*10000.00)/10000.00;
        xyequation2_5.setText("X2="+div2+"Y2");
        xyequation2_6.setText("("+div2+"Y2)²+Y2²=1");

        double div3=Math.round(1/(Math.pow(div2,2)+1)*10000.00)/10000.00;
        xyequation2_7.setText("Y2²="+div3);
        xyequation2_8.setText("X2="+Math.round(div2*Math.sqrt(div3)*10000.00)/10000.00+" , Y2="+Math.round(Math.sqrt(div3)*10000.00)/10000.00);





        x1y1.setText("X1,Y1 :");
        x1y1Values.setText(""+Math.round(div*Math.sqrt(div1)*10000.00)/10000.00+","+Math.round(Math.sqrt(div1)*10000.00)/10000.00);
        x2y2.setText("X2,Y2 :");
        x2y2Values.setText(" "+Math.round(div2*Math.sqrt(div3)*10000.00)/10000.00+","+Math.round(Math.sqrt(div3)*10000.00)/10000.00);

        if(λ1>λ2) {
            FinalResult.setText("Here λ1 is Grater than λ2 then Principle Components are X1, Y1 :"+Math.round(div*Math.sqrt(div1)*10000.00)/10000.00+","+Math.round(Math.sqrt(div1)*10000.00)/10000.00);
        }else if(λ1<λ2){
            FinalResult.setText("Here λ2 is Grater than λ1 then Principle Components are X2, Y2 :"+Math.round(div2*Math.sqrt(div3)*10000.00)/10000.00+","+Math.round(Math.sqrt(div3)*10000.00)/10000.00);

        }
    }
}