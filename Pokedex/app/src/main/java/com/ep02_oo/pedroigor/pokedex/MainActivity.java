package com.ep02_oo.pedroigor.pokedex;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    public Button types;
    public Button nomes;
    public static TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        types = findViewById(R.id.types);
        text = findViewById(R.id.textView);
        nomes = findViewById(R.id.nomes);
        types.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                String urlApi = "https://pokeapi.co/api/v2/type/";
                task.execute(urlApi);
            }
        });
        nomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                String urlApi = "https://pokeapi.co/api/v2/pokemon/";
                task.execute(urlApi);
            }
        });
    }
}

