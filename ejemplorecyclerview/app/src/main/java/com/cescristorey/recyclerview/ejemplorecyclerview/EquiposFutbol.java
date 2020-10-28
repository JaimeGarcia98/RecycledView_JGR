package com.cescristorey.recyclerview.ejemplorecyclerview;

/**
 * Created by Luis on 23/10/2017.
 */

public class EquiposFutbol {

    private String nombre_equipo;
    private String campo;
    private String entrenador;

    public EquiposFutbol(String nombre_equipo, String campo, String entrenador) {
        this.nombre_equipo = nombre_equipo;
        this.campo = campo;
        this.entrenador = entrenador;

    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

}
