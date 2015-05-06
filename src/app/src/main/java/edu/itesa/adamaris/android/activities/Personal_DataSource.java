package edu.itesa.adamaris.android.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import edu.itesa.adamaris.android.R;


public class Personal_DataSource {

    public static List<Personal> PERSONAL = new ArrayList<Personal>();

    static {

        PERSONAL.add(new Personal("Dia del trabajador","Miercoles 20", R.drawable.ic_health));
        PERSONAL.add(new Personal("Reunion de maestros", "Juevez 21", R.drawable.ic_carreer));
        PERSONAL.add(new Personal("Aula abierta", "Viernes 22",R.drawable.ic_money));
        PERSONAL.add(new Personal("Dia de colores", "Lunes 25",R.drawable.ic_carreer));
    }

    public static List<Personal> PRUEBA = new ArrayList<Personal>();

    static {

        PRUEBA.add(new Personal("Desayunar pan con queso","08:00", R.drawable.ic_health));
        PRUEBA.add(new Personal("Hacer la tarea", "10:00", R.drawable.ic_carreer));
        PRUEBA.add(new Personal("Estudiar programacion", "10:30",R.drawable.ic_money));
        PRUEBA.add(new Personal("Comer en casa", "15:45",R.drawable.ic_carreer));
        PRUEBA.add(new Personal("Asegurar la venta", "18:00",R.drawable.ic_money));
    }

    public static List<Personal> Escolar = new ArrayList<>();
     static {

         Escolar.add(new Personal("Dia de la Virgen","Lunes 13", R.drawable.ic_health));
         Escolar.add(new Personal("Aula abierta", "Martes 20", R.drawable.ic_carreer));
         Escolar.add(new Personal("Entrega de calificaciones", "Miercoles 21",R.drawable.ic_money));
         Escolar.add(new Personal("No hay docencia", "Jueves 25",R.drawable.ic_carreer));
         Escolar.add(new Personal("Clases hasta las 12:00", "Viernes 29",R.drawable.ic_money));

     }
}
