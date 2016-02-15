package fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.lrhsd.storm.user16.R;

import java.util.ArrayList;
import java.util.Arrays;

import adapters.CustomArrayAdapter;


public class DefenseFragment extends Fragment {

   public static View view;
   public static Spinner spin1, spin2, spin3, spin4, spin5;

   public DefenseFragment(){

   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_defense, container, false);
        spin1 = (Spinner)view.findViewById(R.id.spinDef1);
        spin2 = (Spinner)view.findViewById(R.id.spinDef2);
        spin3 = (Spinner)view.findViewById(R.id.spinDef3);
        spin4 = (Spinner)view.findViewById(R.id.spinDef4);
        spin5 = (Spinner)view.findViewById(R.id.spinDef5);

        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");

        CheckBox chkWeak1 = (CheckBox)view.findViewById(R.id.chkWeak1),
        chkWeak2 = (CheckBox)view.findViewById(R.id.chkWeak2),
        chkWeak3 = (CheckBox)view.findViewById(R.id.chkWeak3),
        chkWeak4 = (CheckBox)view.findViewById(R.id.chkWeak4),
        chkWeak5 = (CheckBox)view.findViewById(R.id.chkWeak5);

        Button def1 = (Button)view.findViewById(R.id.def1),
               def2 =  (Button)view.findViewById(R.id.def2),
               def3 = (Button)view.findViewById(R.id.def3),
               def4 = (Button)view.findViewById(R.id.def4),
               def5 = (Button)view.findViewById(R.id.def5),
               def1Sub = (Button)view.findViewById(R.id.def1Sub),
               def2Sub = (Button)view.findViewById(R.id.def2Sub),
               def3Sub = (Button)view.findViewById(R.id.def3Sub),
               def4Sub = (Button)view.findViewById(R.id.def4Sub),
               def5Sub = (Button)view.findViewById(R.id.def5Sub);

        TextView d1 = (TextView)view.findViewById(R.id.txtD1),
                 d2 = (TextView)view.findViewById(R.id.txtD2),
                 d3 = (TextView)view.findViewById(R.id.txtD3),
                 d4 = (TextView)view.findViewById(R.id.txtD4),
                 d5 = (TextView)view.findViewById(R.id.txtD5);
        CustomArrayAdapter<String> lowbar = new CustomArrayAdapter<>(getActivity().getBaseContext(), Arrays.asList(getResources().getStringArray(R.array.low)));

        CustomArrayAdapter<String> adapt = new CustomArrayAdapter<>(getActivity().getBaseContext(), Arrays.asList(getResources().getStringArray(R.array.defenses)));

        spin1.setAdapter(lowbar);
        spin1.setEnabled(false);
        spin2.setAdapter(adapt);
        spin2.setSelection(1, false);
        spin3.setAdapter(adapt);
        spin3.setSelection(2, false);
        spin4.setAdapter(adapt);
        spin4.setSelection(3, false);
        spin5.setAdapter(adapt);
        spin5.setSelection(4, false);

        chkWeak1.setTypeface(gill);
        chkWeak2.setTypeface(gill);
        chkWeak3.setTypeface(gill);
        chkWeak4.setTypeface(gill);
        chkWeak5.setTypeface(gill);

        def1.setTypeface(gill);
        def2.setTypeface(gill);
        def3.setTypeface(gill);
        def4.setTypeface(gill);
        def5.setTypeface(gill);
        def1Sub.setTypeface(gill);
        def2Sub.setTypeface(gill);
        def3Sub.setTypeface(gill);
        def4Sub.setTypeface(gill);
        def5Sub.setTypeface(gill);

        d1.setTypeface(gill);
        d2.setTypeface(gill);
        d3.setTypeface(gill);
        d4.setTypeface(gill);
        d5.setTypeface(gill);


        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin5.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) || spin5.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) ||
                        spin5.getSelectedItem().toString().equals(spin4.getSelectedItem().toString())) {
                    Toast.makeText(getActivity().getBaseContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                    if (position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() - 1) {
                        spin5.setSelection(position + 1, false);
                    } else {
                        spin5.setSelection(position - 1);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin2.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) ||
                        spin2.getSelectedItem().toString().equals(spin4.getSelectedItem().toString()) || spin2.getSelectedItem().toString().equals(spin5.getSelectedItem().toString())) {
                    Toast.makeText(getActivity().getBaseContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                    if ( position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() -1){
                        spin2.setSelection(position + 1, false);
                    }
                    else{
                        spin2.setSelection(position - 1);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin3.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) ||
                        spin3.getSelectedItem().toString().equals(spin4.getSelectedItem().toString()) || spin1.getSelectedItem().toString().equals(spin5.getSelectedItem().toString())) {
                    Toast.makeText(getActivity().getBaseContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                    if ( position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() -1){
                        spin3.setSelection(position + 1, false);
                    }
                    else{
                        spin3.setSelection(position - 1);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin4.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) ||
                        spin4.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) || spin4.getSelectedItem().toString().equals(spin5.getSelectedItem().toString())) {
                    Toast.makeText(getActivity().getBaseContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                    if ( position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() -1){
                        spin4.setSelection(position + 1, false);
                    }
                    else{
                        spin4.setSelection(position - 1);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }


}
