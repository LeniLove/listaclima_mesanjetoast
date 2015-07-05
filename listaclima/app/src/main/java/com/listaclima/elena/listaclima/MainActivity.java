package com.listaclima.elena.listaclima;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    ListView listadelclima;
    ArrayList<Datos> listadatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listadelclima= (ListView) findViewById(R.id.Listadelclima);
        listadatos=new ArrayList<Datos>();
        listadatos.add(new Datos(R.drawable.agua, "Lunes", "Tormenta Electrica", "30°c"));
        listadatos.add(new Datos(R.drawable.so,"Martes","Soleado","45°c"));
        listadatos.add(new Datos(R.drawable.nu,"Miercoles","Nublado","33°c"));
        listadatos.add(new Datos(R.drawable.agua,"Jueves","Tormenta Electrica","30°c"));
        listadatos.add(new Datos(R.drawable.so,"Viernes","Soleado","45°c"));
        listadatos.add(new Datos(R.drawable.nu,"Sabado","Nublado","33°c"));
        listadatos.add(new Datos(R.drawable.agua,"Domingo","Tormenta Electrica","30°c"));
        Adaptador adapter = new Adaptador(listadatos,MainActivity.this.getApplicationContext());
        listadelclima.setAdapter(adapter);




        listadelclima.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                 @Override
                                                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                     Datos dia = listadatos.get(position);
                                                     Toast.makeText(getApplicationContext(), "Selecciono: " + dia.getDia(), Toast.LENGTH_LONG).show();

                                                 }


                                             }


        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
