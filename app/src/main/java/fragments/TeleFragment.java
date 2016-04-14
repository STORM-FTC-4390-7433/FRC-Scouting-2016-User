package fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        //Fonts
        Typeface gill = Typeface.createFromAsset(getActivity().getAssets(), "Gill Sans.ttf");
        //Collection of UI components
        Button btnHighGoal = (Button) view.findViewById(R.id.btnHigh),
               btnHighGoalSub = (Button) view.findViewById(R.id.btnDecHigh),
               btnLowGoal = (Button) view.findViewById(R.id.btnDefense1),
               btnLowGoalSub = (Button) view.findViewById(R.id.btnDecLow),
               btnDef1 = (Button)view.findViewById(R.id.btnDefense1),
               btnDef1Sub = (Button)view.findViewById(R.id.btnDef1Sub),
               btnDef2 = (Button)view.findViewById(R.id.btnDef2),
               btnDef2Sub = (Button)view.findViewById(R.id.btnDef2Sub),
               btnDef3 = (Button)view.findViewById(R.id.btnDef3),
               btnDef3Sub = (Button)view.findViewById(R.id.btnDef3Sub),
               btnDef4 = (Button)view.findViewById(R.id.btnDef4),
               btnDef4Sub = (Button)view.findViewById(R.id.btnDef4Sub),
               btnDef5 = (Button)view.findViewById(R.id.btnDef5),
               btnDef5Sub = (Button)view.findViewById(R.id.btnDef5Sub);

        //Retrieves the arguments that was set for the fragment
        //See the fragment adapter for the declaration
        Bundle args = getArguments();


        TextView def1 = (TextView)view.findViewById(R.id.D1Txt),
                 def2 = (TextView)view.findViewById(R.id.D2Txt),
                 def3 = (TextView)view.findViewById(R.id.D3Txt),
                 def4 = (TextView)view.findViewById(R.id.D4Txt),
                 def5 = (TextView)view.findViewById(R.id.D5Txt);

        //sets the text, using fragment arguments
        def1.setText(args.getString("D1") + ": 0");
        def2.setText(args.getString("D2") + ": 0");
        def3.setText(args.getString("D3") + ": 0");
        def4.setText(args.getString("D4") + ": 0");
        def5.setText(args.getString("D5") + ": 0");


        btnHighGoal.setTypeface(gill);
        btnHighGoalSub.setTypeface(gill);
        btnLowGoal.setTypeface(gill);
        btnDef1.setTypeface(gill);
        btnDef2.setTypeface(gill);
        btnDef3.setTypeface(gill);
        btnDef4.setTypeface(gill);
        btnDef5.setTypeface(gill);
        btnDef1Sub.setTypeface(gill);
        btnDef2Sub.setTypeface(gill);
        btnDef3Sub.setTypeface(gill);
        btnDef4Sub.setTypeface(gill);
        btnDef5Sub.setTypeface(gill);
        return view;
    }


}