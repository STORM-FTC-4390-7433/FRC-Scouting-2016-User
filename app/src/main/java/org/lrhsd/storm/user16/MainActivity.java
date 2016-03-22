package org.lrhsd.storm.user16;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.lrhsd.storm.user16.TeamNumbers;

import java.util.Arrays;

import adapters.CustomArrayAdapter;
import database.DatabaseHandler;
import database.Stronghold;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final RadioButton red = (RadioButton)findViewById(R.id.radRed),
                    blue = (RadioButton)findViewById(R.id.radBlue);

        Typeface mist = Typeface.createFromAsset(getAssets(), "Mistral.ttf"),
                gill = Typeface.createFromAsset(getAssets(), "Gill Sans.ttf");

        TextView stormTxt = (TextView)findViewById(R.id.stormTxt),
                twitTxt = (TextView)findViewById(R.id.twitTxt),
                gitTxt = (TextView)findViewById(R.id.gitTxt),
                webTxt = (TextView)findViewById(R.id.webTxt);

        Spinner spinner = (Spinner)findViewById(R.id.spinAuto);
        CustomArrayAdapter<String> adapt = new CustomArrayAdapter<String>(getApplicationContext(), Arrays.asList(getResources().getStringArray(R.array.autoDefenses)));
        spinner.setAdapter(adapt);

        TextView text = (TextView)findViewById(R.id.txtHead);
        text.setTypeface(gill);

        Button begin = (Button)findViewById(R.id.btn_begin),
               qr = (Button)findViewById(R.id.start_qr_main);

        LinearLayout twitter = (LinearLayout)findViewById(R.id.twitter),
                git = (LinearLayout)findViewById(R.id.git),
                web = (LinearLayout)findViewById(R.id.web);

        EditText team = (EditText)findViewById(R.id.txtTeam),
                 match = (EditText)findViewById(R.id.txtMatch);

        red.setButtonDrawable(R.drawable.chkbox_off);
        blue.setButtonDrawable(R.drawable.chkbox_off);

        red.setTypeface(gill);
        blue.setTypeface(gill);

        team.setTypeface(gill);
        match.setTypeface(gill);

        begin.setTypeface(gill);
        qr.setTypeface(gill);

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.twitter.com/stormroboticsnj"));
                startActivity(intent);
            }
        });
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.github.com/2729StormRobotics"));
                startActivity(intent);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://stormroboticsnj.org"));
                startActivity(intent);
            }
        });

        stormTxt.setTypeface(mist);
        twitTxt.setTypeface(gill);
        gitTxt.setTypeface(gill);
        webTxt.setTypeface(gill);


        red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (red.isChecked()) {
                    red.setBackgroundResource(R.drawable.red_chk);
                } else {
                    red.setBackgroundResource(R.drawable.red_reg);
                }
            }
        });
        blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (blue.isChecked()) {
                    blue.setBackgroundResource(R.drawable.blue_chk);
                } else {
                    blue.setBackgroundResource(R.drawable.blue_reg);
                }
            }
        });
      new TeamNumbers(this);
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    @Override
    public void onResume(){
        super.onResume();
        ImageView imgLogo = (ImageView)findViewById(R.id.imgLogo);

        imgLogo.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.logo, 200, 200));
       }
    public boolean dataEntered(){
        RadioButton red = (RadioButton)findViewById(R.id.radRed),
                blue = (RadioButton)findViewById(R.id.radBlue);
        EditText txtTeam = (EditText)findViewById(R.id.txtTeam),
                txtMatch = (EditText)findViewById(R.id.txtMatch);
        if(!txtTeam.getText().toString().matches("") && !txtMatch.getText().toString().matches("") && (red.isChecked() || blue.isChecked())){
            return true;
        }
        return false;
    }
    public void startMatch(View v){
        if(this.dataEntered()) {
            RadioButton red = (RadioButton) findViewById(R.id.radRed);
            EditText txtTeam = (EditText) findViewById(R.id.txtTeam),
                    txtMatch = (EditText) findViewById(R.id.txtMatch);
            int team = Integer.parseInt(txtTeam.getText().toString()),
                    match = Integer.parseInt(txtMatch.getText().toString());
            Spinner spinner = (Spinner)findViewById(R.id.spinAuto);
            boolean isRed = red.isChecked();

                if (!TeamNumbers.isATeamNumber(team)) {
                    Toast.makeText(getApplicationContext(), "Team Number does not exist", Toast.LENGTH_SHORT).show();
                }
                if(match > 200){
                    Toast.makeText(getApplicationContext(), "Match number too high", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent start = new Intent(this, DefenseActivity.class);
                    Stronghold stronghold = new Stronghold(team, match, boolToInt(isRed));
                    stronghold.setStartingPos(spinner.getSelectedItem().toString());
                    EventBus.getDefault().postSticky(stronghold);
                    startActivity(start);
                }

        }
        else{
            Toast.makeText(getApplicationContext(), "Input all data please", Toast.LENGTH_SHORT).show();
        }



    }
    public void startQR(View v){
        EventBus.getDefault().postSticky(makeString());
        Intent qrIntent = new Intent(this, QrActivity.class);
        startActivity(qrIntent);
    }
    public String makeString(){
        String data = "@stormscouting";
        for(Stronghold strong : DatabaseHandler.getInstance(getApplicationContext()).getAllTeams()){
            if(strong.getNotes().equals("")){strong.setNotes("No Notes");}
            data += strong.getTeamNum() +
                    "," + strong.getMatchNum() +
                    "," + strong.getAlliance() +
                    "," + strong.getAutoDef() +
                    "," + strong.getAutoHigh() +
                    "," + strong.getAutoLow() +
                    "," + strong.getStartingPos() +
                    "," + strong.getAutoCross() +
                    "," + strong.getHighGoal() +
                    "," + strong.getLowGoal() +
                    "," + strong.getRamp() +
                    "," + strong.getScale() +
                    "," + strong.getCapture() +
                    "," + strong.getD1() +
                    "," + strong.getD2() +
                    "," + strong.getD3()  +
                    "," + strong.getD4() +
                    "," + strong.getD5() +
                    "," + strong.getdCross1() +
                    "," + strong.getdCross2() +
                    "," + strong.getdCross3() +
                    "," + strong.getdCross4() +
                    "," + strong.getdCross5() +
                    "," + strong.getNotes() +
                    "," + strong.getPt() +
                    "," + strong.getCdf() +
                    "," + strong.getRmp() +
                    "," + strong.getMt() +
                    "," + strong.getDb() +
                    "," + strong.getSp() +
                    "," + strong.getRw() +
                    "," + strong.getRt() +
                    "," + strong.getLb() + ":";
        }
        return data;
    }
    public int boolToInt(boolean a){
        if(a){
            return 1;
        }
        return 0;
    }
}
