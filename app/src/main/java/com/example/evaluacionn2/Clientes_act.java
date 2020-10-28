package com.example.evaluacionn2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Productos;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);
        spin1 = (Spinner) findViewById(R.id.spnCatalogo);
        tv = (TextView) findViewById(R.id.tv);

        ArrayList<String> ListaCatalogo = (ArrayList<String>) getIntent().getSerializableExtra("ListaCatalogo");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListaCatalogo);

        spin1.setAdapter(adapt);
    }
    public void Mostrar(View v)
    {
        String opcion = spin1.getSelectedItem().toString();
        Productos productos = new Productos();

        if(opcion.equals("Polera Karambit"))
        {
            tv.setText("Has seleccionado Polera Karambit el valor es: "+productos.getValorKarambit());
        }
        if(opcion.equals("Polera Pray"))
        {
            tv.setText("Has seleccionado Polera Pray el valor es: "+productos.getValorPray());
        }
        if(opcion.equals("Polera Los Andes"))
        {
            tv.setText("Has seleccionado Polera Los Andes el valor es: "+productos.getValorAndes());
        }
        if(opcion.equals("Polera Calavera"))
        {
            tv.setText("Has seleccionado Calavera el valor es: "+productos.getValorCalavera());
        }
        if(opcion.equals("Polera Molotov"))
        {
            tv.setText("Has seleccionado Molotov el valor es: "+productos.getValorMolotov());
        }

    }

}