package com.example.moyenne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReussiActivity extends AppCompatActivity {

    private TextView tv;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussi);
        //btn_back = (Button) findViewById(R.id.Back);

        tv = (TextView) findViewById(R.id.textView);
        Intent j = getIntent();

        float m = j.getFloatExtra("moyenne", 0);

        //  String msg = "Félicitations, vous avez réussi avec une moyenne de " + m;
        msg = getString(R.string.reussit, m);
        //Toast.makeText(getApplicationContext(), "moyenne " + m, Toast.LENGTH_SHORT).show();

        tv.setText(msg);

    }

    public void SendSMS(View v)
    {
        EditText editText = findViewById(R.id.editText);

        String telnumber = String.format("tel:%s", editText.getText().toString());

        if (telnumber.isEmpty() || editText.getText().toString().length() < 8) {
            // toast message to enter a valid number
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
        } else {
            Intent i1 = new Intent();
            i1.setAction(Intent.ACTION_DIAL);
            i1.setData(Uri.parse(telnumber));
        }

        String smsnumber = String.format("smsto: %s", editText.getText().toString());
        if (smsnumber.isEmpty() || editText.getText().toString().length() < 8) {
            // toast message to enter a valid number
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
        } else {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_SENDTO);

            Uri uri = Uri.parse(smsnumber);
            i.setData(uri);

            i.putExtra("sms_body", msg);
            startActivity(i);
        }
    }
}