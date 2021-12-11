package com.roundrobin.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected Button btn_teoria, btn_funcion, btn_creditos ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_teoria=(Button)findViewById(R.id.btn_teoria);
        btn_funcion=(Button)findViewById(R.id.btn_funcion);
        btn_creditos=(Button)findViewById(R.id.btn_creditos);
        btn_teoria.setOnClickListener((View v)->{
            Intent intent= new Intent(v.getContext(),Activity_teoria.class);
            startActivity(intent);
        });
        btn_funcion.setOnClickListener((View v)->{
            Intent intent= new Intent(v.getContext(),Activity_funcion.class);
            startActivity(intent);
        });
        btn_creditos.setOnClickListener((View v)->{
            Intent intent= new Intent(v.getContext(),Activity_creditos.class);
            startActivity(intent);
        });
    }
}