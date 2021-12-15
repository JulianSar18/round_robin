package com.roundrobin.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_creditos extends AppCompatActivity {
    protected Button btn_inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        btn_inicio=(Button)findViewById(R.id.btn_inicio);
        btn_inicio.setOnClickListener((
                View v)->{
            Intent intent= new Intent(v.getContext(),MainActivity.class);
            startActivity(intent);
        });
    }
}