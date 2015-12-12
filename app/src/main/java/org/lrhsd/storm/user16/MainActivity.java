package org.lrhsd.storm.user16;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

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
               if(red.isChecked()){
                  red.setBac
               }
            }
        });

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
