package adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.lrhsd.storm.user16.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Array adapter made by us to customize the spinners</p>
 * @param <T> - Data set type
 */
public class CustomArrayAdapter<T> extends ArrayAdapter<T> {
    Context ctx;

    /**
     * <p>Constructor for the adapter</p>
     * @param ctx - Context needed
     * @param objects - data set
     */
    public CustomArrayAdapter(Context ctx, List<T> objects) {
        super(ctx, R.layout.spinner_item, objects);
        this.ctx = ctx;
    }

    /**
     * <p>Gets the preview view to edit(not the dropdown look). Auto-Generated by ArrayAdapter<T></p>
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Typeface font = Typeface.createFromAsset(ctx.getAssets(), "Gill Sans.ttf");
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }

    /**
     * <p>Gets the dropdown view view to edit. Auto-Generated by ArrayAdapter<T></p>
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        Typeface gill = Typeface.createFromAsset(ctx.getAssets(), "Gill Sans.ttf");
        TextView text = (TextView) view.findViewById(android.R.id.text1);
        text.setBackgroundColor(Color.BLACK);
        text.setTextColor(Color.WHITE);
        text.setTypeface(gill);


        return view;

    }

}