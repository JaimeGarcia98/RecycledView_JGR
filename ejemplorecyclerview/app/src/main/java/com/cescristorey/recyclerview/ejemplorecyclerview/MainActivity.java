package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicialización de la lista de datos de ejemplo
        ArrayList<EquiposFutbol> datos = new ArrayList<EquiposFutbol>();

            datos.add(new EquiposFutbol("Granada", "Los Cármenes", "Diego Martínez"));
            datos.add(new EquiposFutbol("Real Madrid", "Santiago Bernabeu", "Zinedine Zidane"));
            datos.add(new EquiposFutbol("Barcelona", "Nou Camp", "Ronald Koeman"));
            datos.add(new EquiposFutbol("Betis", "Benito Villamarin", "Manuel Pellegrini"));
            datos.add(new EquiposFutbol("Sevilla", "Sanchez Pizjuan", "Julen Lopetegui"));
            datos.add(new EquiposFutbol("Real Sociedad", "Anoeta", "Adrián García"));
            datos.add(new EquiposFutbol("Valencia", "Mestalla", "Javi Gracia"));
            datos.add(new EquiposFutbol("Atlético de Madrid", "Wanda Metropolitano", "Simeone"));
            datos.add(new EquiposFutbol("Athletic Club", "San Mamés", "Gaizka Garitano"));
            datos.add(new EquiposFutbol("Villareal", "Estadio de la Cerámica", "Unai Emery"));
            datos.add(new EquiposFutbol("Celta de Vigo", "Balaídos", "Óscar García"));
            datos.add(new EquiposFutbol("Getafe", "Coliseum Alfonso Pérez", "José Bordalás"));

        //Inicialización RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.RecView);
        recyclerView.setHasFixedSize(false);

        //Crea el adaptador, pasándole como parámetro los datos
        final EquiposAdapter adaptador = new EquiposAdapter(datos, new EquiposAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(EquiposFutbol equipo) {
                Intent detalles_equipo = new Intent(getApplicationContext(), EquipoShow.class);
                detalles_equipo.putExtra("nombre_equipo", equipo.getNombre_equipo());
                detalles_equipo.putExtra("nombre_campo", equipo.getCampo());
                detalles_equipo.putExtra("entrenador", equipo.getEntrenador());
                startActivity(detalles_equipo);
            }
        });

        //Asocia a recylerView el adaptador
        recyclerView.setAdapter(adaptador);

        //Fija un layout linear al recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //Pone una división entre items
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        // Pone la animación por defecto
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
