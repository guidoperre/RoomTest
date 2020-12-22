package com.guido.roomtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Repositorio
    private AutoRepository autoRepository;

    private Button insertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instancio repositorio autos
        autoRepository = new AutoRepository(getApplication());
        setUIComponents();
        setObservables();
    }

    //Declaro los componenetes de UI
    private void setUIComponents(){
        insertar = findViewById(R.id.btn_insertar);
    }

    private void setObservables(){
        //Observo la tabla autos
        autoRepository.get().observe(this,this::setAutos);

        //Borton insertar
        insertar.setOnClickListener(view -> {
            Auto auto = new Auto("Gol","Volkswagen",4,116);
            autoRepository.insertAuto(auto);
        });
    }

    //Funcion que se llama al haber cambios en la tabla de autos.
    private void setAutos(List<Auto> autos){
        ArrayList<String> marcas = new ArrayList<>();

        for (Auto auto: autos)
            marcas.add(auto.getMarca());

        Toast.makeText(this, "Me llamaron " + marcas, Toast.LENGTH_SHORT).show();
    }

}