package Corelation_coefficient;

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

public class Cc_Input extends AppCompatActivity {

    private Button btn;
    private RecyclerView recyclerView;
    private InputAdapter inputAdapter;
    public ArrayList<InputModel> inputModelArrayList;
    public TextView srno;
    private TextView textViewat1,textViewat2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        btn = (Button) findViewById(R.id.btn);
        srno=findViewById(R.id.textViewsr1);
        textViewat1=findViewById(R.id.atbt1);
        textViewat2=findViewById(R.id.atbt2);
        final int k1= getIntent().getIntExtra("n1",0);

        inputModelArrayList = populateList(k1);
        inputAdapter = new InputAdapter(this,inputModelArrayList);
        recyclerView.setAdapter(inputAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cc_Input.this, Cc_AnswerTable.class);
                final String atr1 = textViewat1.getText().toString().trim();
                final String atr2 = textViewat2.getText().toString().trim();



                if (TextUtils.isEmpty(atr1) || TextUtils.isEmpty(atr2)) {
                    Toast.makeText(Cc_Input.this, "Please enter all attributes ", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("X", atr1);
                    intent.putExtra("Y", atr2);
                    startActivity(intent);
                }


                }
        });


    }

    private ArrayList<InputModel> populateList(int k1) {

        ArrayList<InputModel> list = new ArrayList<>();

        for(int i = 0; i <k1; i++){
            list.add(new InputModel(" "," "," "+(i+1)+"."));

        }
        return list;
    }
}