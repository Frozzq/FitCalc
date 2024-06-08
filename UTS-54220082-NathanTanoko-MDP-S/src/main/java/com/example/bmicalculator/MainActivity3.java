package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.ContentValues;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {
    EditText ediBerat, ediCm;
    Button buttonHitungIMT;
    TextView tvResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ediBerat = findViewById(R.id.ediBerat);
        ediCm = findViewById(R.id.ediCm);
        buttonHitungIMT = findViewById(R.id.buttonHitungIMT);
        tvResult = findViewById(R.id.tvResult);

        buttonHitungIMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sBerat = ediBerat.getText().toString();
                String sCm = ediCm.getText().toString();

                float berat = Float.parseFloat(sBerat);
                float cm = Float.parseFloat(sCm);

                float tinggi = (float) (cm /100);
                float hasilIMT = berat / (tinggi * tinggi);

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity3.this);
                databaseHelper.addIMTResult(hasilIMT);

                tvResult.setText("IMT Dirimu : " + hasilIMT +"" +
                        "\n\nDaftar Katergori IMT :\n" +
                        "Kekurusan    = < 18.5\n" +
                        "Berat Ideal = 18.5 – 24.9\n" +
                        "Kegemukan    = 25 – 29.9\n" +
                        "Obesitas     = ≥ 30");
            }
        });
    }
}