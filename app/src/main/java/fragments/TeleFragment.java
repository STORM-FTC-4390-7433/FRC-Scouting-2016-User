package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import org.lrhsd.storm.user16.R;

public class TeleFragment extends Fragment {
    public static View view;

    public TeleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tele, container, false);
        final CompoundButton yes = (CompoundButton)view.findViewById(R.id.yes),
                 no = (RadioButton)view.findViewById(R.id.no);
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(yes.isChecked()){
                    yes.setBackgroundResource(R.drawable.orange_chk);
                }
                else{
                    yes.setBackgroundResource(R.drawable.orange_reg);
                }
            }
        });
        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no.isChecked()) {
                    no.setBackgroundResource(R.drawable.red_chk);
                } else {
                    no.setBackgroundResource(R.drawable.red_reg);
                }
            }
        });
        return view;
    }


}