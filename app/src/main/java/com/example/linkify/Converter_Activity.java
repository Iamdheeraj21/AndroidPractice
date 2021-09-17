package com.example.linkify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Converter_Activity extends AppCompatActivity {
    EditText number,result;
    Button convert,clear;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        number=findViewById(R.id.inputNumber);
        result=findViewById(R.id.result);

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged (CharSequence s, int start, int before, int count) {
                String numberText=number.getText().toString();
                if(numberText.equals("")){
                    number.setError("Enter number!");
                }else{
                    int i = Integer.parseInt(numberText);
                    String hexadecimal = Integer.toHexString(i);
                    result.setText(hexadecimal);
                }

            }

            @Override
            public void afterTextChanged (Editable s) {

            }
        });
    }
}