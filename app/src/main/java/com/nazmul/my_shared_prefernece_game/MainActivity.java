package com.nazmul.my_shared_prefernece_game;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtHighScore,txtScore;
    Button btnPlay,btnReset;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    private final   String PREF_GAME = "com.nazmul.my_shared_prefernece_game.game";
/*
    TextView txtHighScore,txtScore;
    Button btnPlay,btnReset;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    // shared prefernce file name
    private final String PREF_GAME="com.myapp.sharedpreference.game";

 */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnPlay= findViewById(R.id.btn_play);
        btnReset = findViewById(R.id.btn_reset);
        txtHighScore=findViewById(R.id.txt_hight_score);
        txtScore= findViewById(R.id.txt_score);

/*
     pref = getSharedPreferences(PREF_GAME, MODE_PRIVATE);
     editor = pref.edit();


     final int highScore = pref.getInt("highScore: ",0);
     txtHighScore.setText("High score :"+highScore);


 */

      pref=getSharedPreferences(PREF_GAME,MODE_PRIVATE);
        editor=pref.edit();

        final int highScore=pref.getInt("highScore",0);
        txtHighScore.setText("High Score: "+highScore);


     btnPlay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
/*
             Random random= new Random();
             int score = random.nextInt(2000);

             txtScore.setText(String.valueOf(score));//// (String.Valueof(score));

             int getSaveScore  =  pref.getInt("highScore",0);

             if (score>getSaveScore){

                 txtHighScore.setText("High Score :"+ score);
                 editor.putInt("highScore :",score);
                 editor.apply();
             }

*/

             Random random=new Random();
             int score=random.nextInt(1000);
             txtScore.setText(String.valueOf(score));

             int getSavedScore=pref.getInt("highScore",0);

             if(score>getSavedScore)
             {
                 txtHighScore.setText("High Score: "+score);
                 editor.putInt("highScore",score);
                 editor.apply();

             }
         }
     });



     btnReset.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             editor.putInt("highScore",0);
             editor.apply();

             txtHighScore.setText("HighScore: "+0);
             txtScore.setText(String.valueOf(0));

         }
     });


    }
}


/*
    TextView txtHighScore,txtScore;
    Button btnPlay,btnReset;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    // shared prefernce file name
    private final String PREF_GAME="com.myapp.sharedpreference.game";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay=findViewById(R.id.btn_play);
        btnReset=findViewById(R.id.btn_reset);

        txtScore=findViewById(R.id.txt_score);
        txtHighScore=findViewById(R.id.txt_high_score);


        pref=getSharedPreferences(PREF_GAME,MODE_PRIVATE);
        editor=pref.edit();

        final int highScore=pref.getInt("highScore",0);
        txtHighScore.setText("High Score: "+highScore);






        btnPlay.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

        Random random=new Random();
        int score=random.nextInt(1000);
        txtScore.setText(String.valueOf(score));

        int getSavedScore=pref.getInt("highScore",0);

        if(score>getSavedScore)
        {
        txtHighScore.setText("High Score: "+score);
        editor.putInt("highScore",score);
        editor.apply();

        }

        }
        });




        btnReset.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

        editor.putInt("highScore",0);
        editor.apply();

        txtHighScore.setText("HighScore: "+0);
        txtScore.setText(String.valueOf(0));

        }
        });






        }
        }
*/
