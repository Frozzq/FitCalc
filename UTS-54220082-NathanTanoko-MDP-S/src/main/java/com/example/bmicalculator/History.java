package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import com.example.bmicalculator.DatabaseHelper;

public class History extends AppCompatActivity {
    TextView tvIMTResult;
    public void goBackToMainActivity(View view) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tvIMTResult = findViewById(R.id.tvIMTResult);
        displayIMTResults();
    }

    public void displayIMTResults() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Cursor cursor = dbHelper.getIMTResults();

        if (cursor.moveToFirst()) {
            StringBuilder results = new StringBuilder();
            int count = 1;
            int columnIndex = cursor.getColumnIndex("IMT_RESULT");
            do {
                float imtResult = cursor.getFloat(columnIndex);
                results.append(count).append(". Hasil IMT Anda: ").append(imtResult).append("\n");
                count++;
            } while (cursor.moveToNext());

            tvIMTResult.setText(results.toString());
        } else {
            tvIMTResult.setText("Tidak ada data riwayat IMT.");
        }

        cursor.close();
    }
}