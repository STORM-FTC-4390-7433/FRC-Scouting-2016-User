package org.lrhsd.storm.user16;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import database.DatabaseHandler;
import database.Stronghold;
import de.greenrobot.event.EventBus;
import fragments.AutoFragment;
import fragments.DefenseFragment;
import fragments.SubmitFragment;
import fragments.TeleFragment;
import fragments.ViewPagerAdapter;

public class MatchActivity extends FragmentActivity {

    private ViewPagerAdapter mViewPagerAdapter;
    ViewPager mViewPager;
    int highGoal = 0, lowGoal = 0, humanYes = 0, humanNo = 0;
    Button btnHighGoal, btnLowGoal;
    Stronghold strong;
    CheckBox autoDef, autoHigh, autoLow, autoCross, ramp, scale, cap, breach, chkCross1, chkCross2, chkCross3, chkCross4, chkCross5, chkWeak1, chkWeak2, chkWeak3, chkWeak4, chkWeak5;
    Spinner spinAuto, spinDef1, spinDef2, spinDef3, spinDef4, spinDef5;
    String autoPos = "", def1 = "", def2 = "", def3 = "", def4 = "", def5 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mViewPagerAdapter);

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
        strong = EventBus.getDefault().removeStickyEvent(Stronghold.class);

    }

    public void highScore(View v){
        btnHighGoal = (Button)findViewById(R.id.btnHigh);
        ++highGoal;
        btnHighGoal.setText("High Goal: " + String.valueOf(highGoal));
    }
    public void decHighScore(View v){
        if(highGoal  > 0) {
            btnHighGoal = (Button) findViewById(R.id.btnHigh);
            --highGoal;
            btnHighGoal.setText("High Goal: " + String.valueOf(highGoal));
        }
    }
    public void lowScrore(View v){
        btnLowGoal = (Button)findViewById(R.id.btnLow);
        ++lowGoal;
        btnLowGoal.setText("Low Goal: " + String.valueOf(lowGoal));
    }
    public void decLowScrore(View v){
        if(lowGoal > 0) {
            btnLowGoal = (Button) findViewById(R.id.btnLow);
            --lowGoal;
            btnLowGoal.setText("Low Goal: " + String.valueOf(lowGoal));
        }
    }
    public void humanYes(View v){
        Button humanY = (Button)findViewById(R.id.btnYes);
        ++humanYes;
        humanY.setText("Yes: " + String.valueOf(humanYes));
    }
    public void humanYesSub(View v){
        if(humanYes > 0){
            Button humanY = (Button)findViewById(R.id.btnYes);
            --humanYes;
            humanY.setText("Yes: " + String.valueOf(humanYes));
        }
    }
    public void humanNo(View v){
        Button humanN = (Button)findViewById(R.id.btnNo);
        ++humanNo;
        humanN.setText("No: " + String.valueOf(humanNo));
    }
    public void humanNoSub(View v){
        if(humanNo > 0){
            Button humanN = (Button)findViewById(R.id.btnNo);
            --humanNo;
            humanN.setText("No: " + String.valueOf(humanNo));
        }
    }
    public void submitData(View v){
        final CheckBox port = (CheckBox)AutoFragment.view.findViewById(R.id.chkPort),
        cdf = (CheckBox)AutoFragment.view.findViewById(R.id.chkCdf),
        rt = (CheckBox)AutoFragment.view.findViewById(R.id.chkRt),
        rw = (CheckBox)AutoFragment.view.findViewById(R.id.chkRw),
        db = (CheckBox)AutoFragment.view.findViewById(R.id.chkDb),
        sp = (CheckBox)AutoFragment.view.findViewById(R.id.chkSp),
        mt = (CheckBox)AutoFragment.view.findViewById(R.id.chkMt),
        rmp = (CheckBox)AutoFragment.view.findViewById(R.id.chkRmp),
        lb = (CheckBox)AutoFragment.view.findViewById(R.id.chkLb);
        autoDef = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoDef);
        autoHigh = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoHigh);
        autoLow = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoLow);
        ramp = (CheckBox)TeleFragment.view.findViewById(R.id.ramp);
        scale = (CheckBox)TeleFragment.view.findViewById(R.id.scale);
        cap = (CheckBox)TeleFragment.view.findViewById(R.id.capture);
        breach = (CheckBox)TeleFragment.view.findViewById(R.id.breach);

        chkCross1 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkDef1);
        chkCross2 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkDef2);
        chkCross3 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkDef3);
        chkCross4 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkDef4);
        chkCross5 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkDef5);

        chkWeak1 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkWeak1);
        chkWeak2 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkWeak2);
        chkWeak3 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkWeak3);
        chkWeak4 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkWeak4);
        chkWeak5 = (CheckBox)DefenseFragment.view.findViewById(R.id.chkWeak5);

        final EditText notes = (EditText) SubmitFragment.view.findViewById(R.id.editText);
        spinAuto = (Spinner)AutoFragment.view.findViewById(R.id.spinAuto);
        spinDef1 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef1);
        spinDef2 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef2);
        spinDef3 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef3);
        spinDef4 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef4);
        spinDef5 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef5);
        Log.d("Spinner", textToSymbol(spinAuto.getSelectedItem().toString()));
        autoPos = textToSymbol(spinAuto.getSelectedItem().toString());
        def1 = textToSymbol(spinDef1.getSelectedItem().toString());
        def2 = textToSymbol(spinDef2.getSelectedItem().toString());
        def3 = textToSymbol(spinDef3.getSelectedItem().toString());
        def4 = textToSymbol(spinDef4.getSelectedItem().toString());
        def5 = textToSymbol(spinDef5.getSelectedItem().toString());
        Log.d("DEF", def1);

        defense(def1, chkCross1, chkWeak1);
        defense(def2, chkCross2, chkWeak2);
        defense(def3, chkCross3, chkWeak3);
        defense(def4, chkCross4, chkWeak4);
        defense(def5, chkCross5, chkWeak5);

        Log.d("Submit", "Alert dialog start");
        new AlertDialog.Builder(this)
                .setTitle("Return to main Screen")
                .setMessage("Are you sure? This action cannot be undone")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        strong.setAutoHigh(boolToInt(autoHigh.isChecked()));
                        strong.setAutoLow(boolToInt(autoLow.isChecked()));
                        strong.setAutoCross(defense(port, cdf, rw, rt, db, sp, mt, rmp,lb));
                        strong.setStartingPos(autoPos);
                        strong.setAutoDef(boolToInt(autoDef.isChecked()));
                        strong.setHighGoal(highGoal);
                        strong.setLowGoal(lowGoal);
                        strong.setScale(boolToInt(scale.isChecked()));
                        strong.setRamp(boolToInt(ramp.isChecked()));
                        strong.setCapture(boolToInt(cap.isChecked()));
                        strong.setBreach(boolToInt(breach.isChecked()));
                        strong.setD1(def1);
                        strong.setD2(def2);
                        strong.setD3(def3);
                        strong.setD4(def4);
                        strong.setD5(def5);
                        strong.setdCross1(boolToInt(chkCross1.isChecked()));
                        strong.setdCross2(boolToInt(chkCross2.isChecked()));
                        strong.setdCross3(boolToInt(chkCross3.isChecked()));
                        strong.setdCross4(boolToInt(chkCross4.isChecked()));
                        strong.setdCross5(boolToInt(chkCross5.isChecked()));
                        strong.setdWeak1(boolToInt(chkWeak1.isChecked()));
                        strong.setdWeak2(boolToInt(chkWeak2.isChecked()));
                        strong.setdWeak3(boolToInt(chkWeak3.isChecked()));
                        strong.setdWeak4(boolToInt(chkWeak4.isChecked()));
                        strong.setdWeak5(boolToInt(chkWeak5.isChecked()));
                        strong.setNotes(notes.getText().toString());
                        strong.setPt(strong.getPt() + boolToInt(port.isChecked()));
                        strong.setCdf(strong.getCdf() + boolToInt(cdf.isChecked()));
                        strong.setRt(strong.getRt() + boolToInt(rt.isChecked()));
                        strong.setRw(strong.getRw() + boolToInt(rw.isChecked()));
                        strong.setLb(strong.getLb() + boolToInt(lb.isChecked()));
                        strong.setMt(strong.getMt() + boolToInt(mt.isChecked()));
                        strong.setRmp(strong.getRmp() + boolToInt(rmp.isChecked()));
                        strong.setSp(strong.getSp() + boolToInt(sp.isChecked()));
                        strong.setDb(strong.getDb() + boolToInt(db.isChecked()));
                        strong.setHuman(humanYes);
                        strong.setHumanNo(humanNo);
                        DatabaseHandler.getInstance(getApplicationContext()).addAllData(strong);
                        Toast.makeText(getApplicationContext(), "Data added", Toast.LENGTH_SHORT).show();
                        Intent returnAction = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(returnAction);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

    }
    public String textToSymbol(String text){
        if(text.equals("Portcullis")){
            return "pt";
        }
        else if(text.equals("Cheval de Frise")){
            return "cdf";
        }
        else if(text.equals("Ramparts")){
            return "rmp";
        }
        else if(text.equals("Moat")){
            return "mt";
        }
        else if(text.equals("DrawBridge")){
            return "db";
        }
        else if(text.equals("Sally Port")){
            return "sp";
        }
        else if(text.equals("Rock Wall")){
            return "rw";
        }
        else if(text.equals("Rough Terrain")){
            return "rt";
        }
        else if(text.equals("Low Bar")){
            return "lb";
        }
        else if(text.equals("None(Spy Position)")){
            return "nA";
        }
        return null;
    }
    public int boolToInt(boolean a){
        if(a){
            return 1;
        }
        return 0;
    }
    public void defense(String str, CheckBox box1, CheckBox box2){
        switch (str){
            case "pt":
                strong.setPt(strong.getPt() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "cdf":
                strong.setCdf(strong.getCdf() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "rmp":
                strong.setRmp(strong.getRmp() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "mt":
                strong.setMt(strong.getMt() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "db":
                strong.setDb(strong.getDb() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "sp":
                strong.setSp(strong.getSp() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "rw":
                strong.setRw(strong.getRw() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "rt":
                strong.setRt(strong.getRt() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
            case "lb":
                strong.setLb(strong.getLb() + boolToInt(box1.isChecked()) + boolToInt(box2.isChecked()));
                break;
        }
    }
    public int defense(CheckBox b1, CheckBox b2, CheckBox b3, CheckBox b4, CheckBox b5, CheckBox b6, CheckBox b7, CheckBox b8, CheckBox b9){
        if(b1.isChecked() || b2.isChecked() || b3.isChecked() || b4.isChecked() || b5.isChecked() || b6.isChecked() || b7.isChecked() || b8.isChecked() || b9.isChecked()){
            return 1;
        }
        return 0;
    }

    }

