package Principle_Comp_Analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dmdw1.R;

public class PCA_Firstpage extends AppCompatActivity {
    EditText ni;
    Button nxtibt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage2);

        ni=findViewById(R.id.nitext);
        nxtibt=findViewById(R.id.nxitbt);

        nxtibt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInputActivity2();
            }
        });
    }

    public void openInputActivity2(){
        Intent intent =new Intent(PCA_Firstpage.this, PCA_Input.class);
        int num=Integer.parseInt(ni.getText().toString());
        intent.putExtra("ni1",num);
        startActivity(intent);
    }
}