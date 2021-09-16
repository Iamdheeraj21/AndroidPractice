package com.example.linkify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Text_checker extends AppCompatActivity {

    EditText editText;
    Button buttonButton;
    TextView text;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_checker);
        editText = findViewById(R.id.editextChecker);
        buttonButton = findViewById(R.id.checkText);
        text=findViewById(R.id.checkerResult);

//        buttonButton.setOnClickListener(v->{
//            String username=editText.getText().toString();
//            if(username.equals("")){
//                editText.setError("Enter the username!");
//            }
//            if(username.matches(UserValaidator.expression)){
//                text.setTextColor(Color.GREEN);
//                text.setText("Valid Username!");
//            }
//            if(!username.matches(UserValaidator.expression)){
//                text.setTextColor(Color.RED);
//                text.setText("InValid Username!");
//            }
//        });
//
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged (CharSequence s, int start, int before, int count) {
                String username=editText.getText().toString();
                if(username.equals("")){
                    editText.setError("Enter the username!");
                }
                if(username.matches(UserValaidator.expression)){
                    text.setTextColor(Color.GREEN);
                    text.setText("Valid Username!");
                }
                if(!username.matches(UserValaidator.expression)){
                    text.setTextColor(Color.RED);
                    text.setText("InValid Username!");
                }
            }

            @Override
            public void afterTextChanged (Editable s) {

            }
        });
    }
}

class UserValaidator{
    public static final String expression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
}