package com.akashshetty.quizprime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView Gradetxt,Totaltxt;
    Button Retrybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Gradetxt=(TextView)findViewById(R.id.tvGrade);
        Totaltxt=(TextView)findViewById(R.id.tvTotal);
        Retrybtn=(Button)findViewById(R.id.btnRetry);

        Bundle bundle=getIntent().getExtras();
        int Score=bundle.getInt("Finalscore :");

       Totaltxt.setText("You have scored "+Score+ " out of " + QuizBook.questions.length);

        if(Score==10){
            Gradetxt.setText("Outstanding");
        }else if (Score==9){
            Gradetxt.setText("Excellent");
        }else if (Score==8){
            Gradetxt.setText("Good");
        }else{
            Gradetxt.setText("Average");
        }
        Retrybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,QuizActivity.class));
                ResultActivity.this.finish();
            }
        });
    }
}