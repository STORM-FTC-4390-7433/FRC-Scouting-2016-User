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
import android.widget.CompoundButton;
import android.widget.RadioButton;
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


        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");

        final RadioButton red = (RadioButton)view.findViewById(R.id.radRed),
                org = (RadioButton)view.findViewById(R.id.radOrg);

        red.setButtonDrawable(R.drawable.chkbox_off);
        org.setButtonDrawable(R.drawable.chkbox_off);

        red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (red.isChecked()) {
                    red.setBackgroundResource(R.drawable.red_chk);
                } else {
                    red.setBackgroundResource(R.drawable.red_reg);
                }
            }
        });
        org.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (org.isChecked()) {
                    org.setBackgroundResource(R.drawable.orange_chk);
                } else {
                    org.setBackgroundResource(R.drawable.orange_reg);
                }
            }
        });

        CheckBox autoHigh = (CheckBox)view.findViewById(R.id.chkAutoHigh),
        autoLow = (CheckBox)view.findViewById(R.id.chkAutoLow);
        

        autoHigh.setTypeface(gill);
        autoLow.setTypeface(gill);
        return view;
    }



}
