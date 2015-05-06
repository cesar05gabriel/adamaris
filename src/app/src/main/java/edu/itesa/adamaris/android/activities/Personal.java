package edu.itesa.adamaris.android.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class Personal {

    private String nombre;
    private String hora;
    private int categoria;

    public Personal(String nombre, String hora, int categoria)
    {
        this.nombre = nombre;
        this.hora = hora;
        this.categoria = categoria;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    public void setCategoria(int categoria) {this.categoria = categoria;}

    public String getNombre(){return nombre;}
    public String getHora(){return hora;}
    public int getCategoria(){return categoria;}

}
