package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearPersona extends AppCompatActivity {
   private EditText cedula, nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        cedula = findViewById(R.id.idCedula);
        nombre = findViewById(R.id.idNombre);
        apellido = findViewById(R.id.idApellido);
    }

    public void guardar(View v){
        String ced, nom, apell;
        Persona p;
        ced = cedula.getText().toString();
        nom = nombre.getText().toString();
        apell = apellido.getText().toString();
        p = new Persona(ced,nom,apell);
        p.guardar();
        Toast.makeText(this, R.string.mensaje_guardado_exitosamente,
                Toast.LENGTH_LONG).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }
}
