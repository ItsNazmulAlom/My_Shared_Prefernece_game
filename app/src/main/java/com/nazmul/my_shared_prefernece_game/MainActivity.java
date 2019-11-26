package com.nazmul.my_shared_prefernece_game;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnPlay,btnReset;
    TextView textHighScore,textScore;

    // Declare share prefernece

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    public  String Pref_Game = "com.nazmul.my_shared_prefernece_game.highscore";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnPlay= findViewById(R.id.btn_play);
        btnReset = findViewById(R.id.btn_reset);
        textHighScore=findViewById(R.id.txt_hight_score);
        textScore= findViewById(R.id.txt_score);


     preferences = getSharedPreferences(Pref_Game, MODE_PRIVATE);
     editor = preferences.edit();


     final int highscore = preferences.getInt("highscore :",0);
     textHighScore.setText("High score :"+highscore);


     btnPlay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Random random= new Random();
             int score = random.nextInt(2000);
             textScore.setText(""+score);// (String.Valueof(score));
             int getSaveScore  =  preferences.getInt("hight_score",0);
             if (score>getSaveScore){
                 textHighScore.setText("High Score :"+ score);
                 editor.putInt("High score :",score);
                 editor.commit();
             }
         }
     });


    }
}
