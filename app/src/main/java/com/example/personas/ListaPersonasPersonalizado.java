package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaPersonasPersonalizado extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Persona> personas;
    private Context context;
    private  AdaptadorPersona adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas_personalizado);

        lista = findViewById(R.id.lstLisrtadoPersonalizado);
        personas =  Datos.obtener();
        adapter = new AdaptadorPersona(this, personas);
        lista.setAdapter(adapter);
    }
}
