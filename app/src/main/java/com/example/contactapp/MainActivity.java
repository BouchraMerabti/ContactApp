package com.example.contactapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvContact;
    Button btnContact;

    ImageView imPhone, imEmail, imLocal, imEmoji;

    final int CREATE_CONTACT=  1;

    String name = "", phone = "", email = "", location = "", mood = "";



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContact = findViewById(R.id.tvContact);
        btnContact = findViewById(R.id.btnContact);

        imPhone = findViewById(R.id.imPhone);
        imEmail = findViewById(R.id.imEmail);
        imLocal = findViewById(R.id.imaLocal);
        imEmoji = findViewById(R.id.imEmoji);

        imPhone.setVisibility(View.GONE);
        imEmail.setVisibility(View.GONE);
        imLocal.setVisibility(View.GONE);
        imEmoji.setVisibility(View.GONE);






        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, com.example.contactapp.SecondPage.class);
                startActivityForResult(intent, CREATE_CONTACT);

            }
        });

        imPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);


            }
        });

        imEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com" + email));
                startActivity(intent);

            }
        });

        imLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=155 Malmo , Sweden, Europe" + location));
                startActivity(intent);


            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_CONTACT)
        {
            if (resultCode == RESULT_OK)
            {
                imPhone.setVisibility(View.VISIBLE);
                imEmail.setVisibility(View.VISIBLE);
                imLocal.setVisibility(View.VISIBLE);
                imEmoji.setVisibility(View.VISIBLE);


                name = data.getStringExtra("Name");
                phone = data.getStringExtra("Phone");
                email = data.getStringExtra("Email");
                location = data.getStringExtra("Local");
                mood = data.getStringExtra("mood");

                if (mood.equals("smile"))
                {
                    imEmoji.setImageResource(R.drawable.smile);
                } else if (mood.equals("neutral")) {
                    imEmoji.setImageResource(R.drawable.neutral);
                } else {
                    imEmoji.setImageResource(R.drawable.sad);
                }

            } else {
                Toast.makeText(this, "No data passed through", Toast.LENGTH_SHORT).show();
            }
        }
    }
}