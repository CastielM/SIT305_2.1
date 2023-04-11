package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

                hideKeyboard(v);
                String selectedTo = convertTo.getSelectedItem().toString();
                String selectedFrom = convertFrom.getSelectedItem().toString();

                //checks that input value is not blank
                if (inputUnit.getText().toString().length() == 0)
                {
                   Toast.makeText(MainActivity.this , "Must enter a value to convert", Toast.LENGTH_LONG).show();
                }

                //checks that the selected item for conversion units are not index 0 (aka an invalid hint value)
                else
                if (convertFrom.getSelectedItemPosition() == 0)
                {
                    Toast.makeText(MainActivity.this , "Must choose a unit to convert from", Toast.LENGTH_LONG).show();
                }
                else
                if (convertTo.getSelectedItemPosition() == 0)
                {
                    Toast.makeText(MainActivity.this , "Must choose a unit to convert to", Toast.LENGTH_LONG).show();
                }

                //checks for varying conversion cases
                //this could be separated out into methods, would make it better for calling each other when needed, too much repeated code otherwise
                //could also look at rounding down the decimals
                //generally nicer UI would be good
                else
                if (selectedFrom.equals("Celsius") && selectedTo.equals("Fahrenheit"))
                {
                    double result = Double.parseDouble(inputUnit.getText().toString());
                    result = (result * 1.8) + 32;
                    resultText.setText("Result: " + String.valueOf(result) + "F");
                }
                else
                if (selectedFrom.equals("Fahrenheit") && selectedTo.equals("Celsius"))
                {
                    double result = Double.parseDouble(inputUnit.getText().toString());
                    result = (result - 32) / 1.8;
                    resultText.setText("Result: " + String.valueOf(result) + "C");
                }
                else
                if (selectedFrom.equals("Kelvin") && selectedTo.equals("Fahrenheit"))
                {
                    double result = Double.parseDouble(inputUnit.getText().toString());
                    result = ((result - 273.15) * 1.8) + 32;
                    resultText.setText("Result: " + String.valueOf(result) + "F");
                }
                else
                if (selectedFrom.equals("Fahrenheit") && selectedTo.equals("Kelvin"))
                {
                    double result = Double.parseDouble(inputUnit.getText().toString());
                    result = ((result - 32) / 1.8) + 273.15;
                    resultText.setText("Result: " + String.valueOf(result) + "K");
                }
                else
                if (selectedFrom.equals("Kelvin") && selectedTo.equals("Celsius"))
                {
                    double result = Double.parseDouble(inputUnit.getText().toString());
                    result = result - 273.15;
                    resultText.setText("Result: " + String.valueOf(result) + "C");
                }
                else
                if (selectedFrom.equals("Celsius") && selectedTo.equals("Kelvin"))
                {
                    double result = Double.parseDouble(inputUnit.getText().toString());
                    result = result + 273.15;
                    resultText.setText("Result: " + String.valueOf(result) + "K");
                }

                //if none of the above cases, through an error, at the moment should throw if you choose to convert to the same unit
                else
                {
                    Toast.makeText(MainActivity.this , "Something went wrong", Toast.LENGTH_LONG).show();
                }

            }


        });




    }

    //method to hide keyboard
    public void hideKeyboard(View view) {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch(Exception ignored) {
        }
    }


}
