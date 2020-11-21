package com.example.personas;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersona extends BaseAdapter {
    private Context contexto;
    private ArrayList<Persona> personas;
    private Resources res;


    public AdaptadorPersona(Context contexto, ArrayList<Persona> personas){
        this.contexto = contexto;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Definir las variables a usar
        res = contexto.getResources();
        View v = convertView;

        //Crear el objeto LayoutInflater para modificar la vista
        LayoutInflater inf = (LayoutInflater) contexto.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inf.inflate(R.layout.item_persona,null);

        //captura los elementos de la vista
        ImageView foto = v.findViewById(R.id.imgFoto);
        TextView cedula = v.findViewById(R.id.lblCedulaP);
        TextView nombre = v.findViewById(R.id.lblNombreP);
        TextView apellido = v.findViewById(R.id.lblApellidoP);

        //creamos un objeto persona
        Persona p = personas.get(position);

        //setear los elementos de la vista
        foto.setImageDrawable(res.getDrawable(p.getFoto()));
        cedula.setText(p.getCedula());
        nombre.setText(p.getNombre());
        apellido.setText(p.getApellido());


        return v;
    }
}
