package com.roundrobin.app;

public class TableModel {
    String nombre;
    int pesoCPU;
    int estado;
    int prioridad;

    public TableModel(String nombre, int pesoCPU, int estado, int prioridad) {
        this.nombre = nombre;
        this.pesoCPU = pesoCPU;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPesoCPU() {
        return pesoCPU;
    }

    public int getEstado() {
        return estado;
    }

    public int getPrioridad() {
        return prioridad;
    }
}
