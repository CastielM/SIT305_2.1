package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    Button convertButton;
    TextInputLayout inputUnits;
    TextInputEditText inputUnitsText;
    TextView resultText;
    TextView aboveConvertFromText;
    TextView aboveConvertToText;
    Spinner convertFrom;
    Spinner convertTo;
    EditText inputUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertButton = findViewById(R.id.convertButton);
        inputUnit = findViewById(R.id.inputUnit);
        resultText = findViewById(R.id.resultText);
        aboveConvertFromText = findViewById(R.id.aboveConvertFromText);
        aboveConvertToText = findViewById(R.id.aboveConvertToText);
        convertFrom = findViewById(R.id.convertFrom);
        convertTo = findViewById(R.id.convertTo);

        convertButton.setText("Convert!");



        convertButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (inputUnit.getText().toString().length() == 0)
                {
                   Toast.makeText(MainActivity.this , "Must enter a value to convert", Toast.LENGTH_LONG).show();
                }
                else
                {
                    int unit = Integer.parseInt(inputUnit.getText().toString());
                    unit = unit * 3;
                    resultText.setText(String.valueOf(unit));
                }
            }
        });


    }


}
