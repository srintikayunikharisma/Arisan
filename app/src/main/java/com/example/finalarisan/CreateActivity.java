  package com.example.finalarisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

  public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btnsimpan;
    EditText nama, iuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new Database(this );
        nama = findViewById(R.id.editnama);
        iuran = findViewById(R.id.editiuran);
        btnsimpan = findViewById(R.id.btnsimpan);
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL(" insert into arisan(nama, iuran) values('"+
                        nama.getText().toString() + "','"  +
                        iuran.getText().toString() + "')");
                Toast.makeText(CreateActivity.this, "Data tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

    }
}