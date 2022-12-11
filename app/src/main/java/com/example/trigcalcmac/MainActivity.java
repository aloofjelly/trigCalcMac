package com.example.trigcalcmac;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // start of code

    //factorial
    static double factorial(double f){
        double fac=1;
        for (int i=2;i<=f;i++)
            fac*=i;
        return fac;
    }

    //finding the cos value by maclaurins's series
    static double cosMac(double inp) {
        inp*=0.0174533;
        double mac=0;
        for (int i=1;i<11;i++){
            if (i%2!=0)
                mac=mac+(Math.pow(inp,(i*2))/(factorial(i*2)));
        }

        return (1-mac);
    }

    // finding sin from cos value
    static double sinValue(double inp) {
        double c=cosMac(inp);
        return Math.pow((1-(c*c)),0.5);
    }

    // finding tan from sin and cos value
    static double tanValue(double inp) {
        return sinValue(inp)/cosMac(inp);
    }

    public void cos (View view){
        TextView resultTxt = findViewById(R.id.resultTxt);
        EditText inputVal = findViewById(R.id.inputVal);
        Double.parseDouble(inputVal.getText().toString());
        double x= cosMac(Double.parseDouble(inputVal.getText().toString()));
        resultTxt.setText(String.valueOf(x));

    }
    public void sin (View view){
        TextView resultTxt = findViewById(R.id.resultTxt);
        EditText inputVal = findViewById(R.id.inputVal);
        Double.parseDouble(inputVal.getText().toString());
        double x= sinValue(Double.parseDouble(inputVal.getText().toString()));
        resultTxt.setText(String.valueOf(x));

    }

    public void tan (View view){
        TextView resultTxt = findViewById(R.id.resultTxt);
        EditText inputVal = findViewById(R.id.inputVal);
        Double.parseDouble(inputVal.getText().toString());
        double x= tanValue(Double.parseDouble(inputVal.getText().toString()));
        resultTxt.setText(String.valueOf(x));

    }

}