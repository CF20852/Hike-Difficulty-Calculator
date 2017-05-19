package com.spectrum_applications.hikedifficultycalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import static android.R.color.black;
import static android.R.color.holo_red_light;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /** Called when the user taps the Send button */
    public void calculateDifficulty(View view) {
        double distance, elevationGain, difficulty;
        String distanceInputStr, elevGainInputStr, difficultyString;

        TextView text0 = (TextView) findViewById(R.id.levels_0);
        text0.setTextColor(Color.rgb(0, 0, 0));
        TextView text1 = (TextView) findViewById(R.id.levels_1);
        text1.setTextColor(Color.rgb(0, 0, 0));
        TextView text2 = (TextView) findViewById(R.id.levels_2);
        text2.setTextColor(Color.rgb(0, 0, 0));
        TextView text3 = (TextView) findViewById(R.id.levels_3);
        text3.setTextColor(Color.rgb(0, 0, 0));
        TextView text4 = (TextView) findViewById(R.id.levels_4);
        text4.setTextColor(Color.rgb(0, 0, 0));
        TextView text5 = (TextView) findViewById(R.id.levels_5);
        text5.setTextColor(Color.rgb(0, 0, 0));

        EditText distanceInput = (EditText) findViewById(R.id.distance);
        distanceInputStr = distanceInput.getText().toString();

        EditText elevationGainInput = (EditText) findViewById(R.id.elevationGain);
        elevGainInputStr = elevationGainInput.getText().toString();

        TextView difficultyLevel = (TextView) findViewById(R.id.difficulty);

        if ( TextUtils.isEmpty(distanceInputStr) || TextUtils.isEmpty(elevGainInputStr) ) {
            difficultyString = "???";
        }

        else {
            distance = Float.parseFloat(distanceInputStr);
            elevationGain = Float.parseFloat(elevGainInputStr);
            difficulty = 0.979796 * distance + 0.041667 * elevationGain / distance;
            difficultyString = String.format(Locale.US,"%.1f", difficulty);

            if (difficulty > 0 && difficulty <= 7.5) {
                text0.setTextColor(Color.rgb(0, 255, 0));
            }

            if (difficulty > 7.5 && difficulty <= 13.5) {
                text1.setTextColor(Color.rgb(0, 255, 0));
            }

            if (difficulty > 13.5 && difficulty <= 18.5) {
                text2.setTextColor(Color.rgb(255, 128, 0));
            }

            if (difficulty > 18.5 && difficulty <= 23.5) {
                text3.setTextColor(Color.rgb(255, 128, 0));
            }

            if (difficulty > 23.5 && difficulty <= 28.5) {
                text4.setTextColor(Color.rgb(255, 0, 0));
            }

            if (difficulty > 28.5) {
                text5.setTextColor(Color.rgb(255, 0, 0));
            }

        }

        difficultyLevel.setText(difficultyString);
    }
}