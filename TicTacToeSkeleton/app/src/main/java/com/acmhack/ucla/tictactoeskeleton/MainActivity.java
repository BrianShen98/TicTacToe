package com.acmhack.ucla.tictactoeskeleton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    // optional variables

    int activePlayer = 0;
    boolean gameIsActive = true;
    int[] gameState;
    ImageView img;
    TextView msg;
    LinearLayout linear ;
    GridLayout grid;
    //This function should be used to drop in image views when pressed
    //it should update the game state and active player
    //it should determine if somebody has won the game
    //if game is over it should display a dialog indicating winner
    //it should check for draws
    //Optional: Add in animation that causes tiles to fly in or fade in
    public void dropIn(View view) {


            img = (ImageView) view;
            int num = Integer.parseInt(view.getTag().toString());
        if(gameIsActive) {
            if (gameState[num] == 2) {
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.ucla_bruin);
                    gameState[num] = 0;
                    activePlayer = 1;
                } else {
                    img.setImageResource(R.drawable.usc_trojan);
                    gameState[num] = 1;
                    activePlayer = 0;
                }
            }


            for (int i = 0; i <= 2; i++) {
                if (gameState[i * 3] == gameState[i * 3 + 1] && gameState[i * 3 + 2] == gameState[i * 3] && gameState[i * 3] != 2) {
                    gameIsActive = false;
                    linear.setVisibility(View.VISIBLE);
                    if (gameState[i * 3] == 1)
                        msg.setText("Trojan wins!");
                    else
                        msg.setText("Bruin wins!");
                    break;
                } else if (gameState[i] == gameState[i + 3] && gameState[i + 6] == gameState[i] && gameState[i] != 2) {
                    linear.setVisibility(View.VISIBLE);
                    gameIsActive = false;
                    if (gameState[i] == 1)
                        msg.setText("Trojan wins!");
                    else
                        msg.setText("Bruin wins!");
                    break;
                } else if (gameState[0] == gameState[4] && gameState[4] == gameState[8] && gameState[0] != 2) {
                    linear.setVisibility(View.VISIBLE);
                    gameIsActive = false;
                    if (gameState[0] == 1)
                        msg.setText("Trojan wins!");
                    else
                        msg.setText("Bruin wins!");
                    break;
                } else if (gameState[2] == gameState[4] && gameState[4] == gameState[6] && gameState[2] != 2) {
                    linear.setVisibility(View.VISIBLE);
                    gameIsActive = false;
                    if (gameState[0] == 1)
                        msg.setText("Trojan wins!");
                    else
                        msg.setText("Bruin wins!");
                    break;
                }
                int q;
                for (q = 0; q < 9; q++)
                    if (gameState[q] == 2)
                        break;
                if (q == 9) {
                    linear.setVisibility(View.VISIBLE);
                    gameIsActive = false;
                    msg.setText("Draw!");
                }
            }
        }


    }

    //Should reset game to initial state, and update all variables
    //It should hide dialog box
    public void playAgain(View view) {
        activePlayer = 0;
        gameIsActive = true;
        Arrays.fill(gameState,2);
        linear.setVisibility(View.INVISIBLE);
        for(int i =0;i<9;i++)
        {
            img = (ImageView)grid.findViewWithTag(Integer.toString(i));
            img.setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameState = new int[9];
        Arrays.fill(gameState,2);
        msg = (TextView)findViewById(R.id.winnerMessage);
        linear= (LinearLayout)findViewById(R.id.playAgainLayout);
        grid = (GridLayout)findViewById(R.id.gridLayout);

    }
}
