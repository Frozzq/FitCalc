package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.ContentValues;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    private RadioButton sudahRadioButton, belumRadioButton;
    private TextView textView1, textView2, textView3, textViewHasilIMT;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sudahRadioButton = findViewById(R.id.sudah);
        belumRadioButton = findViewById(R.id.belum);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        nextButton = findViewById(R.id.next);

        textView1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        textView2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        textView3.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        textView3.setVisibility(View.GONE);

        sudahRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.GONE);
                nextButton.setEnabled(true);
                belumRadioButton.setChecked(false);
            }
        });

        belumRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.VISIBLE);
                nextButton.setEnabled(false);
                sudahRadioButton.setChecked(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sudahRadioButton.isChecked()) {
                    startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                } else {
                    Toast.makeText(MainActivity2.this, "Mohon pilih opsi 'Sudah' terlebih dahulu.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sudahRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.GONE);
                nextButton.setEnabled(true);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
    }
    public void openHistoryActivity(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }
}