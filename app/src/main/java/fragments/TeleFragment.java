package fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import org.lrhsd.storm.user16.R;
import org.w3c.dom.Text;

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
        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");
        Button btnHighGoal = (Button) view.findViewById(R.id.btnHigh),
               btnHighGoalSub = (Button) view.findViewById(R.id.btnDecHigh),
               btnLowGoal = (Button) view.findViewById(R.id.btnLow),
               btnLowGoalSub = (Button) view.findViewById(R.id.btnDecLow),
               humYes = (Button) view.findViewById(R.id.btnYes),
               humYesSub = (Button) view.findViewById(R.id.btnYesSub),
               humNo = (Button) view.findViewById(R.id.btnNo),
               humNoSub = (Button) view.findViewById(R.id.btnNoSub);

        TextView hum = (TextView)view.findViewById(R.id.txtHum),
                 end = (TextView)view.findViewById(R.id.txtEnd);

        CheckBox ramp = (CheckBox)view.findViewById(R.id.ramp),
        scale = (CheckBox)view.findViewById(R.id.scale),
        cap = (CheckBox)view.findViewById(R.id.capture);
        btnHighGoal.setTypeface(gill);
        btnHighGoalSub.setTypeface(gill);
        btnLowGoal.setTypeface(gill);
        btnLowGoalSub.setTypeface(gill);
        humYes.setTypeface(gill);
        humNo.setTypeface(gill);
        humYesSub.setTypeface(gill);
        humNoSub.setTypeface(gill);
        hum.setTypeface(gill);
        end.setTypeface(gill);
        ramp.setTypeface(gill);
        scale.setTypeface(gill);
        cap.setTypeface(gill);
        return view;
    }


}