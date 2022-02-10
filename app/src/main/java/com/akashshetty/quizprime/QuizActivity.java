package com.akashshetty.quizprime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private TextView Scoretv,Questiontv;
    private Button Truebtn,Falsebtn;
    private ImageView image;
    private boolean ans;
    private int Score=0;
    private int questionNum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Scoretv=(TextView)findViewById(R.id.tvPoints);
        image=(ImageView)findViewById(R.id.imageview);
        Questiontv=(TextView)findViewById(R.id.tvQuestion);
        Truebtn=(Button)findViewById(R.id.btntrue);
        Falsebtn=(Button)findViewById(R.id.btnfalse);
        mainQuestion();
        //True button
        Truebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans==true){
                    Toast.makeText(QuizActivity.this,"Your answer was correct",Toast.LENGTH_LONG).show();
                    Score++;
                    mainScore(Score);
                    //If questions in quizbook was over then following code will excute
                    if (questionNum==QuizBook.questions.length){
                        Intent i=new Intent(QuizActivity.this,ResultActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("Finalscore :",Score);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{
                        //otherwise it will display the next question
                        mainQuestion();
                    }
                }
                else {
                    Toast.makeText(QuizActivity.this,"Your answer was not correct",Toast.LENGTH_LONG).show();
                    if (questionNum==QuizBook.questions.length){
                        Intent i=new Intent(QuizActivity.this,ResultActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("Finalscore :",Score);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{

                        mainQuestion();
                    }
                }
            }
        });
        //False button
        Falsebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans==false){
                    Toast.makeText(QuizActivity.this,"Your answer was correct",Toast.LENGTH_LONG).show();
                    Score++;
                    mainScore(Score);
                    if (questionNum==QuizBook.questions.length){
                        Intent i=new Intent(QuizActivity.this,ResultActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("Finalscore :",Score);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{
                        mainQuestion();
                    }
                }
                else {
                    Toast.makeText(QuizActivity.this,"Your answer was not correct",Toast.LENGTH_LONG).show();
                    if (questionNum==QuizBook.questions.length){
                        Intent i=new Intent(QuizActivity.this,ResultActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("Finalscore :",Score);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else{
                        mainQuestion();
                    }
                }
            }
        });


    }
    //It will update the next question along with image and answers
    private void mainQuestion(){
        image.setImageResource(QuizBook.images[questionNum]);
        Questiontv.setText(QuizBook.questions[questionNum]);
        ans=QuizBook.answers[questionNum];
        questionNum++;
    }
    //It will set the score
    public void mainScore(int point){
        Scoretv.setText("Your Score :"+Score);
    }
}