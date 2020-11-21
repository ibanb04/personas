package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class CrearPersona extends AppCompatActivity {
   private EditText cedula, nombre, apellido;
   private  int fotos[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        cedula = findViewById(R.id.idCedula);
        nombre = findViewById(R.id.idNombre);
        apellido = findViewById(R.id.idApellido);

        fotos = new  int[3];
        fotos[0] = R.drawable.images;
        fotos[1] = R.drawable.images2;
        fotos[2] = R.drawable.images3;
    }

    public void guardar(View v){
        String ced, nom, apell;
        Persona p;
        if (validar()) {
            ced = cedula.getText().toString();
            nom = nombre.getText().toString();
            apell = apellido.getText().toString();
            p = new Persona(ced, nom, apell,fotoAleatoria());
            p.guardar();
            Toast.makeText(this, R.string.mensaje_guardado_exitosamente,
                    Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    public void limpiar(View v){
        limpiar();
    }

    public int fotoAleatoria(){
        int posFotoSel;
        Random r = new Random();
        posFotoSel = r.nextInt(fotos.length);
        return fotos[posFotoSel];

    }

    public boolean validar(){
        if(cedula.getText().toString().isEmpty()){
            cedula.setError(getString(R.string.mensaje_error_cedula));
            return  false;
        }
        if(nombre.getText().toString().isEmpty()){
            nombre.setError(getString(R.string.mensaje_error_nombre));
            return  false;
        }
        if(apellido.getText().toString().isEmpty()){
            apellido.setError(getString(R.string.mensaje_error_apellido));
            return  false;
        }

        return true;
    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        nombre.requestFocus();
    }
}
