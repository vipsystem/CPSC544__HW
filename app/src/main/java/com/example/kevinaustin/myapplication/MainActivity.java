package com.example.kevinaustin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Button btnRoll;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText)findViewById(R.id.etInput);
        btnRoll = findViewById(R.id.btnRoll);
        tvResult = findViewById(R.id.tvResult);




        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String input = etInput.getText().toString();
                if(isValid(input)){

                    int upper = 6;
                    int lower = 1;


                    int r = (int) (Math.random() * (upper - lower)) + lower;

                    Log.d("APP_DEBUG", "Rolled : " + r);

                    if(Integer.parseInt(input)>r){
                        tvResult.setText("You win!! Computer Rolled: "  +r );
                    }else{
                        tvResult.setText("You Lose!! Please try again..");
                    }


                }
            }
        });



    }


    private boolean isValid(String number){
        try{

            int n = Integer.parseInt(number);

            if( n < 1 || n > 6){
                return false;
            }
            return true;


        }catch ( Exception e){
            return false;
        }

    }


}
