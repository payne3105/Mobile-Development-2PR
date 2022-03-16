package com.example.a2pr_another;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    Spinner spinnerTemp;
    EditText editTextTemp;
    TextView textViewC;
    TextView textViewF;
    TextView textViewK;
    TextView textViewRe;
    TextView textViewR;
    Button buttonCount;

    double valueDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        spinnerView();
    }

    private void findId() {
        spinnerTemp = findViewById(R.id.spinnerTemp);
        editTextTemp = findViewById(R.id.editTextTemp);
        textViewC = findViewById(R.id.textViewC);
        textViewF = findViewById(R.id.textViewF);
        textViewK = findViewById(R.id.textViewK);
        textViewRe = findViewById(R.id.textViewRe);
        textViewR = findViewById(R.id.textViewR);
        buttonCount = findViewById(R.id.buttonCount);
    }

    private void spinnerView() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperature, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemp.setAdapter(adapter);
        spinnerTemp.setOnItemSelectedListener(this);
    }

    @SuppressLint("SetTextI18n")
    public void celsiusTemp() {
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String valueString = editTextTemp.getText().toString().trim(); //15
        valueDouble = Double.parseDouble(valueString); //celsius
        textViewC.setText(valueDouble + "°C");

        double valueCount;
        valueCount = (valueDouble * 1.8) + 32; //F
        textViewF.setText((float)valueCount + "°F");

        valueCount = valueDouble + 273.15; //K
        textViewK.setText((float)valueCount + "°K");

        valueCount = valueDouble * 0.8;
        textViewR.setText((float)valueCount + "°Re"); //Re

        valueCount = valueDouble * 1.8 + 491.67;
        textViewRe.setText((float)valueCount + "°R"); //R
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void fahrenheitTemp() {
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueString = editTextTemp.getText().toString().trim(); //15
                valueDouble = Double.parseDouble(valueString); //fahrenheit
                double valueCount;
                textViewF.setText(valueDouble + "°F"); //F

                double valueCountC = (valueDouble - 32) / 1.8; //C
                textViewC.setText((float)valueCountC + "°C");

                valueCount = valueCountC + 273.15;
                textViewK.setText((float)valueCount + "°K"); //K

                valueCount = valueCountC * 0.8;
                textViewR.setText((float)valueCount + "°Re"); //Re

                valueCount = valueCountC * 1.8 + 491.67;
                textViewRe.setText((float)valueCount + "°R"); //R
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void kelvinTemp() {
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueString = editTextTemp.getText().toString().trim(); //15
                valueDouble = Double.parseDouble(valueString); //kelvin
                double valueCount;
                textViewK.setText(valueDouble + "°K"); //K

                double valueCountC = (valueDouble - 273.15); //C
                textViewC.setText((float)valueCountC + "°C");

                valueCount = (valueCountC * 1.8) + 32;
                textViewF.setText((float)valueCount + "°F"); //F

                valueCount = valueCountC * 0.8;
                textViewR.setText((float)valueCount + "°Re"); //Re

                valueCount = valueCountC * 1.8 + 491.67;
                textViewRe.setText((float)valueCount + "°R"); //R
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void reaumurTemp() {
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueString = editTextTemp.getText().toString().trim(); //15
                valueDouble = Double.parseDouble(valueString); //reaumur
                double valueCount;
                textViewRe.setText(valueDouble + "°Re"); //Re

                double valueCountC = valueDouble * 1.25; //C
                textViewC.setText((float)valueCountC + "°C");

                valueCount = valueCountC + 273.15;
                textViewK.setText((float)valueCount + "°K"); //K

                valueCount = (valueCountC * 1.8) + 32;
                textViewF.setText((float)valueCount + "°F"); //F

                valueCount = valueCountC * 1.8 + 491.67;
                textViewR.setText((float)valueCount + "°R"); //R
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void rankinTemp() {
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueString = editTextTemp.getText().toString().trim(); //15
                valueDouble = Double.parseDouble(valueString); //rankin
                double valueCount;
                textViewR.setText(valueDouble + "°R"); //R

                double valueCountC = (valueDouble - 491.67) * (5.0/9.0); //C
                textViewC.setText((float)valueCountC + "°C");

                valueCount = valueCountC + 273.15;
                textViewK.setText((float)valueCount + "°K"); //K

                valueCount = valueCountC * 0.8;
                textViewRe.setText((float)valueCount + "°Re"); //Re

                valueCount = (valueCountC * 1.8) + 32;
                textViewF.setText((float)valueCount + "°F"); //F
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long length) {
        String text = parent.getItemAtPosition(position).toString();
        if (text.equals("Celsius")) {
            celsiusTemp();
        }
        else if (text.equals("Fahrenheit")) {
            fahrenheitTemp();
        }
        else if (text.equals("Kelvin")) {
            kelvinTemp();
        }
        else if (text.equals("Reaumur")) {
            reaumurTemp();
        }
        else {
            rankinTemp();
        }
//        Toast.makeText(parent.getContext(),text , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}