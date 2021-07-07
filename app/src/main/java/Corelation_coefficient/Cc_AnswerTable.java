package Corelation_coefficient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dmdw1.InputAdapter;
import com.example.dmdw1.R;

import java.util.ArrayList;
import java.util.List;

public class Cc_AnswerTable extends AppCompatActivity {
    private RecyclerView recyclerView;
    double [] xpassed,ypassed;
    double [] prodxy;
    double [] prodx;
    double [] prody;
    double sumxsq=0;
    double sumysq=0;
    double sumxy=0;
    double sumx=0;
    double k1;
    double sumy=0;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_table);
        TextView at1 = findViewById(R.id.at1);
        TextView at2 = findViewById(R.id.at2);
        TextView sumsqx = findViewById(R.id.sumsqx);
        TextView sumsqy = findViewById(R.id.sumsqy);
        TextView sumofxy = findViewById(R.id.sumxy);
        TextView sumofx = findViewById(R.id.summetionx);
        TextView sumofy = findViewById(R.id.summetiony);
        TextView atxy = findViewById(R.id.textViewxy);
        Button calcButton=findViewById(R.id.calculateTablebtn);

        final String atribute1=getIntent().getStringExtra("X") ;
        final String atribute2=getIntent().getStringExtra("Y") ;

            k1= InputAdapter.inputModelArrayList.size();



        at1.setText(""+atribute1+"²");
        at2.setText(""+atribute2+"²");
        atxy.setText(atribute1+atribute2);

        recyclerView=findViewById(R.id.ans_rv);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
//
        final List<Cc_Model> list =new ArrayList<>();
        xpassed =new double[InputAdapter.inputModelArrayList.size()];
//
        ypassed =new double[InputAdapter.inputModelArrayList.size()];
//
        for(int i=0;i<InputAdapter.inputModelArrayList.size();i++){
            xpassed[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue());
            ypassed[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getYvalue());
//            xypassed[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue())*Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getYvalue());
//            xypassed[i]=xpassed[i]*ypassed[i];
        }
//
        for (int i = 0; i < InputAdapter.inputModelArrayList.size(); i++){

            list.add(new Cc_Model(""+Math.round(xpassed[i]*ypassed[i])*100.00/100.00,""+Math.round(Math.pow(xpassed[i],2)*100.00/100.00),""+Math.round(Math.pow(ypassed[i],2)*100.00/100.00) ));

        }
        for (int i = 0; i < InputAdapter.inputModelArrayList.size(); i++){

            sumxsq=sumxsq+Math.pow(xpassed[i],2);
            sumysq=sumysq+Math.pow(ypassed[i],2);


            sumxy=sumxy+(xpassed[i]*ypassed[i]);
            sumx=sumx+xpassed[i];
            sumy=sumy+ypassed[i];
        }
        sumsqx.setText( "Σ"+atribute1+"²:"+sumxsq);
        sumsqy.setText( "Σ"+atribute2+"²:"+sumysq);
        sumofx.setText( "Σ"+atribute1+":"+Math.round(sumx*100.00)/100.00);
        sumofy.setText( "Σ"+atribute2+":"+Math.round(sumy*100.00)/100.00);
        sumofxy.setText( "Σ"+(atribute1+atribute2)+":"+sumxy);
//
//
        Cc_Adapter adapter =new Cc_Adapter(list);
        recyclerView.setAdapter(adapter);



        final double a1 = (k1*sumxy) - (sumx*sumy);
        final double a2 = (k1*sumxsq) - (sumx*sumx);
        final double a3 = (k1*sumysq) - (sumy*sumy);
        final double a4 = (a2*a3);
        final double a5= Math.pow(a4,0.5);
        final double a6 = (a1 / a5);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Cc_AnswerTable.this, Cc_Final.class);

//                passValues();
                    intent.putExtra("rr", a6);
                    intent.putExtra("atrs1", atribute1);
                    intent.putExtra("atrs2", atribute2);
                    startActivity(intent);
                }
        });



//
    }
//    private void passValues(){
//        Intent intent =new Intent(Cc_AnswerTable.this,PCA_AnswerTable.class);
//        intent.putExtra("xxx",xpassed);
//    }


}