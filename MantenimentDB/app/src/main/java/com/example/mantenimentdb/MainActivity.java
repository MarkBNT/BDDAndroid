package com.example.mantenimentdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button BTAlta,BTBaja,BTModifica,BTConsult,BTDesc;
    EditText ETCodigo,ETDesc,ETPrize;

    String Codigo,Descripcion;
    float Prize;

    accesoBD acceso;
    SQLiteDatabase bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTAlta = (Button) findViewById(R.id.BTAlta);
        BTBaja = (Button) findViewById(R.id.BTBaja);
        BTModifica = (Button) findViewById(R.id.BTModifica);
        BTConsult = (Button) findViewById(R.id.BTConsult);
        BTDesc = (Button) findViewById(R.id.BTDesc);

        ETCodigo = (EditText) findViewById(R.id.ETCodigo);
        ETDesc = (EditText) findViewById(R.id.ETDesc);
        ETPrize = (EditText) findViewById(R.id.ETPrice);

        BTAlta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PonMetodos();

                acceso = new accesoBD(MainActivity.this, "productos", null , 1 );

                SQLiteDatabase bd = acceso.getWritableDatabase();

                ContentValues registro = new ContentValues();

                registro.put("codigo", Codigo);
                registro.put("descripcion",Descripcion);
                registro.put("precio",Prize);

                bd.insert("articulos", null , registro);

                bd.close();


            }
        });
        BTBaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        BTDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        BTConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                acceso = new accesoBD(MainActivity.this, "productos", null , 1 );
                bd = acceso.getWritableDatabase();



            }
        });
        BTModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    private void PonMetodos()
    {
        Codigo = ETCodigo.getText().toString();
        Descripcion = ETDesc.getText().toString();
        Prize =Float.parseFloat(ETPrize.getText().toString());
    }

}
