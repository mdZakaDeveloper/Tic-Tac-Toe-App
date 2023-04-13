package com.project.tiktactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Boolean gameAcive = true;
    

    int activePlayer = 0;
    TextView status;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
//    State Meaning
//    0 - O
//    1 - X
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                          {0,3,6}, {1,4,7}, {2,5,8},
                          {0,4,8}, {2,4,6}};
    public void playerTap(View view){
        status = findViewById(R.id.textView);
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameAcive){
            gameReset();
        }
        if (gameState[tappedImage] == 2 && gameAcive){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                TextView status  = findViewById(R.id.textView);
                img.setImageResource(R.drawable.o);
                activePlayer = 1;
                status.setText("Player 2's Chance");
            }
            else{
                img.setImageResource(R.drawable.x);
                activePlayer = 0;
                TextView status  = findViewById(R.id.textView);
                status.setText("Player 1's Chance");
            }
            img.animate().translationYBy(1000f).setDuration(200);

        }

        for(int[] winPosition : winPositions){
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2){

                // A Player has Won!

                String winnText;
                gameAcive = false;
                if(gameState[winPosition[0]] == 0){
                    winnText = "Player One has Won the Game!";

                }
                else{
                    winnText = "Player Two has Won!";
                }

                TextView status  = findViewById(R.id.textView);
                status.setText(winnText);
                }

        }




    }

    private void gameReset() {
        gameAcive = true;
        activePlayer = 0;
        for(int i = 0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.one)).setImageResource(0);
        ((ImageView) findViewById(R.id.two)).setImageResource(0);
        ((ImageView) findViewById(R.id.three)).setImageResource(0);
        ((ImageView) findViewById(R.id.four)).setImageResource(0);
        ((ImageView) findViewById(R.id.five)).setImageResource(0);
        ((ImageView) findViewById(R.id.six)).setImageResource(0);
        ((ImageView) findViewById(R.id.seven)).setImageResource(0);
        ((ImageView) findViewById(R.id.eight)).setImageResource(0);
        ((ImageView) findViewById(R.id.nine)).setImageResource(0);

        TextView status  = findViewById(R.id.textView);
        status.setText("Player 1's Chance");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}