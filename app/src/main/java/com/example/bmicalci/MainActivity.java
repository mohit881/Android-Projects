package com.example.bmicalci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weightEdtText, ftEdtText, inchEdtText;
    Button   calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        weightEdtText = findViewById(R.id.weightEdtText);
        ftEdtText = findViewById(R.id.ftEdtText);
        inchEdtText = findViewById(R.id.inchEdtText);
        LinearLayout linearLayout;

        calculateButton = findViewById(R.id.calculateButton);

        resultTextView = findViewById(R.id.resultTextView);

        linearLayout = findViewById(R.id.linearLayout);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              int wt =  Integer.parseInt(weightEdtText.getText().toString());
              int ft = Integer.parseInt( ftEdtText.getText().toString());
              int inch = Integer.parseInt(inchEdtText.getText().toString());

              int htInInch = ft*12 + inch;  // Converted total height into inches

              double htInCm = htInInch*2.54; // converted height in cm

              double htInM = htInCm*0.01;  //  converted height in cm

              double bmi = wt/ (htInM*htInM);  //  converted height in m

              if (bmi>25)
              {
                  resultTextView.setText("Over Weight");
                  linearLayout.setBackgroundColor(getResources().getColor(R.color.overwt));
              }
              else if (bmi<18) {
                  resultTextView.setText("Under Weight");
                  linearLayout.setBackgroundColor(getResources().getColor(R.color.underwt));
              }
              else{
                  resultTextView.setText(" perfect ");
                  linearLayout.setBackgroundColor(getResources().getColor(R.color.perfect));
              }
            }
        });
    }
}