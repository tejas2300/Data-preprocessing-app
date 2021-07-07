package Principle_Comp_Analysis;

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
import com.example.dmdw1.Matrix1Activity;
import com.example.dmdw1.R;

import java.util.ArrayList;
import java.util.List;

public class PCA_AnswerTable extends AppCompatActivity {
    private RecyclerView recyclerView;
    double [] xpassed,ypassed,xypassed;
    double sumx=0, xbar=0;
    double sumy=0, ybar=0;
    double[] x_xbarsqr;
    double[] y_ybarsqr;
    double[] x_ybarsqr;

    double sumx_xbarsqure;
    double sumy_ybarsqure;
    double sumx_ybarsqure;

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_table2);
        final String atributex=getIntent().getStringExtra("atransi1");
        final String atributey=getIntent().getStringExtra("atransi2");

        recyclerView=findViewById(R.id.ans2_rv);
        TextView sumx_xbarsqr=findViewById(R.id.sumx_xbarsqure);
        TextView sumy_ybarsqr=findViewById(R.id.sumy_ybarsqure);
        TextView sumx_xintoy_y=findViewById(R.id.sumx_xintoy_y);
        TextView x_x=findViewById(R.id.x_x);
        TextView y_y=findViewById(R.id.y_y);
        TextView squx_x=findViewById(R.id.sqx_x);
        TextView squy_y=findViewById(R.id.sqy_y);
        TextView squx_y=findViewById(R.id.sqx_y);
        TextView covxx=findViewById(R.id.covxx);
        TextView covxy=findViewById(R.id.covxy);
        TextView covyx=findViewById(R.id.covyx);
        TextView covyy=findViewById(R.id.covyy);

        Button matrix_activity_btn=findViewById(R.id.matrixActivitybtn);



        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        final List<PCA_Model> list =new ArrayList<>();

        xpassed =new double[InputAdapter.inputModelArrayList.size()];
        ypassed =new double[InputAdapter.inputModelArrayList.size()];
        xypassed =new double[InputAdapter.inputModelArrayList.size()];
        x_xbarsqr =new double[InputAdapter.inputModelArrayList.size()];
        y_ybarsqr =new double[InputAdapter.inputModelArrayList.size()];
        x_ybarsqr =new double[InputAdapter.inputModelArrayList.size()];

        for(int i=0;i<InputAdapter.inputModelArrayList.size();i++){
            xpassed[i]= Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue());
            ypassed[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getYvalue());
            xypassed[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue())*Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getYvalue());
            xypassed[i]=xpassed[i]*ypassed[i];
            sumx=sumx+xpassed[i];
            sumy=sumy+ypassed[i];
            xbar=sumx/InputAdapter.inputModelArrayList.size();
            ybar=sumy/InputAdapter.inputModelArrayList.size();
        }
        for (int i = 0; i < InputAdapter.inputModelArrayList.size(); i++){
            x_xbarsqr[i]=((xpassed[i]-xbar)*(xpassed[i]-xbar));
            y_ybarsqr[i]=((ypassed[i]-ybar)*(ypassed[i]-ybar));
            x_ybarsqr[i]=((xpassed[i]-xbar)*(ypassed[i]-ybar));
            sumx_xbarsqure=sumx_xbarsqure+x_xbarsqr[i];
            sumy_ybarsqure=sumy_ybarsqure+y_ybarsqr[i];
            sumx_ybarsqure=sumx_ybarsqure+x_ybarsqr[i];

        }

        for (int i = 0; i < InputAdapter.inputModelArrayList.size(); i++){
            list.add(new PCA_Model(""+Math.round((xpassed[i]-xbar)*100.00)/100.00,""+Math.round(((xpassed[i]-xbar)*(xpassed[i]-xbar))*100.00)/100.00, ""+Math.round((ypassed[i]-ybar)*100.00)/100.00," "+Math.round(((ypassed[i]-ybar)*(ypassed[i]-ybar))*100.00)/100.00, ""+Math.round(((xpassed[i]-xbar)*(ypassed[i]-ybar))*100.00 )/100.00));
        }

        final double covx_x=(sumx_xbarsqure)/(InputAdapter.inputModelArrayList.size()-1);
        final double covx_y=(sumx_ybarsqure)/(InputAdapter.inputModelArrayList.size()-1);
        final double covy_x=(sumx_ybarsqure)/(InputAdapter.inputModelArrayList.size()-1);
        final double covy_y=(sumy_ybarsqure)/(InputAdapter.inputModelArrayList.size()-1);


        sumx_xbarsqr.setText("Σ("+atributex+"-M("+atributex+"))²= "+Math.round((sumx_xbarsqure)*10000.00)/10000.00);
        sumy_ybarsqr.setText("Σ("+atributey+"-M("+atributey+"))²= "+Math.round((sumy_ybarsqure)*10000.00)/10000.00);
        sumx_xintoy_y.setText("Σ("+atributex+"-M("+atributex+"))*("+atributey+"-M("+atributey+"))= "+Math.round((sumx_ybarsqure)*100.0000)/100.0000);

        covxx.setText("cov("+atributex+","+atributex+")=  "+Math.round(covx_x*10000.00)/10000.00);
        covxy.setText("cov("+atributex+","+atributey+")=  "+Math.round(covx_y*10000.00)/10000.00);
        covyx.setText("cov("+atributey+","+atributex+")=  "+Math.round(covy_x*10000.00)/10000.00);
        covyy.setText("cov("+atributey+","+atributey+")=  "+Math.round(covy_y*10000.00)/10000.00);


        x_x.setText(atributex+"-M("+atributex+")");
        y_y.setText(atributey+"-M("+atributey+")");
        squx_x.setText("("+atributex+"-M("+atributex+"))²");
        squy_y.setText("("+atributey+"-M("+atributey+"))²");
        squx_y.setText("("+atributex+"-M("+atributex+"))*("+atributey+"-M("+atributey+"))");




        matrix_activity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent matrixIntent =new Intent(PCA_AnswerTable.this, Matrix1Activity.class);

                matrixIntent.putExtra("atm1",atributex);
                matrixIntent.putExtra("atm2",atributey);

                matrixIntent.putExtra("covxx",covx_x);
                matrixIntent.putExtra("covxy",covx_y);
                matrixIntent.putExtra("covyx",covy_x);
                matrixIntent.putExtra("covyy",covy_y);

                startActivity(matrixIntent);
            }
        });



        PCA_Adapter adapter =new PCA_Adapter(list);
        recyclerView.setAdapter(adapter);
    }
}