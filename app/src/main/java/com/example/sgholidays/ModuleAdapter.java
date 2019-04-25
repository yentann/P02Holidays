package com.example.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> modules;
    private Context context;
    private TextView textViewNewYear;
    private TextView textViewNewYearDate;
    private ImageView imageViewPop;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        modules = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);


        // Get the TextView object
        textViewNewYear = rowView.findViewById(R.id.textViewNewYear);
        textViewNewYearDate = rowView.findViewById(R.id.textViewNewYearDate);
        // Get the ImageView object
        imageViewPop = rowView.findViewById(R.id.imageViewPop);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Module currentModule = modules.get(position);
        // Set the TextView to show the food

        textViewNewYearDate.setText(currentModule.getYear());
        textViewNewYear.setText(currentModule.getSr());

        // Set the image to star or nostar accordingly
        if(currentModule.getSr() == "New Year's Day!") {
            imageViewPop.setImageResource(R.drawable.newyear);
        }
        else if (currentModule.getSr() == "Labour Day") {
            imageViewPop.setImageResource(R.drawable.labour);
        }
        // Return the nicely done up View to the ListView
        return rowView;


    }
}

