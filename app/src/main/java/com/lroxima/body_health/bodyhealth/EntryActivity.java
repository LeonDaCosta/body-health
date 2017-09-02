package com.lroxima.body_health.bodyhealth;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EntryActivity extends AppCompatActivity {

    private Entry entry;
    Database dbHandler;
    private Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        final EditText weightText = (EditText) findViewById(R.id.editWeight);
        final EditText bmiText = (EditText) findViewById(R.id.editBmi);
        final EditText bodyFatText = (EditText) findViewById(R.id.editBodyFat);
        final EditText waterText = (EditText) findViewById(R.id.editWater);
        final EditText boneText = (EditText) findViewById(R.id.editBone);
        final Button btn = (Button) findViewById(R.id.button);

        weightText.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(4,2)});
        bmiText.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        bodyFatText.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        waterText.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        boneText.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});

        dbHandler = new Database(context);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                entry = new Entry();

                Log.d("ETY", weightText.getText().toString());
                Log.d("ETY", bmiText.getText().toString());
                Log.d("ETY", bodyFatText.getText().toString());
                Log.d("ETY", waterText.getText().toString());
                Log.d("ETY", boneText.getText().toString());
                Log.d("ETY","testing");

                entry.setWeight( Float.parseFloat( weightText.getText().toString() ) );
                entry.setBmi( Float.parseFloat( bmiText.getText().toString() ) );
                entry.setBodyFat( Float.parseFloat( bodyFatText.getText().toString() ) );
                entry.setWater( Float.parseFloat( waterText.getText().toString() ) );
                entry.setBone( Float.parseFloat( boneText.getText().toString() ) );

                Log.d("ETY", String.valueOf(entry.getWeight()));
                Log.d("ETY", String.valueOf(entry.getBmi()));
                Log.d("ETY", String.valueOf(entry.getBodyFat()));
                Log.d("ETY", String.valueOf(entry.getWater()));
                Log.d("ETY", String.valueOf(entry.getBone()));

                dbHandler.addRecord(entry);

            }
        });

    }

}
