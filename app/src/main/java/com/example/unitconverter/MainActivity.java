package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

        aboveConvertFromText.setText("Convert from:");
        aboveConvertToText.setText("Convert to:");
        convertButton.setText("Convert!");


    }


}
