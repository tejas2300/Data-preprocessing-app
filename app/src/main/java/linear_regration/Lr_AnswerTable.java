package linear_regration;

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

public class Lr_AnswerTable extends AppCompatActivity {

    private RecyclerView recyclerView;
    double [] xpassed,ypassed,xypassed,xsqr;
    double sumx=0;
    double sumy=0;
    double sumxy=0;
    double sumsqx=0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr_answer_table);

        final String atributex=getIntent().getStringExtra("atrlrans1");
        final String atributey=getIntent().getStringExtra("atrlrans2");



        recyclerView=findViewById(R.id.ans2_rv);
        TextView x=findViewById(R.id.x);
        TextView y=findViewById(R.id.y);
        TextView xy=findViewById(R.id.xy);
        TextView sqx=findViewById(R.id.sqx);
        TextView sumlrx=findViewById(R.id.sumlrx);
        TextView sumlry=findViewById(R.id.sumlry);
        TextView sumlrxy=findViewById(R.id.sumlrxy);
        TextView sumlrsqx=findViewById(R.id.sumlrsqx);
        Button lr_btn=findViewById(R.id.lr_ansTablebtn);





        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        final List<Lr_AnsModel> list =new ArrayList<>();


        xpassed =new double[InputAdapter.inputModelArrayList.size()];
        ypassed =new double[InputAdapter.inputModelArrayList.size()];
        xypassed =new double[InputAdapter.inputModelArrayList.size()];
        xsqr =new double[InputAdapter.inputModelArrayList.size()];


        for(int i=0;i<InputAdapter.inputModelArrayList.size();i++){
            xpassed[i]= Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue());
            ypassed[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getYvalue());
            xypassed[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue())*Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getYvalue());
           xsqr[i]=Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue())*Double.parseDouble(InputAdapter.inputModelArrayList.get(i).getXvalue());
//            xypassed[i]=xpassed[i]*ypassed[i];
//            sumx=sumx+xpassed[i];
//            sumy=sumy+ypassed[i];
//            xbar=sumx/InputAdapter.inputModelArrayList.size();
//            ybar=sumy/InputAdapter.inputModelArrayList.size();
        }

        for (int i = 0; i < InputAdapter.inputModelArrayList.size(); i++){
         sumx=sumx+xpassed[i];
         sumy=sumy+ypassed[i];
         sumxy=sumxy+xypassed[i];
         sumsqx=sumsqx+xsqr[i];
        }


        lr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lr_AnswerTable.this, Lr_Calculate.class);
                intent.putExtra("sumx",sumx);
                intent.putExtra("sumy",sumy);
                intent.putExtra("sumxy",sumxy);
                intent.putExtra("sumsqx",sumsqx);
                startActivity(intent);
            }
        });

        for (int i = 0; i < InputAdapter.inputModelArrayList.size(); i++){
            list.add(new Lr_AnsModel(""+Math.round((xpassed[i])*100.00)/100.00, ""+Math.round((ypassed[i])*100.00)/100.00," "+Math.round((xypassed[i])*100.00)/100.00, ""+Math.round((xsqr[i])*100.00 )/100.00));
        }

        x.setText(""+atributex);
        y.setText(""+atributey);
        xy.setText(""+atributex+""+atributey);
        sqx.setText(""+atributex+"²");

        sumlrx.setText("Σ"+atributex+":"+Math.round(sumx*100.00)/100.00);
        sumlry.setText("Σ"+atributey+":"+Math.round(sumy*100.00)/100.00);
        sumlrxy.setText("Σ"+atributex+atributey+":"+Math.round(sumxy*100.00)/100.00);
        sumlrsqx.setText("Σ"+atributex+"²:"+Math.round(sumsqx*100.00)/100.00);



        Lr_AnsAdapter adapter =new Lr_AnsAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}