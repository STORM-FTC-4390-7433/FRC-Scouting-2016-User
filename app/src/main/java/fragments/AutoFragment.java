package fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import org.lrhsd.storm.user16.R;

import java.util.ArrayList;
import java.util.Arrays;

import adapters.CustomArrayAdapter;

public class AutoFragment extends Fragment {
    public static View view;
    public AutoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_auto, container, false);
        Spinner spinner = (Spinner)view.findViewById(R.id.spinAuto);
        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.autoDefenses, R.layout.spinner_item);
        adapt.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapt);

        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");
        
        CheckBox port = (CheckBox)view.findViewById(R.id.chkPort),
                cdf = (CheckBox)view.findViewById(R.id.chkCdf),
                rt = (CheckBox)view.findViewById(R.id.chkRt),
                rw = (CheckBox)view.findViewById(R.id.chkRw),
                db = (CheckBox)view.findViewById(R.id.chkDb),
                sp = (CheckBox)view.findViewById(R.id.chkSp),
                mt = (CheckBox)view.findViewById(R.id.chkMt),
                rmp = (CheckBox)view.findViewById(R.id.chkRmp),
                lb = (CheckBox)view.findViewById(R.id.chkLb),
        autoDef = (CheckBox)view.findViewById(R.id.chkAutoDef),
        autoHigh = (CheckBox)view.findViewById(R.id.chkAutoHigh),
        autoLow = (CheckBox)view.findViewById(R.id.chkAutoLow);
        
        TextView start = (TextView)view.findViewById(R.id.txtStart),
                 cross = (TextView)view.findViewById(R.id.txtCross);
        
        port.setTypeface(gill);
        cdf.setTypeface(gill);
        rt.setTypeface(gill);
        rw.setTypeface(gill);
        db.setTypeface(gill);
        sp.setTypeface(gill);
        mt.setTypeface(gill);
        rmp.setTypeface(gill);
        lb.setTypeface(gill);
        autoDef.setTypeface(gill);
        autoHigh.setTypeface(gill);
        autoLow.setTypeface(gill);
        start.setTypeface(gill);
        cross.setTypeface(gill);
        return view;
    }



}
