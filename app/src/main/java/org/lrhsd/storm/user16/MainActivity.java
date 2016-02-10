package org.lrhsd.storm.user16;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.lrhsd.storm.user16.TeamNumbers;

import database.DatabaseHandler;
import database.Stronghold;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    Bitmap bStorm, bTwit, bGit, bWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final RadioButton red = (RadioButton)findViewById(R.id.radRed),
                    blue = (RadioButton)findViewById(R.id.radBlue);
        red.setButtonDrawable(R.drawable.chkbox_off);
        blue.setButtonDrawable(R.drawable.chkbox_off);
        bStorm = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.logo);
                bTwit = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.twitterimg);
                bGit = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.github);
                bWeb = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.web);
        LinearLayout twitter = (LinearLayout)findViewById(R.id.twitter),
                     git = (LinearLayout)findViewById(R.id.git),
                     web = (LinearLayout)findViewById(R.id.web);

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
    @Override
    public void onResume(){
        super.onResume();
        ImageView imgStorm = (ImageView)findViewById(R.id.imgStorm),
                  imgTwit = (ImageView)findViewById(R.id.imgTwit),
                  imgGit = (ImageView)findViewById(R.id.imgGit),
                  imgWeb = (ImageView)findViewById(R.id.imgWeb);

        Picasso.with(MainActivity.this)
                .load(R.drawable.logo)
                .into(imgStorm);
        Picasso.with(MainActivity.this)
                .load(R.drawable.twitterimg)
                .into(imgTwit);
        Picasso.with(MainActivity.this)
                .load(R.drawable.github)
                .into(imgGit);
        Picasso.with(MainActivity.this)
                .load(R.drawable.web)
                .into(imgWeb);
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
            boolean isRed = red.isChecked();

                if (!TeamNumbers.isATeamNumber(team)) {
                    Toast.makeText(getApplicationContext(), "Team Number does not exist", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent start = new Intent(this, MatchActivity.class);
                    Stronghold stronghold = new Stronghold(team, match, boolToInt(isRed));
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
            data += strong.getTeamNum() + "," + strong.getMatchNum() + "," + strong.getAlliance() + "," +
                    strong.getAutoDef() + "," + strong.getAutoHigh() + "," + strong.getAutoLow() + "," +
                    strong.getStartingPos() + "," + strong.getAutoCross() + "," + strong.getHighGoal() +  "," +
                    strong.getLowGoal() + "," + strong.getRamp() + "," + strong.getScale() + "," +
                    strong.getCapture() + "," + strong.getBreach() + "," + strong.getD1() +
                    "," + strong.getD2() + "," + strong.getD3()  + "," + strong.getD4() +
                    "," + strong.getD5() + "," + strong.getdCross1() + "," + strong.getdCross2() +
                    "," + strong.getdCross3() + "," + strong.getdCross4() + "," + strong.getdCross5() +
                    "," + strong.getdWeak1() + "," + strong.getdWeak2() +
                    "," + strong.getdWeak3() + "," + strong.getdWeak4() + "," + strong.getdWeak5() +
                    "," + strong.getNotes() + "," + strong.getPt() + "," + strong.getCdf() +
                    "," + strong.getRmp() + "," + strong.getMt() + "," + strong.getDb() +
                    "," + strong.getSp() + "," + strong.getRw() + "," + strong.getRt() +
                    "," + strong.getLb() + "," + strong.getHumanYes() + "," + strong.getHumanNo() + ":";
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
