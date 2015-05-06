package edu.itesa.adamaris.android.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.itesa.adamaris.android.R;

import static edu.itesa.adamaris.android.R.id;
import static edu.itesa.adamaris.android.R.id.texto1;
import static edu.itesa.adamaris.android.R.id.texto2;


public class PersonalAdapter extends ArrayAdapter<Personal>
{
    public PersonalAdapter(Context context,List<Personal> objects)
    {
        super(context,0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listviewItem = convertView;

        if(null == convertView){
            listviewItem = inflater.inflate(R.layout.personal_view,parent,false);}

        TextView titulo = (TextView)listviewItem.findViewById(texto1);
        TextView subtitulo = (TextView)listviewItem.findViewById(texto2);
        ImageView categoria = (ImageView)listviewItem.findViewById(id.categoria);

        Personal item = getItem(position);

        titulo.setText(item.getNombre());
        subtitulo.setText(item.getHora());
        categoria.setImageResource(item.getCategoria());

        return listviewItem;

    }

}

