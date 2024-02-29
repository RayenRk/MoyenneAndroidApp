package com.example.moyenne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EchecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echec);
    }

    public void displayMoyenne(View view) {
        Intent intent = getIntent();
        double moy = intent.getDoubleExtra("f", 0);
        TextView moyenne = findViewById(R.id.textView);
        moyenne.setText(getString(R.string.echec, moy));
    }
}