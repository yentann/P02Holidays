package com.example.sgholidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listViewSecular;
    TextView textViewSecular;
    ArrayAdapter aa;
    ArrayList<Module> modules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewSecular = (TextView) findViewById(R.id.textViewSecular);
        listViewSecular = (ListView) this.findViewById(R.id.listViewSecular);

        // Create a few food objects in Food array
        Intent i = getIntent();
        int selected = i.getIntExtra("selected",0);
        modules = new ArrayList<Module>();

        if(selected == 1) {
            modules = new ArrayList<Module>();
            modules.add(new Module("New Year's Day", "1 Jan 2017"));
            modules.add(new Module("Labour Day", "1 May 2017"));
            aa = new ModuleAdapter(this, R.layout.row, modules);
            listViewSecular.setAdapter(aa);
        }
        //else {
          //  modules = new ArrayList<Module>();
           // modules.add(new Module("Chinese New Year", "28-29 Jan 2017"));
           // modules.add(new Module("Good Friday", "14 April 2017"));
           // aa = new ModuleAdapter(this, R.layout.row, modules);
            //listViewSecular.setAdapter(aa);
        //}

        //Toast of IvFood ListView
        listViewSecular.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedFood = modules.get(position);

                Toast.makeText(Main2Activity.this, selectedFood.getYear() + selectedFood.getSr() , Toast.LENGTH_LONG).show();
            }
        });


    }
}
