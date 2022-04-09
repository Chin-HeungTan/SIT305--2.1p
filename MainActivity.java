package com.ayong.alfredyong.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
//classes units of measurements
public class MainActivity extends AppCompatActivity {

    public enum units {
        METRES,
        CELSIUS,
        KILOGRAMS
    }

    ;

    public units currentUnit;
    public Spinner unitSelectSpinner;
    public EditText input;

    public TextView output1TextView;
    public TextView output2TextView;
    public TextView output3TextView;

    public TextView unit1TextView;
    public TextView unit2TextView;
    public TextView unit3TextView;

    public ImageButton metresButton;
    public ImageButton celsiusButton;
    public ImageButton kilogramsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUnit = units.METRES;
        unitSelectSpinner = findViewById(R.id.unitSelectSpinner);
        input = findViewById(R.id.input);

        metresButton = findViewById(R.id.metresButton);
        celsiusButton = findViewById(R.id.celsiusButton);
        kilogramsButton = findViewById(R.id.kilogramsButton);

        output1TextView = findViewById(R.id.output1TextView);
        output2TextView = findViewById(R.id.output2TextView);
        output3TextView = findViewById(R.id.output3TextView);

        unit1TextView = findViewById(R.id.unit1TextView);
        unit2TextView = findViewById(R.id.unit2TextView);
        unit3TextView = findViewById(R.id.unit3TextView);

        unitSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                currentUnit = units.values()[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    //    user prompts
    @SuppressLint("DefaultLocale")
    public void calculate(View view) {
        if (input.getText().toString().matches("")) {
            Toast.makeText(this, "You must enter a value", Toast.LENGTH_SHORT).show();
        } else if (!view.getTag().toString().equals(currentUnit.name())) {
            Toast.makeText(this, "Enter the correct conversion button", Toast.LENGTH_SHORT).show();
        } else {
//            unit conversion calculations
            DecimalFormat df = new DecimalFormat("#.##");
            switch (view.getTag().toString()) {
                case "CELSIUS":
                    unit1TextView.setText("Fahrenheit");
                    unit2TextView.setText("Kelvin");


                    output1TextView.setText(df.format(Double.parseDouble(input.getText().toString()) * 1.8 + 32));
                    output2TextView.setText(df.format(Double.parseDouble(input.getText().toString()) + 273.15));


                    break;
                case "KILOGRAMS":
                    unit1TextView.setText("Grams");
                    unit2TextView.setText("Ounces");
                    unit3TextView.setText("Pounds");

                    output1TextView.setText(df.format(Double.parseDouble(input.getText().toString()) * 1000));
                    output2TextView.setText(df.format(Double.parseDouble(input.getText().toString()) * 35.274));
                    output3TextView.setText(df.format(Double.parseDouble(input.getText().toString()) * 2.205));

                    break;
                case "METRES":
                    unit1TextView.setText("Centimetres");
                    unit2TextView.setText("Feet");
                    unit3TextView.setText("Inches");

                    output1TextView.setText(df.format(Double.parseDouble(input.getText().toString()) * 100));
                    output2TextView.setText(df.format(Double.parseDouble(input.getText().toString()) * 3.281));
                    output3TextView.setText(df.format(Double.parseDouble(input.getText().toString()) * 39.37));

                    break;
                default:
                    break;
            }
        }
    }
}
