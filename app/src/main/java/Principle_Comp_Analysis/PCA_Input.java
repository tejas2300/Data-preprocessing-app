package Principle_Comp_Analysis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmdw1.InputAdapter;
import com.example.dmdw1.InputModel;
import com.example.dmdw1.R;

import java.util.ArrayList;

public class PCA_Input extends AppCompatActivity {


    private Button btni;
    private RecyclerView recyclerViewi;
    private InputAdapter input2Adapter;
    public ArrayList<InputModel> input2ModelArrayList;
    public TextView srnoi;
    private TextView textViewati1,textViewati2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input2);
        recyclerViewi = (RecyclerView) findViewById(R.id.rv);
        btni = (Button) findViewById(R.id.btn);
        srnoi=findViewById(R.id.textViewxy);
        textViewati1=findViewById(R.id.atbt1);
        textViewati2=findViewById(R.id.atbt2);

        final int k1= getIntent().getIntExtra("ni1",0);



        input2ModelArrayList = populateList2(k1);
        input2Adapter = new InputAdapter(this,input2ModelArrayList);
        recyclerViewi.setAdapter(input2Adapter);
        recyclerViewi.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent (PCA_Input.this, PCA_AnswerTable.class);
                final String atr1 = textViewati1.getText().toString().trim();
                final String atr2 = textViewati2.getText().toString().trim();

                if (TextUtils.isEmpty(atr1) || TextUtils.isEmpty(atr2)) {
                    Toast.makeText(PCA_Input.this, "Please enter all attributes ", Toast.LENGTH_SHORT).show();
                }
                else {

                    intent2.putExtra("atransi1", atr1);
                    intent2.putExtra("atransi2", atr2);
                    startActivity(intent2);
                }
            }
        });


    }


    private ArrayList<InputModel> populateList2(int k1) {

        ArrayList<InputModel> list = new ArrayList<>();

        for(int i = 0; i <k1; i++){
            list.add(new InputModel(" "," "," "+(i+1)+"."));

        }
        return list;
    }
}