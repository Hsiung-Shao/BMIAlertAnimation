package com.example.bmialertanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    TextView result, heightText, kgText;
    Button count;
    EditText height, kg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.resultTextView);
        heightText = findViewById(R.id.heightText);
        kgText = findViewById(R.id.kgText);

        height = findViewById(R.id.heightTextView);
        kg     = findViewById(R.id.kgTextView);

        count = findViewById(R.id.countButton);


    }

    public void bmiCount(View view) {

        String heightStringText = height.getText().toString();
        String kgStringText = kg.getText().toString();
        Log.d("height", heightStringText);
        Log.d("kg", kgStringText);
        result.setText(heightStringText + " - " + kgStringText);
        double sum;
        DecimalFormat df = new DecimalFormat("0.00");

        if(heightStringText.equals("") && kgStringText.equals("")) {
            heightText.startAnimation(AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_in));
            heightText.startAnimation(AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_out));
            kgText.startAnimation(AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_in));
            kgText.startAnimation(AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_out));
        }else if(heightStringText.equals("")) {
            heightText.startAnimation( AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_in));
            heightText.startAnimation( AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_out));
        }else if (kgStringText.equals("")){
            kgText.startAnimation( AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_in));
            kgText.startAnimation( AnimationUtils.loadAnimation(
                    getApplicationContext(), R.anim.scale_out));
        }else {
            double h = Double.parseDouble(heightStringText);
            double k = Double.parseDouble(kgStringText);
            sum = k / Math.pow(h, 2) * 100 * 100;
            if (sum < 18.5) {
                result.setText("BMI: " + df.format(sum) + " 體重過輕！");
            }else if(sum >= 18.5 && sum < 24) {
                result.setText("BMI: " + df.format(sum) + " 體重正常！");
            }else if(sum >= 24) {
                result.setText("BMI: " + df.format(sum) + " 體重過重！");
            }else if(sum > 27) {
                result.setText("BMI: " + df.format(sum) + " 輕度肥胖！");
            }else if(sum >= 30 && sum <= 35) {
                result.setText("BMI: " + df.format(sum) + " 中度肥胖！");
            }else {
                result.setText("BMI: " + df.format(sum) + " 重度肥胖！");
            }
        }

    }
}