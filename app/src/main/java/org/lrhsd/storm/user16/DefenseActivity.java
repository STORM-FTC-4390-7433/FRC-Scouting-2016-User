package org.lrhsd.storm.user16;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

import adapters.CustomArrayAdapter;
import database.Stronghold;
import de.greenrobot.event.EventBus;

public class DefenseActivity extends AppCompatActivity {
    Stronghold strong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defense);

        strong = EventBus.getDefault().removeStickyEvent(Stronghold.class);

        Typeface gill = Typeface.createFromAsset(getAssets(), "Gill Sans.ttf");
         final Spinner spin2 = (Spinner)findViewById(R.id.spin2),
                spin3 = (Spinner)findViewById(R.id.spin3),
                spin4 = (Spinner)findViewById(R.id.spin4),
                spin5 = (Spinner)findViewById(R.id.spin5);
        CustomArrayAdapter<String> adapter = new CustomArrayAdapter<>(getApplicationContext(), Arrays.asList(getResources().getStringArray(R.array.defenses)));
        Picasso.with(getApplicationContext())
                .load(R.drawable.def)
                .resize(2000, 3000)
                .into((ImageView)findViewById(R.id.img));
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);
        spin4.setAdapter(adapter);
        spin5.setAdapter(adapter);

        TextView head1 = (TextView)findViewById(R.id.txtD2),
                 head2 = (TextView)findViewById(R.id.txtD3),
                 head3 = (TextView)findViewById(R.id.txtD4),
                 head4 = (TextView)findViewById(R.id.txtD5);

        head1.setTypeface(gill);
        head2.setTypeface(gill);
        head3.setTypeface(gill);
        head4.setTypeface(gill);

        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0 && (spin5.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) || spin5.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) ||
                            spin5.getSelectedItem().toString().equals(spin4.getSelectedItem().toString()))) {
                        Toast.makeText(getApplicationContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                        if (position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() - 1) {
                            spin5.setSelection(position + 1, false);
                        } else {
                            spin5.setSelection(position - 1);
                        }
                    }

                }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0 && (spin2.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) ||
                            spin2.getSelectedItem().toString().equals(spin4.getSelectedItem().toString()) || spin2.getSelectedItem().toString().equals(spin5.getSelectedItem().toString()))) {
                        Toast.makeText(getApplicationContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                        if (position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() - 1) {
                            spin2.setSelection(position + 1, false);
                        } else {
                            spin2.setSelection(position - 1);
                        }
                    }

                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && (spin3.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) ||
                        spin3.getSelectedItem().toString().equals(spin4.getSelectedItem().toString()))) {
                    Toast.makeText(getApplicationContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                    if (position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() - 1) {
                        spin3.setSelection(position + 1, false);
                    } else {
                        spin3.setSelection(position - 1);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && (spin4.getSelectedItem().toString().equals(spin2.getSelectedItem().toString()) ||
                        spin4.getSelectedItem().toString().equals(spin3.getSelectedItem().toString()) || spin4.getSelectedItem().toString().equals(spin5.getSelectedItem().toString()))) {
                    Toast.makeText(getApplicationContext(), "Cannot choose that defense. It has already been chosen", Toast.LENGTH_LONG).show();
                    if (position < Arrays.asList(getResources().getStringArray(R.array.defenses)).size() - 1) {
                        spin4.setSelection(position + 1, false);
                    } else {
                        spin4.setSelection(position - 1);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });  

    }
    public void getMatchGoing(View v){
        final Spinner spin2 = (Spinner)findViewById(R.id.spin2),
                spin3 = (Spinner)findViewById(R.id.spin3),
                spin4 = (Spinner)findViewById(R.id.spin4),
                spin5 = (Spinner)findViewById(R.id.spin5);
        strong.setD1("Low Bar");
        Log.d("D1", spin2.getSelectedItem().toString());
        strong.setD2(spin2.getSelectedItem().toString());
        strong.setD3(spin3.getSelectedItem().toString());
        strong.setD4(spin4.getSelectedItem().toString());
        strong.setD5(spin5.getSelectedItem().toString());

        Intent begin = new Intent(getApplicationContext(), MatchActivity.class);
        EventBus.getDefault().postSticky(strong);

        startActivity(begin);
    }
}
