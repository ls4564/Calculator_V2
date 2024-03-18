
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
    float num1,num2,ans;
    byte sign;// 1 = + , 2 = - , 3 = * , 4 = /
    boolean fplus,fminus,fmult,fdiv;
    boolean cplus, cminus,cmult,cdiv;
    char c1;

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

    }

    public void plus(View view)
    {

        sign = 1;
        String st = eD1.getText().toString();
        if(!st.isEmpty())
        {
            if(fplus)
            {
                //1+2 =3+1

                num2 = Integer.parseInt(st);
                ans = ans +num2 + num1;
                num1 = 0;
                eD1.setHint(ans+"");
            }
            else
            {
                num1 = Integer.parseInt(st);
            }
            eD1.setText("");


        }
        fplus = true;

    }

    public void minus(View view)
    {
        sign = 2;
        String st = eD1.getText().toString();
        if(!st.isEmpty())
        {
            if(fminus)
            {
                //1-2 = -1

                num2 = Integer.parseInt(st);
                ans = ans + num1 - num2 ;
                num1 = 0;
                eD1.setHint(ans+"");
            }
            else
            {
                num1 = Integer.parseInt(st);
            }
            eD1.setText("");


        }
        fminus = true;

    }

    public void mult(View view)
    {
        sign = 3;
        String st = eD1.getText().toString();
        if(!st.isEmpty())
        {
            if(ans == 0)
            {
                ans = 1;
            }if(num1 == 0)
            {
                num1 = 1;
             }
            if(fmult)
            {
                //1*2 = 2
                num2 = Integer.parseInt(st);
                ans = ans * num1 * num2 ;
                num1 = 1;
                eD1.setHint(ans+"");
            }
            else
            {
                num1 = Integer.parseInt(st);
            }
            eD1.setText("");


        }
        fmult = true;

    }

    public void div(View view)
    {
        sign = 4;
        String st = eD1.getText().toString();
        if(!st.isEmpty())
        {
            num1 = Integer.parseInt(st);
            eD1.setText("");

        }
    }

    public void equal(View view)
    {
        String st = eD1.getText().toString();
        if(!st.isEmpty())
        {
            num2 = Integer.parseInt(st);
            if(sign != 0)
            {
                switch (sign)
                {
                    case 1:
                        ans = ans + num1 + num2;
                        sign = 0;
                        break;
                    case 2:
                        ans = ans - num1 - num2;
                        sign = 0;
                        break;
                    case 3:
                        ans = ans * num1 * num2;
                        sign = 0;
                        break;
                    case 4:
                        num1 = num1 / num2;
                        break;

                }
                num2 = 0;
                eD1.setText("");
                eD1.setHint(ans+" ");
            }
            else
            {

            }

        }
        else
        {
            Toast.makeText(this, "You Need To Enter a Number", Toast.LENGTH_SHORT).show();
        }
    }

    public void AC(View view)
    {
        num1 = 0;
        num2 = 0;
        ans = 0;
        sign = 0;
        eD1.setText("");
        eD1.setHint("");

    }
}