package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.lrhsd.storm.user16.R;

import java.util.Arrays;


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
        ArrayAdapter<CharSequence> adapt  = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.defenses, R.layout.spinner_item);
        adapt.setDropDownViewResource(R.layout.spinner_dropdown_item);
        ArrayAdapter<CharSequence> lowbar = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.low, R.layout.spinner_item);
        lowbar.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spin1.setAdapter(adapt);
        spin1.setSelection(1, false);
        spin2.setAdapter(adapt);
        spin2.setSelection(2, false);
        spin3.setAdapter(adapt);
        spin3.setSelection(3, false);
        spin4.setAdapter(adapt);
        spin4.setSelection(4, false);
        spin5.setAdapter(lowbar);
        spin5.setEnabled(false);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin1.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) || spin1.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) ||
                        spin1.getSelectedItem().toString().equals(spin4.getSelectedItem().toString()) || spin1.getSelectedItem().toString().equals(spin5.getSelectedItem().toString())) {
                    Toast.makeText(getActivity().getBaseContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                    if (position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() - 1) {
                        spin1.setSelection(position + 1, false);
                    } else {
                        spin1.setSelection(position - 1);
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
                if (spin2.getSelectedItem().toString().equals(spin1.getSelectedItem().toString()) || spin2.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) ||
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
                if (spin3.getSelectedItem().toString().equals(spin1.getSelectedItem().toString()) || spin3.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) ||
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
                if (spin4.getSelectedItem().toString().equals(spin1.getSelectedItem().toString()) || spin4.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) ||
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
