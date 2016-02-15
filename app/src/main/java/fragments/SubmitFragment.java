package fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.lrhsd.storm.user16.R;

public class SubmitFragment extends Fragment {
    public static View view;
    public SubmitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_submit, container, false);
        Button submit = (Button)view.findViewById(R.id.submit);
        EditText text = (EditText)view.findViewById(R.id.editText);
        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");

        submit.setTypeface(gill);
        text.setTypeface(gill);
        return view;
    }


}