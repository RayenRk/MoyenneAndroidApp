package com.example.moyenne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculerMoyenne(View view) {
        EditText note1 = findViewById(R.id.editNote1);
        EditText note2 = findViewById(R.id.editNote2);
        EditText note3 = findViewById(R.id.editNote3);
        EditText coef1 = findViewById(R.id.editCoef1);
        EditText coef2 = findViewById(R.id.editCoef2);
        EditText coef3 = findViewById(R.id.editCoef3);
        // TextView moyenne = findViewById(R.id.moyenne);

        if (       note1.getText().toString().isEmpty()
                || note2.getText().toString().isEmpty()
                || note3.getText().toString().isEmpty()
                || coef1.getText().toString().isEmpty()
                || coef2.getText().toString().isEmpty()
                || coef3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter all the values", Toast.LENGTH_SHORT).show();

            return;
        }

        double n1 = Double.parseDouble(note1.getText().toString());
        double n2 = Double.parseDouble(note2.getText().toString());
        double n3 = Double.parseDouble(note3.getText().toString());
        double c1 = Double.parseDouble(coef1.getText().toString());
        double c2 = Double.parseDouble(coef2.getText().toString());
        double c3 = Double.parseDouble(coef3.getText().toString());

        if (n1 < 0 || n1 > 20 || n2 < 0 || n2 > 20 || n3 < 0 || n3 > 20) {
            // moyenne.setText("Veuillez entrer des notes valides");
            Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show();
        }

        if (c1 > 3 || c1 <= 0 || c2 > 3 || c2 <= 0 || c3 <= 0  || c3 > 3) {
            // moyenne.setText("Veuillez entrer des coefficients valides");
            Toast.makeText(this, "Please enter valid coefficients", Toast.LENGTH_SHORT).show();
        }

        double moy = (n1 * c1 + n2 * c2 + n3 * c3) / (c1 + c2 + c3);
        // moyenne.setText("Moyenne: " + moy);

        if (moy >= 10) {
            Intent success = new Intent(this, ReussiActivity.class);
            success.putExtra("s", moy);
            startActivity(success);
        } else {
            Intent fail = new Intent(this, EchecActivity.class);
            fail.putExtra("f", moy);
            startActivity(fail);
        }
    }
}