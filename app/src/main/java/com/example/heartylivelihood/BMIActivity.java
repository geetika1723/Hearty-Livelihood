package com.example.heartylivelihood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BMIActivity extends AppCompatActivity {
    private  TextView bmi_score,message;
    private ToggleButton metrics;
    private EditText cm,ft,in,kg,lbs,gender,age;
    private Button calculate;
    private boolean inMetrics;
    private CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        bmi_score=findViewById(R.id.bmi_score);
        message=findViewById(R.id.message);
        metrics=findViewById(R.id.metrics);
        cm=findViewById(R.id.cm);
        ft=findViewById(R.id.ft);
        in=findViewById(R.id.in);
        kg=findViewById(R.id.kg);
        lbs=findViewById(R.id.lbs);
        gender=findViewById(R.id.gender);
        age=findViewById(R.id.age);
        calculate=findViewById(R.id.calculate);
        cardView=findViewById(R.id.cardView);

        inMetrics=true;
        updateInputVisibility();
        bmi_score.setVisibility(View.GONE);
        message.setVisibility(View.GONE);

        metrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inMetrics=!inMetrics;
                updateInputVisibility();
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inMetrics)
                {
                    if (cm.length()== 0 || kg.length()==0)
                        Toast.makeText(BMIActivity.this, "Enter Height and Height to calculate BMI", Toast.LENGTH_SHORT).show();
                    else {
                        double heightCm= Double.parseDouble(cm.getText().toString());
                        double weightKg=Double.parseDouble(kg.getText().toString());
                        double b=BMICalUtil.getInstance().calculateBMIMetric(heightCm,weightKg);
                        displayBMI(b);
                    }
                }
                else
                {
                    if(ft.length()==0 || in.length()==0 || lbs.length()==0)
                        Toast.makeText(BMIActivity.this, "Enter Height and Height to calculate BMI", Toast.LENGTH_SHORT).show();
                    else
                    {
                        double heightFt=Double.parseDouble(ft.getText().toString());
                        double heightIn=Double.parseDouble(in.getText().toString());
                        double weightLbs=Double.parseDouble(lbs.getText().toString());
                        double b=BMICalUtil.getInstance().calculateBMIImperial(heightFt,heightIn,weightLbs);
                        displayBMI(b);
                    }
                }
            }
        });
    }
    private void displayBMI(double b) {
        bmi_score.setVisibility(View.VISIBLE);
        message.setVisibility(View.VISIBLE);


        bmi_score.setText(String.format("%.2f",b));
        String bmi_message=BMICalUtil.getInstance().classifyBMI(b);
        message.setText(bmi_message);

        Toast.makeText(this, bmi_message, Toast.LENGTH_SHORT).show();

        switch (bmi_message)
        {
            case "Underweight" :
            case "OverWeight":
                cardView.setCardBackgroundColor(Color.YELLOW);

                break;
            case "Healthy Weight Range":
                cardView.setCardBackgroundColor(Color.GREEN);

                break;
            case "Obese" :
                cardView.setCardBackgroundColor(Color.RED);


        }

    }
    private void updateInputVisibility() {
        if(inMetrics)
        {
            cm.setVisibility(View.VISIBLE);
            kg.setVisibility(View.VISIBLE);
            ft.setVisibility(View.GONE);
            in.setVisibility(View.GONE);
            lbs.setVisibility(View.GONE);
        }
        else
        {
            cm.setVisibility(View.GONE);
            kg.setVisibility(View.GONE);
            ft.setVisibility(View.VISIBLE);
            in.setVisibility(View.VISIBLE);
            lbs.setVisibility(View.VISIBLE);
        }
    }
}