package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis on 23/10/2017.
 */

public class EquiposAdapter
        extends RecyclerView.Adapter<EquiposAdapter.EquiposFutbolViewHolder> {

    /*Arraylist donde almaceno los datos que se van a mostrar en el RecylerView*/
    private ArrayList<EquiposFutbol> datos;
    /*Defino listener como objeto de la clase OnItemClickListener*/
    private final OnItemClickListener listener;

    /* Defino un interface con el OnItemClickListener*/
    public interface OnItemClickListener {
        void onItemClick(EquiposFutbol item);
    }

    /* Incluyo el Viewholder en el Adapter */
    public static class EquiposFutbolViewHolder
            extends RecyclerView.ViewHolder {
        /* Como atributos se incluyen los elementos que van a referenciar a los elementos de la vista*/
        private TextView tvNombre;
        private TextView tvCampo;
        private TextView tvEntrenador;

        /*constructor con parámetro de la vista*/
        public EquiposFutbolViewHolder(View itemView) {
            super(itemView);
            // Asocia los atributos a los widgets del layout de la vista
            tvNombre = (TextView)itemView.findViewById(R.id.tvNomeq);
            tvCampo = (TextView)itemView.findViewById(R.id.tvCamp);
            tvEntrenador = (TextView)itemView.findViewById(R.id.tvEntrenador);
        }

        /*Muestra los datos de equipo en el item*/
        public void bindEquipos(final EquiposFutbol equiposFutbol, final OnItemClickListener listener) {
            tvNombre.setText(equiposFutbol.getNombre_equipo());
            tvCampo.setText(equiposFutbol.getCampo());;
            tvEntrenador.setText(equiposFutbol.getEntrenador());
            /* Coloco el listener a la vista*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(equiposFutbol);
                }
            });
        }
    }


    /* Constructor con parámetros*/
    public EquiposAdapter(ArrayList<EquiposFutbol> datos, OnItemClickListener listener) {

        this.datos = datos;
        this.listener = listener;

    }

    @Override
    public EquiposFutbolViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        /*Crea la vista de un item y la "pinta"*/
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_equipos, viewGroup, false);
        /* Crea un objeto de la clase CocheViewHolder, pasándole la vista anteriormente creada*/
        EquiposFutbolViewHolder futbolVH = new EquiposFutbolViewHolder(itemView);
        /* devuelve la vissta*/
        return futbolVH;
    }

    @Override
    public void onBindViewHolder(EquiposFutbolViewHolder viewHolder, int pos) {
        EquiposFutbol equiposFutbol = datos.get(pos);
        /* Llama a bindEquipos, para que "pinte" los datos del equipo que se le pasa como parámetro*/
        viewHolder.bindEquipos(equiposFutbol, listener);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
