package fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import org.lrhsd.storm.user16.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EndFragment extends Fragment {

    public static View view;
    public EndFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_end, container, false);

        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");

        CheckBox ramp = (CheckBox)view.findViewById(R.id.ramp),
                scale = (CheckBox)view.findViewById(R.id.scale),
                cap = (CheckBox)view.findViewById(R.id.cap);
        ramp.setTypeface(gill);
        scale.setTypeface(gill);
        cap.setTypeface(gill);
        return view;
    }

}
