package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicialización de la lista de datos de ejemplo
        ArrayList<EquiposFutbol> datos = new ArrayList<EquiposFutbol>();
        for(int i=0; i<7; i++) {
            datos.add(new EquiposFutbol("Granada", "Los Cármenes", "Diego Martínez"));
            datos.add(new EquiposFutbol("Real Madrid", "Santiago Bernabeu", "Zinedine Zidane"));
            datos.add(new EquiposFutbol("Barcelona", "Nou Camp", "Ronald Koeman"));
            datos.add(new EquiposFutbol("Betis", "Benito Villamarin", "Manuel Pellegrini"));
            datos.add(new EquiposFutbol("Sevilla", "Sanchez Pizjuan", "Julen Lopetegui"));
            datos.add(new EquiposFutbol("Real Sociedad", "Anoeta", "Adrián García"));
            datos.add(new EquiposFutbol("Valencia", "Mestalla", "Javi Gracia"));
        }
        //Inicialización RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.RecView);
        recyclerView.setHasFixedSize(false);

        //Crea el adaptador, pasándole como parámetro los datos
        final EquiposAdapter adaptador = new EquiposAdapter(datos);

        //Asocia a recylerView el adaptador
        recyclerView.setAdapter(adaptador);

        //Fija un layout linear al recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
