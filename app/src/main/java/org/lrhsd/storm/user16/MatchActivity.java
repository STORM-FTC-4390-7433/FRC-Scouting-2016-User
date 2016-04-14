package org.lrhsd.storm.user16;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import database.DatabaseHandler;
import database.Stronghold;
import de.greenrobot.event.EventBus;
import fragments.AutoFragment;
import fragments.DefenseFragment;
import fragments.EndFragment;
import fragments.SubmitFragment;
import fragments.TeleFragment;
import fragments.ViewPagerAdapter;

/**
 *
 */
public class MatchActivity extends FragmentActivity {
    //Main objects
    private ViewPagerAdapter mViewPagerAdapter;
    ViewPager mViewPager;
    int highGoal = 0, lowGoal = 0, humanYes = 0, humanNo = 0, d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0;
    Button btnHighGoal, btnLowGoal;
    Stronghold strong;
    CheckBox autoDef, autoHigh, autoLow, autoCross, ramp, scale, cap, breach, chkCross1, chkCross2, chkCross3, chkCross4, chkCross5, chkWeak1, chkWeak2, chkWeak3, chkWeak4, chkWeak5;
    Spinner spinAuto, spinDef1, spinDef2, spinDef3, spinDef4, spinDef5;
    String autoPos = "", def1 = "", def2 = "", def3 = "", def4 = "", def5 = "";
    /**
     * <p>OnCreate runs at the begininning of the app displaying
     * See <b>http://developer.android.com/intl/ru/reference/android/app/Activity.html#ActivityLifecycle</b> for the total life cycle of an activity</p>
     * @param savedInstanceState - instance for activity parceable arguments
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
         * Needed objects and method calls
         * super.oncreate calls the original super method from the activity class
         * setContentView sets XML layout and setRequestedOrientation locks screen orientation. IDs are stored in the objects in the layout files
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        strong = EventBus.getDefault().removeStickyEvent(Stronghold.class);
        // Create the adapter that will return a fragment for each of the four
        // primary sections of the activity.
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), strong);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mViewPagerAdapter);

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);

    }

    /**
     * <p>Increment high goal score</p>
     * @param v - view being passed for the action
     */
    public void highScore(View v){
        TextView textHigh = (TextView)findViewById(R.id.txtHigh);
        ++highGoal;
        textHigh.setText("High Goal: " + String.valueOf(highGoal));
    }
    /**
     * <p>Decrement high goal score</p>
     * @param v - view being passed for the action
     */
    public void decHighScore(View v){
        if(highGoal  > 0) {
            TextView textHigh = (TextView)findViewById(R.id.txtHigh);
            --highGoal;
            textHigh.setText("High Goal: " + String.valueOf(highGoal));
        }
    }
    /**
     * <p>Increment low goal score</p>
     * @param v - view being passed for the action
     */
    public void lowScrore(View v){
        TextView low = (TextView)findViewById(R.id.txtLow);
        ++lowGoal;
        low.setText("Low Goal: " + String.valueOf(lowGoal));
    }
    /**
     * <p>Decrement low goal score</p>
     * @param v - view being passed for the action
     */
    public void decLowScrore(View v){
        if(lowGoal > 0) {
            TextView low = (TextView)findViewById(R.id.txtLow);
            --lowGoal;
            low.setText("Low Goal: " + String.valueOf(lowGoal));
        }
    }
    /**
     * <p>Increment defense 1 score</p>
     * @param v - view being passed for the action
     */
    public void Def1(View v){
        TextView de1 = (TextView)findViewById(R.id.D1Txt);
        ++d1;
        de1.setText(strong.getD1() + ": " + String.valueOf(d1));
        Log.d("D1", String.valueOf(d1));
    }
    /**
     * <p>Increment defense 2 score</p>
     * @param v - view being passed for the action
     */
    public void Def2(View v){
       TextView score = (TextView)findViewById(R.id.D2Txt);
        ++d2;
        score.setText(strong.getD2() + ": " + String.valueOf(d2));
    }
    /**
     * <p>Increment defense 3 score</p>
     * @param v - view being passed for the action
     */
    public void Def3(View v){
        TextView de3 = (TextView)findViewById(R.id.D3Txt);
        ++d3;
        de3.setText(strong.getD3() + ": " + String.valueOf(d3));
    }
    /**
     * <p>Increment defense 4 score</p>
     * @param v - view being passed for the action
     */
    public void Def4(View v){
        TextView de4 = (TextView)findViewById(R.id.D4Txt);
        ++d4;
        de4.setText(strong.getD4() + ": " + String.valueOf(d4));
    }
    /**
     * <p>Increment defense 5 score</p>
     * @param v - view being passed for the action
     */
    public void Def5(View v){
        TextView de5 = (TextView)findViewById(R.id.D5Txt);
        ++d5;
        de5.setText(strong.getD5() + ": " + String.valueOf(d5));
    }
    /**
     * <p>Decrement defense 1 score</p>
     * @param v - view being passed for the action
     */
    public void Def1Sub(View v){
        TextView de1 = (TextView)findViewById(R.id.D1Txt);
        if(d1 > 0) {
            --d1;
            de1.setText(strong.getD1() + ": " + String.valueOf(d1));
        }
        Log.d("D1", String.valueOf(d1));
    }
    /**
     * <p>Decrement defense 2 score</p>
     * @param v - view being passed for the action
     */
    public void Def2Sub(View v){
        TextView score = (TextView)findViewById(R.id.D2Txt);
        if(d2 > 0) {
            --d2;
            score.setText(strong.getD2() + ": " + String.valueOf(d2));
        }
    }
    /**
     * <p>Decrement defense 3 score</p>
     * @param v - view being passed for the action
     */
    public void Def3Sub(View v){
        TextView de3 = (TextView)findViewById(R.id.D3Txt);
        if(d3 > 0) {
            --d3;
            de3.setText(strong.getD3() + ": " + String.valueOf(d3));
        }
    }
    /**
     * <p>Decrement defense 4 score</p>
     * @param v - view being passed for the action
     */
    public void Def4Sub(View v){
        TextView de4 = (TextView)findViewById(R.id.D4Txt);
        if(d4 > 0) {
            --d4;
            de4.setText(strong.getD4() + ": " + String.valueOf(d4));
        }
    }
    /**
     * <p>Decrement defense 5 score</p>
     * @param v - view being passed for the action
     */
    public void Def5Sub(View v){
        TextView de5 = (TextView)findViewById(R.id.D5Txt);
        if(d5 > 0) {
            --d5;
            de5.setText(strong.getD5() + ": " + String.valueOf(d5));
        }
    }
    /**
     * <p>Prepares data to be submitted to the database</p>
     * @param v - view being passed for the action
     */
    public void submitData(View v){
        //views stored in the fragment
        autoHigh = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoHigh);
        autoLow = (CheckBox)AutoFragment.view.findViewById(R.id.chkAutoLow);
        ramp = (CheckBox) EndFragment.view.findViewById(R.id.ramp);
        scale = (CheckBox)EndFragment.view.findViewById(R.id.scale);
        cap = (CheckBox)EndFragment.view.findViewById(R.id.cap);

        final RadioButton cross = (RadioButton)AutoFragment.view.findViewById(R.id.radOrg),
                          start = (RadioButton)AutoFragment.view.findViewById(R.id.radRed);

        final EditText notes = (EditText) SubmitFragment.view.findViewById(R.id.editText);


        Log.d("Submit", "Alert dialog start");
        //Message box builder
        new AlertDialog.Builder(this)
                .setTitle("Return to main Screen")
                .setMessage("Are you sure? This action cannot be undone")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //sets data for the qr code
                        strong.setStartingPos(textToSymbol(strong.getStartingPos()));
                        strong.setD1(textToSymbol(strong.getD1()));
                        strong.setD2(textToSymbol(strong.getD2()));
                        strong.setD3(textToSymbol(strong.getD3()));
                        strong.setD4(textToSymbol(strong.getD4()));
                        strong.setD5(textToSymbol(strong.getD5()));
                        Log.d("DEF", def1);

                        defense(strong.getD1(), d1);
                        defense(strong.getD2(), d2);
                        defense(strong.getD3(), d3);
                        defense(strong.getD4(), d4);
                        defense(strong.getD5(), d5);

                        strong.setAutoHigh(boolToInt(autoHigh.isChecked()));
                        strong.setAutoLow(boolToInt(autoLow.isChecked()));
                        strong.setAutoCross(boolToInt(cross.isChecked()));
                        strong.setAutoDef(boolToInt(start.isChecked()));
                        strong.setHighGoal(highGoal);
                        strong.setLowGoal(lowGoal);
                        strong.setScale(boolToInt(scale.isChecked()));
                        strong.setRamp(boolToInt(ramp.isChecked()));
                        strong.setCapture(boolToInt(cap.isChecked()));

                        strong.setdCross1(d1);
                        strong.setdCross2(d2);
                        strong.setdCross3(d3);
                        strong.setdCross4(d4);
                        strong.setdCross5(d5);
                        strong.setNotes(notes.getText().toString());

                        //Submits data to database
                        DatabaseHandler.getInstance(getApplicationContext()).addAllData(strong);
                        Toast.makeText(getApplicationContext(), "Data added", Toast.LENGTH_SHORT).show();

                        //return to main screen
                        Intent returnAction = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(returnAction);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

    }

    /**
     * Converts the long defense names to shorter symbols
     * @param text - defense name
     * @return shorter symbol of the defense, null if invalid
     */
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

    /**
     * converts boolean value to int
     * @param a - boolean value
     * @return 1 if true, 0 if false
     */
    public int boolToInt(boolean a){
        if(a){
            return 1;
        }
        return 0;
    }

    /**
     * sets specific defense values in the stronghold objects
     * @param str - defense symbol to use as reference
     * @param i - amount to increment the defense value by
     */
    public void defense(String str, int i){
        switch (str){
            case "pt":
                strong.setPt(strong.getPt() + i);
                break;
            case "cdf":
                strong.setCdf(strong.getCdf() + i);
                break;
            case "rmp":
                strong.setRmp(strong.getRmp() + +i);
                break;
            case "mt":
                strong.setMt(strong.getMt() + i);
                break;
            case "db":
                strong.setDb(strong.getDb() + i);
                break;
            case "sp":
                strong.setSp(strong.getSp() + i);
                break;
            case "rw":
                strong.setRw(strong.getRw() + i);
                break;
            case "rt":
                strong.setRt(strong.getRt() + i);
                break;
            case "lb":
                strong.setLb(strong.getLb() + i);
                break;
        }
    }
}