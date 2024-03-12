package com.example.calculator_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eD1;
    Button plus, minus,mult,div,AC,equal,credirs;
    float num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eD1 = findViewById(R.id.eD1);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);
        AC = findViewById(R.id.AC);
        equal = findViewById(R.id.equal);
        credirs = findViewById(R.id.credirs);



    }

    public void lol(View view)
    {
        String st = eD1.getText().toString();
        if(!st.isEmpty())
        {
            num1 = Integer.parseInt(st);

        }
        else
        {
            Toast.makeText(this, "You Need To Enter a Number", Toast.LENGTH_SHORT).show();
        }
    }
}