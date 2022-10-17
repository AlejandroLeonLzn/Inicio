package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText edtPassR, edtUsrR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edtPassR=findViewById(R.id.edtPassR);
        edtUsrR=findViewById(R.id.edtUsrR);
    }
    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usu = edtUsrR.getText().toString();
        String pas = edtPassR.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("usuario", usu);
        registro.put("password", pas);
        bd.insert("persona", null, registro);
        bd.close();
        Toast.makeText(this, "Se cargaron los datos del usuario",
                Toast.LENGTH_SHORT).show();
    }

    public void regresar (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}