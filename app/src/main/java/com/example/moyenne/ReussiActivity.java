package com.example.moyenne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReussiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussi);
    }

    public void displayMoyenne(View view) {
        Intent intent = getIntent();
        double moy = intent.getDoubleExtra("s", 0);
        TextView moyenne = findViewById(R.id.textView);
        moyenne.setText(getString(R.string.reussit, moy));
    }
}