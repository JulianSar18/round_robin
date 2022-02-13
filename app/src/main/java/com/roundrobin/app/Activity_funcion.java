package com.roundrobin.app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Activity_funcion extends AppCompatActivity {

    List<TableModel> table_list = new ArrayList<>();
    List<ModeloProceso> procesos = new ArrayList<>();
    int contadorTerminado = 0;
    RecyclerView recyclerview;
    TableAdapter adapter;
    EditText quantum, nombre, peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcion);

        recyclerview = findViewById(R.id.recyclerview);
        quantum = findViewById(R.id.TXTnumberQuantum);
        nombre = findViewById(R.id.TXTtextNombre);
        peso = findViewById(R.id.TXTnumberPeso);


    }


    public void btnIniciar(View view) throws InterruptedException {
        //tomar quatum
        ejecutar();

    }

    public void btnAgregar(View view){
        String nombre = this.nombre.getText().toString();
        int peso = Integer.parseInt(this.peso.getText().toString());
        procesos.add(new ModeloProceso(nombre, peso, procesos.size()));
        dibujarTable(procesos);
    }


    private void ejecutar(){
        new Thread(){
            @Override
            public void run() {
                int quantumP = Integer.parseInt(quantum.getText().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        do {
                            ModeloProceso proceso = procesos.get(0);
                            if (proceso.getPeso() > 0) {
                                procesos.get(0);
                                procesos.get(0).setEstado(1);
                                dibujarTable(procesos);
                                int pesoNew = procesos.get(0).getPeso() - quantumP;
                                procesos.get(0).setPeso(pesoNew);
                                if (procesos.get(0).getPeso() > 0) {
                                    procesos.remove(0);
                                    procesos.add(proceso);
                                } else if (procesos.get(0).getPeso() <= 0) {
                                    procesos.get(0).setPeso(0);
                                    procesos.get(0).setEstado(2);
                                    contadorTerminado++;
                                }
                            }else{
                                procesos.remove(0);
                                procesos.add(proceso);
                            }
                            dibujarTable(procesos);
                        }while(contadorTerminado < procesos.size());
                    }
                });
            }
        }.start();
    }


    private void setRecyclerView() {
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TableAdapter(this, getList());
        recyclerview.setAdapter(adapter);

    }
    private void dibujarTable(List<ModeloProceso> procesos){
        limpiarTable();
        for( ModeloProceso proceso:  procesos) {
            table_list.add(new TableModel(proceso.getNombre(), proceso.getPeso(), proceso.getEstado(), proceso.getPrioridad()));
        }
        setRecyclerView();
    }

    private void limpiarTable(){
        if(table_list.size() > 0)
            table_list.removeAll(table_list);
            setRecyclerView();
    }

    private List<TableModel> getList(){
        return table_list;
    }

}