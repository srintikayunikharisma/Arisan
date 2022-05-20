package com.example.finalarisan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btnsimpan;
    TextView nama, iuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this );
        nama = findViewById(R.id.editnama);
        iuran = findViewById(R.id.editiuran);
        btnsimpan = findViewById(R.id.btnsimpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM arisan WHERE nama = '" +
                getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();
        nama.setText(cursor.getString(0).toString());
        iuran.setText(cursor.getString(1).toString());
    }
}