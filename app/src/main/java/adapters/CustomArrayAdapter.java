package adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapter<T> extends ArrayAdapter<T> {
    public CustomArrayAdapter(Context ctx, ArrayList<T> objects) {
        super(ctx, android.R.layout.simple_dropdown_item_1line, objects);
    }

    //other constructors

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView text = (TextView) view.findViewById(android.R.id.text1);
        text.setBackgroundColor(Color.BLACK);
        text.setTextColor(Color.WHITE);//choose your color :)


        return view;

    }

}