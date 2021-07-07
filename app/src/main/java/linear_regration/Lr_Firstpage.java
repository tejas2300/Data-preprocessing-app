package linear_regration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dmdw1.R;

public class Lr_Firstpage extends AppCompatActivity {
    EditText n_lr;
    Button n_lr_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr_firstpage);
        n_lr=findViewById(R.id.n_lr);
        n_lr_btn=findViewById(R.id.n_lr_btn);

        n_lr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Lr_Firstpage.this, Lr_input.class);
                int num=Integer.parseInt(n_lr.getText().toString());
                intent.putExtra("nlr1",num);
                startActivity(intent);
            }
        });


    }
}