package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.lrhsd.storm.user16.R;


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
        spin1.setAdapter(adapt);
        spin2.setAdapter(adapt);
        spin3.setAdapter(adapt);
        spin4.setAdapter(adapt);
        spin5.setAdapter(adapt);
        return view;
    }

}
