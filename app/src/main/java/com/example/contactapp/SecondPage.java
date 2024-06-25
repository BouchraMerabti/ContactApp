package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondPage extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etPhone, etEmail, etLocation;

    ImageView imSmile, imNeutral, imSad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etLocation = findViewById(R.id.etLocation);

        imSmile = findViewById(R.id.imSmile);
        imNeutral = findViewById(R.id.imNeutral);
        imSad = findViewById(R.id.imaSad);

        imSmile.setOnClickListener(this);
        imNeutral.setOnClickListener(this);
        imSad.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty() ||
        etEmail.getText().toString().isEmpty()|| etLocation.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter all fields", Toast.LENGTH_SHORT).show();

        } else
        {
            Intent intent = new Intent();
            intent.putExtra("Name", etName.getText().toString().trim());
            intent.putExtra("Phone", etPhone.getText().toString().trim());
            intent.putExtra("Email", etEmail.getText().toString().trim());
            intent.putExtra("Local", etLocation.getText().toString().trim());

      

            if (view.getId() == R.id.imSmile){
                intent.putExtra("mood", "smile");

            } else if (view.getId() == R.id.imNeutral) {
                intent.putExtra("mood", "neutral");

            } else{

                intent.putExtra("mood", "sad");

            }
            setResult(RESULT_OK, intent);
            SecondPage.this.finish();
        }

    }
}
