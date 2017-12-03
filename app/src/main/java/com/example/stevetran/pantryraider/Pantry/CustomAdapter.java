package com.example.stevetran.pantryraider.Pantry;

/**
 * Created by rongfalu on 11/30/17.
 */


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.stevetran.pantryraider.Pantry.Ingredients.Ingredient;
import com.example.stevetran.pantryraider.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter{
        ArrayList<Ingredient> modelItems = null;
        Context context;
    public CustomAdapter(Context context, ArrayList<Ingredient> resource) {
        super(context, R.layout.add_row,resource);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.modelItems = resource;
        }
@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.add_row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        name.setText(modelItems.get(position).getName());
        if(modelItems.get(position).getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);
        return convertView;
    }
}
