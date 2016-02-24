package fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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
        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");
        Button btnHighGoal = (Button) view.findViewById(R.id.btnHigh),
               btnHighGoalSub = (Button) view.findViewById(R.id.btnDecHigh),
               btnLowGoal = (Button) view.findViewById(R.id.btnDef1),
               btnLowGoalSub = (Button) view.findViewById(R.id.btnDecLow),
               btnDef1 = (Button)view.findViewById(R.id.btnDef1),
               btnDef1Sub = (Button)view.findViewById(R.id.btnDef1Sub),
               btnDef2 = (Button)view.findViewById(R.id.btnDef1),
                btnDef2Sub = (Button)view.findViewById(R.id.btnDef1Sub);

        TextView end = (TextView)view.findViewById(R.id.txtEnd);

        Bundle args = getArguments();

        TextView def1 = (TextView)view.findViewById(R.id.D1Txt),
                 def2 = (TextView)view.findViewById(R.id.D2Txt);

        def1.setText(args.getString("D1") + ": 0");
        def2.setText(args.getString("D2") + ": 0");


        CheckBox ramp = (CheckBox)view.findViewById(R.id.ramp),
        scale = (CheckBox)view.findViewById(R.id.scale),
        cap = (CheckBox)view.findViewById(R.id.capture);
        btnHighGoal.setTypeface(gill);
        btnHighGoalSub.setTypeface(gill);
        btnLowGoal.setTypeface(gill);
        btnLowGoalSub.setTypeface(gill);
        end.setTypeface(gill);
        ramp.setTypeface(gill);
        scale.setTypeface(gill);
        cap.setTypeface(gill);
        return view;
    }


}