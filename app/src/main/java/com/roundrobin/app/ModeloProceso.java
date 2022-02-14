package com.roundrobin.app;

public class ModeloProceso {
    private String nombre;
    private int peso;
    private int estado;
    private int prioridad;


    public ModeloProceso(String nombre, int peso, int prioridad) {
        this.nombre = nombre;
        this.peso = peso;
        this.estado = 0;
        this.prioridad = prioridad;
    }

    public ModeloProceso(String nombre, int peso, int estado, int prioridad) {
        this.nombre = nombre;
        this.peso = peso;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEstado() {
        String textestado = "";
        if(estado == 0)
            textestado = "espera";
        if(estado == 1)
            textestado = "ejecucion";
        if(estado == 2)
            textestado = "terminado";
        return textestado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "ModeloProceso{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
