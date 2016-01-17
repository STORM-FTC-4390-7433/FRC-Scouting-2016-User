package fragments;

import android.content.Context;
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
        return view;
    }



}
