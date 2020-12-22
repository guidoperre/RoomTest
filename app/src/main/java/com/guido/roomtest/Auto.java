package com.guido.roomtest;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "auto")
public class Auto {

    //Siempre tiene que haber una primary key
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String nombre = "";

    private String marca = "";

    @ColumnInfo(name = "numero_ruedas")
    private int numeroRuedas = 0;

    @ColumnInfo(name = "caballos_fuerza")
    private int caballosFuerza = 0;

    @ColumnInfo(name = "caballos_fuerza_reales")
    private int caballosFuerzaReales = 0;

    //Esta columna no va a ir en la base de datos
    @Ignore
    private int clicks;

    public Auto(String nombre, String marca, int numeroRuedas, int caballosFuerza) {
        this.nombre = nombre;
        this.marca = marca;
        this.numeroRuedas = numeroRuedas;
        this.caballosFuerza = caballosFuerza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    public int getCaballosFuerza() {
        return caballosFuerza;
    }

    public void setCaballosFuerza(int caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }

    public int getCaballosFuerzaReales() {
        return caballosFuerzaReales;
    }

    public void setCaballosFuerzaReales(int caballosFuerzaReales) {
        this.caballosFuerzaReales = caballosFuerzaReales;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }
}
