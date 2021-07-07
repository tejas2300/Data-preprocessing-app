package Corelation_coefficient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dmdw1.R;

import java.util.Calendar;

public class Cc_Firstpage extends AppCompatActivity {
    EditText ni,n;
    Button evbtn,nxtbt,noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage1);

        nxtbt=findViewById(R.id.evbtn);
        n=findViewById(R.id.nitext);



        nxtbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInputActivity();
            }
        });

    }

    public void openInputActivity(){
        Intent intent =new Intent(Cc_Firstpage.this, Cc_Input.class);
        int num=Integer.parseInt(n.getText().toString());
        intent.putExtra("n1",num);
        startActivity(intent);
    }
}