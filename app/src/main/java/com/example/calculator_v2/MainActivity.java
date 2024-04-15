
package com.example.calculator_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eD1;
    Button plus, minus,mult,div,AC,equal,credirs;
    double ans,num;
    byte sign;// 1 = + , 2 = - , 3 = * , 4 = /
    boolean first;//check if is the first input


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

    public void plus(View view)
    {

        sign = 1;
        String st = eD1.getText().toString();
        if(check_Input(st))
        {
            if(first)
            {
                //1+2 = 3+1

                num = Double.parseDouble(st);
                ans = ans + num;
                eD1.setHint(ans+"");
            }
            else
            {
                ans = Double.parseDouble(st);
            }
            eD1.setText("");


        }
        first = true;

    }

    public void minus(View view)
    {
        sign = 2;
        String st = eD1.getText().toString();
        if(check_Input(st))
        {
            if(first)
            {
                //1-2 = -1

                num = Double.parseDouble(st);
                ans = ans - num;
                eD1.setHint(ans+"");
            }
            else
            {
                ans = Double.parseDouble(st);
            }
            eD1.setText("");


        }
        first = true;

    }

    public void mult(View view)
    {
        sign = 3;
        String st = eD1.getText().toString();
        if(check_Input(st))
        {
            if(first)
            {
                //1*2 = 2
                num = Double.parseDouble(st);
                ans = ans * num ;
                eD1.setHint(ans+"");
            }
            else
            {
                ans = Double.parseDouble(st);
            }
            eD1.setText("");


        }
        first = true;

    }

    public void div(View view)
    {
        sign = 4;
        String st = eD1.getText().toString();
        if(check_Input(st))
        {
            if(first)
            {
                //  1 / 2 = 0.5
                num = Double.parseDouble(st);
                ans = ans / num ;
                eD1.setHint(ans+"");
            }
            else
            {
                ans = Double.parseDouble(st);
            }
            eD1.setText("");


        }
        first = true;

    }

    public void equal(View view)
    {
        String st = eD1.getText().toString();
        if(check_Input(st))
        {
            num = Double.parseDouble(st);
            if(sign != 0)
            {
                switch (sign)
                {
                    case 1:
                        ans = ans + num;
                        sign = 0;
                        break;
                    case 2:
                        ans = ans - num;//ERROR
                        sign = 0;
                        break;
                    case 3:
                        ans = ans * num;
                        sign = 0;
                        break;
                    case 4:
                        ans = ans / num;
                        break;

                }
                num = 0;
                eD1.setText("");
                eD1.setHint(ans+" ");
            }
            else
            {
                Toast.makeText(this, "You Need To Enter a sign", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(this, "You Need To Enter a Number", Toast.LENGTH_SHORT).show();
        }
    }

    public void AC(View view)
    {
        ans = 0;
        num = 0;
        sign = 0;
        first = false;
        eD1.setText("");
        eD1.setHint("Enter Number");
    }


    public void credits_page(View view) {
        Intent si = new Intent(this, credits.class);
        si.putExtra("ans",ans);
        startActivity(si);
    }

    public boolean check_Input(String input)
    {
        if(!input.isEmpty())
        {
            if(input.length() == 1)
            {
                if(input.charAt(0) >= '0' && input.charAt(0) <= '9')
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(input.equals("-.") || input.equals("+."))
                {
                    return false;
                }
                if(input.indexOf('-') != -1 && input.indexOf('+') != -1)
                {
                    if(input.indexOf('-')+1 >= '0' && input.indexOf('-')+1 <= '9')
                    {
                        return true;
                    }
                    else if(input.indexOf('+')+1 >= '0' && input.indexOf('+')+1 <= '9')
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return true;
                }
            }
        }
        return false;
}
}

//eD1.setHint(String.format("%.3f",ans));//if i need
