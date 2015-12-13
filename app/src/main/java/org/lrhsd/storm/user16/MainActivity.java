package org.lrhsd.storm.user16;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import org.lrhsd.storm.user16.TeamNumbers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton red = (RadioButton)findViewById(R.id.radRed),
                    blue = (RadioButton)findViewById(R.id.radBlue);
        red.setButtonDrawable(R.drawable.chkbox_off);
        blue.setButtonDrawable(R.drawable.chkbox_off);

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
                    startActivity(start);
                    Log.d("Team", String.valueOf(team));
                    Log.d("Match", String.valueOf(match));
                    Log.d("Alliance", String.valueOf(isRed));
                }

        }
        else{
            Toast.makeText(getApplicationContext(), "Input all data please", Toast.LENGTH_SHORT).show();
        }



    }
    public void twitterOpen(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.twitter.com/stormroboticsnj"));
        startActivity(intent);
    }
    public void webOpen(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.stormroboticsnj.org"));
        startActivity(intent);
    }
}
