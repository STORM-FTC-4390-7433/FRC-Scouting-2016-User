package org.lrhsd.storm.user16;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import database.Stronghold;
import de.greenrobot.event.EventBus;
import fragments.AutoFragment;
import fragments.DefenseFragment;
import fragments.TeleFragment;
import fragments.ViewPagerAdapter;

public class MatchActivity extends FragmentActivity {

    private ViewPagerAdapter mViewPagerAdapter;
    ViewPager mViewPager;
    int highGoal = 0, lowGoal = 0;
    Button btnHighGoal, btnLowGoal;
    Stronghold strong;
    CheckBox autoDef, autoHigh, autoLow, autoCross, ramp, scale, cap, breach, chkCross1, chkCross2, chkCross3, chkCross4, chkCross5, chkWeak1, chkWeak2, chkWeak3, chkWeak4, chkWeak5;
    Spinner spinAuto, spinDef1, spinDef2, spinDef3, spinDef4, spinDef5;
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

    }

    public void highScore(View v){
        btnHighGoal = (Button)findViewById(R.id.btnHigh);
        ++highGoal;
        btnHighGoal.setText("High Goal: " + String.valueOf(highGoal));
    }
    public void decHighScore(View v){
        btnHighGoal = (Button)findViewById(R.id.btnHigh);
        --highGoal;
        btnHighGoal.setText("High Goal: " + String.valueOf(highGoal));
    }
    public void lowScrore(View v){
        btnLowGoal = (Button)findViewById(R.id.btnLow);
        ++lowGoal;
        btnLowGoal.setText("Low Goal: " + String.valueOf(lowGoal));
    }
    public void decLowScrore(View v){
        btnLowGoal = (Button)findViewById(R.id.btnLow);
        --lowGoal;
        btnLowGoal.setText("Low Goal: " + String.valueOf(lowGoal));
    }
    public void submitData(View v){
        autoCross = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoCross);
        autoDef = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoDef);
        autoHigh = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoHigh);
        autoLow = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoLow);
        ramp = (CheckBox)TeleFragment.view.findViewById(R.id.ramp);
        scale = (CheckBox)TeleFragment.view.findViewById(R.id.scale);
        cap = (CheckBox)TeleFragment.view.findViewById(R.id.capture);
        breach = (CheckBox)TeleFragment.view.findViewById(R.id.breach);

        spinAuto = (Spinner)AutoFragment.view.findViewById(R.id.spinAuto);
        spinDef1 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef1);
        spinDef2 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef2);
        spinDef3 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef3);
        spinDef4 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef4);
        spinDef5 = (Spinner)DefenseFragment.view.findViewById(R.id.spinDef5);

        AlertDialog.Builder build = new AlertDialog.Builder(getApplicationContext())
                .setTitle("Are you sure?")
                .setMessage("Are you ready to submit this data? This action cannot be undone")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        strong = EventBus.getDefault().removeStickyEvent(Stronghold.class);
                        strong.setAutoHigh(boolToInt(autoHigh.isChecked()));
                        strong.setAutoLow(boolToInt(autoLow.isChecked()));
                        //set rest
                    }
                });

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
        else if(text.equals("Drawbridge")){
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
        return null;
    }
    public int boolToInt(boolean a){
        if(a){
            return 1;
        }
        return 0;
    }

    }

