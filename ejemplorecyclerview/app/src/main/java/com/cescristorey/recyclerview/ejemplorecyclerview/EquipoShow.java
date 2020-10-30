package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EquipoShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_show);

        TextView tv_nombre_equi = findViewById(R.id.tv_nom_equipo);
        TextView tv_nombre_cam = findViewById(R.id.tv_nom_campo);
        TextView tv_nombre_en = findViewById(R.id.tv_nom_entrenador);

        //Recupero los datos de la activity que ha invocado a esta activity
        String nombre_eq = getIntent().getStringExtra("nombre_equipo");
        String nombre_camp = getIntent().getStringExtra("nombre_campo");
        String nombre_entre = getIntent().getStringExtra("entrenador");

        tv_nombre_equi.setText(nombre_eq);
        tv_nombre_cam.setText(nombre_camp);
        tv_nombre_en.setText(nombre_entre);

        Button botonatras = findViewById(R.id.boton_atras);
        botonatras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}