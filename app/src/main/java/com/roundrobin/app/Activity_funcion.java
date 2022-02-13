package com.roundrobin.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Activity_funcion extends AppCompatActivity {

    RecyclerView recyclerview;
    TableAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcion);

        recyclerview = findViewById(R.id.recyclerview);

        setRecyclerView();
    }

    private void setRecyclerView() {

        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TableAdapter(this, getList());
        recyclerview.setAdapter(adapter);

    }

    private List<TableModel> getList(){
        List<TableModel> table_list = new ArrayList<>();
        table_list.add(new TableModel("Spotify", 12,1, 1));
        table_list.add(new TableModel("Facebook", 12,4, 11));
        table_list.add(new TableModel("Whatsapp", 12,5, 14));
        return table_list;
    }

}