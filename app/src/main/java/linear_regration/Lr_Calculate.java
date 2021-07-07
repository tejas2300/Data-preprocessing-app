package linear_regration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dmdw1.InputAdapter;
import com.example.dmdw1.R;

import java.util.StringTokenizer;

public class Lr_Calculate extends AppCompatActivity {
    TextView eq1,eq2,eq3,eq4,eq5,eq6,eq7,eq8,eq9,eq10,eq11,eq12,eq13,eq14;
    TextView lrTitle;
    EditText editTextxory;
    Button Calculate1 ;
    Button Calculate2 ;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_lr);
        lrTitle=findViewById(R.id.lr_formula_title);
        eq1=findViewById(R.id.lr_eqution1);
        eq2=findViewById(R.id.lr_eqution2);
        eq3=findViewById(R.id.lr_eqution3);
        eq4=findViewById(R.id.lr_eqution4);
        eq5=findViewById(R.id.lr_eqution5);
        eq6=findViewById(R.id.lr_eqution6);
        eq7=findViewById(R.id.lr_eqution7);
        eq8=findViewById(R.id.lr_eqution8);
        eq9=findViewById(R.id.lr_eqution9);
        eq10=findViewById(R.id.lr_eqution10);
        eq11=findViewById(R.id.lr_eqution11);
        eq12=findViewById(R.id.lr_eqution12);
        eq13=findViewById(R.id.lr_eqution13);
        eq14=findViewById(R.id.lr_eqution14);


        editTextxory=findViewById(R.id.xoryedtx);
        Calculate1=findViewById(R.id.calcxory1);
        Calculate2=findViewById(R.id.calcxory2);


        Double sumx=getIntent().getDoubleExtra("sumx",0.0);
        Double sumy=getIntent().getDoubleExtra("sumy",0.0);
        Double sumxy=getIntent().getDoubleExtra("sumxy",0.0);
        Double sumsqx=getIntent().getDoubleExtra("sumsqx",0.0);

        int n = InputAdapter.inputModelArrayList.size();


        double af=n*sumxy-sumx*sumy;
        double df=n*sumsqx-sumx*sumx;
        final double A=af/df;
        final double B=(sumy-A*sumx)/n;

        lrTitle.setText(" Use the formula to calculate 'a'and'b' as follows with :");
        eq1.setText("a=("+n+"*"+sumxy+"-"+sumx+"*"+sumy+")"+"/"+"("+n+"*"+sumsqx+"-"+(sumx*sumx)+")");
        eq2.setText("a="+(Math.round(af*100.00)/100.00)+"/"+(Math.round(af*100.00)/100.00));
        eq3.setText("a="+Math.round((A)*100.00 )/100.00);
        eq4.setText("b=("+sumy+"-"+Math.round(A*100.00)/100.00+"*"+sumx+")/"+n);
        eq5.setText("b="+Math.round(B*100.00)/100.00);

        eq6.setText("Y = aX + b");
        eq7.setText("y="+Math.round(A*100.00)/100.00+"x+"+Math.round(B*100.00)/100.00);


        Button xfomy=findViewById(R.id.xfromy);
        final Button yfromx=findViewById(R.id.yfromx);

        xfomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            editTextxory.setHint(" Enter Y Value");
                editTextxory.setVisibility(View.VISIBLE);
                Calculate1.setVisibility(View.VISIBLE);

            }
        });
        Calculate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xfromycalculate(A,B);
            }
        });

        yfromx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextxory.setHint(" Enter Y Value");
                editTextxory.setVisibility(View.VISIBLE);
                Calculate2.setVisibility(View.VISIBLE);

            }
        });

        Calculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yfromxcalculate(A,B);
            }
        });

    }


    @SuppressLint("SetTextI18n")
    private void xfromycalculate (double a,double b){
        double yn=Double.parseDouble(editTextxory.getText().toString());
        double A=Math.round(a*100.00)/100.00;
        double B=Math.round(b*100.00)/100.00;

        eq8.setText("X="+yn);
        eq9.setText("X="+A+"*"+yn+"+"+B);
        eq10.setText("X="+A*yn+"+"+B);
        eq11.setText("X="+((A*yn)+(B))+"");


    }

    @SuppressLint("SetTextI18n")
    private void yfromxcalculate (double a,double b){
        double xn=Double.parseDouble(editTextxory.getText().toString());
        double A=Math.round(a*100.00)/100.00;
        double B=Math.round(b*100.00)/100.00;
        eq8.setText("Y="+xn);
        eq9.setText("Y="+A+"*"+xn+"+"+B);
        eq10.setText("Y="+A*xn+"+"+B);
        eq11.setText("Y="+(A*xn+B)+"");

    }
}