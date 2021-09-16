package com.example.linkify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    MyAdapter mAdapter;
    Button showButton,textCheckerButton;
    ListView listView;
    String[] url={"https://www.yoururl1.com/","https://www.yoururl2.com/",
            "https://www.yoururl3.com/","https://www.yoururl4.com/",
            "https://www.yoururl5.com/","https://www.yoururl6.com/",
            "https://www.yoururl7.com/","https://www.yoururl8.com/",
            "https://www.yoururl9.com/","https://www.yoururl19.com/",};

    String[] emails ={
            "email_1@mail.com","email_2@mail.com",
            "email_3@mail.com","email_4@gmail.com",
            "email_5@mail.com","email_6@mail.com",
            "email_7@mail.com","email_8@mail.com",
            "email_9@gmail.com","email_10@mail.com"
    };

    String[] phoneNumber ={
            "+(1234)-567","+(1234)-567",
            "7563654321","9475000000","8575000000",
            "+1 (919) 555-1212","+91 (919) 555-1212",
            "6463654321","5475000000","8575000000",
    };

    Integer[] imgid={
            R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,
    };
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter=new MyAdapter(this, url, emails,phoneNumber,imgid);
        listView= findViewById(R.id.listview);
        showButton=findViewById(R.id.showButton);
        textCheckerButton=findViewById(R.id.textChecker);

        showButton.setOnClickListener(v->{
            listView.setVisibility(View.VISIBLE);
            showButton.setVisibility(View.GONE);
            textCheckerButton.setVisibility(View.GONE);
        });

        textCheckerButton.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,Text_checker.class).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK
            ));
        });

        listView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart () {
        super.onStart();
        listView.setVisibility(View.GONE);
    }
}