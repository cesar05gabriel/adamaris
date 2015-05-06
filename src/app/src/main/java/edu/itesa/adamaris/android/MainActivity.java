package edu.itesa.adamaris.android;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.sql.DataSource;

import edu.itesa.adamaris.android.activities.Personal;
import edu.itesa.adamaris.android.activities.PersonalAdapter;
import edu.itesa.adamaris.android.activities.Personal_Agenda;
import edu.itesa.adamaris.android.activities.Personal_DataSource;
import edu.itesa.adamaris.android.activities.School_Agenda;
import edu.itesa.adamaris.android.activities.TableTime;


public class MainActivity extends Activity {

    ListView lista;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView)findViewById(R.id.list);
        adapter = new PersonalAdapter(this, Personal_DataSource.PERSONAL);
        lista.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void mostrar(View view)
    {
        Intent intent = new Intent(this, Personal_Agenda.class);
        startActivity(intent);
    }

    public void show(View view)
    {
        Intent intent = new Intent(this, School_Agenda.class);
        startActivity(intent);
    }

    public void regarde(View view)
    {
        Intent intent = new Intent(this, TableTime.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
