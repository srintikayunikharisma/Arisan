package com.example.finalarisan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btnsimpan;
    EditText nama, iuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        database = new Database(this );
        nama = findViewById(R.id.editnama);
        iuran = findViewById(R.id.editiuran);
        btnsimpan = findViewById(R.id.btnsimpan);

        SQLiteDatabase db =database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM arisan WHERE nama = '" +
                getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount() >0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0).toString());
            iuran.setText(cursor.getString(1).toString());
        }

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("update arisan set nama='" +
                        nama.getText().toString() +"', iuran= '" +
                        iuran.getText().toString() +"' where nama = '" +
                        getIntent().getStringExtra("nama")+"'");
                        Toast.makeText(EditActivity.this, "Data berhasil di edit", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}