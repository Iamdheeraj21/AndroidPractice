package com.example.linkify;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String>
{
    private final Activity context;
    private final String[] url;
    private final String[] phoneNumber;
    private final String[] email;
    private final Integer[] image;


    public MyAdapter (Activity context, String[] url, String[] phoneNumber, String[] email, Integer[] image) {
        super(context,R.layout.my_list,url);
        this.context = context;
        this.url = url;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.image = image;
    }

    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"})
        View rowView = inflater.inflate(R.layout.my_list, null,true);

        TextView url_title,user_email,phone;
        ImageView imageView;
        url_title=rowView.findViewById(R.id.url);
        user_email=rowView.findViewById(R.id.email);
        phone=rowView.findViewById(R.id.phonenumber);
        imageView=rowView.findViewById(R.id.icon);
        imageView.setImageResource(image[position]);
        url_title.setText(url[position]);
        user_email.setText(email[position]);
        phone.setText(phoneNumber[position]);
        Linkify.addLinks(phone, Linkify.PHONE_NUMBERS);

        return rowView;
    }
}
