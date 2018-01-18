package com.example.android.scorekeepers;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int adScoreA = 0;
    int adScoreB = 0;
    int setScoreTeamA;
    int setScoreTeamB;
    int winScoreTeamA;
    int winScoreTeamB;
    String valueTeamA;
    String valueTeamB;
    boolean deuce = false;
    boolean adInA = false;
    boolean adInB = false;
    boolean setWinner = false;
    boolean winner = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPointTeamA(View view){
        //Win condition
        if (scoreTeamA == 40 && scoreTeamB == 0 || scoreTeamA == 40 && scoreTeamB == 15 || scoreTeamA == 40 && scoreTeamB == 30){
            setWinner = true;
        }
        //Adding Points
        if (scoreTeamA == 0 || scoreTeamA == 15){
            scoreTeamA = scoreTeamA + 15;
            valueTeamA = "";
        }
        else if (scoreTeamA == 30){
            scoreTeamA = scoreTeamA + 10;
            valueTeamA = "";
        }
        //Checking for Love/Deuce
        if (scoreTeamA == 15 && scoreTeamB == 0 || scoreTeamA == 30 && scoreTeamB == 0 || scoreTeamA == 40 && scoreTeamB == 0) {
            valueTeamB = "Love";
        } else if (scoreTeamA == 40 && scoreTeamB == 40 && !deuce){
            valueTeamA = "Deuce";
            valueTeamB = "Deuce";
            deuce = true;
            adScoreA = 0;
        }

        //Checking Winrate
        if (setWinner){
            setScoreTeamA++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            adScoreA = 0;
            adScoreB = 0;
            setWinner = false;
        }
        //Set score
        if (setScoreTeamA - setScoreTeamB >= 1 && setScoreTeamA >= 3){
            winner = true;
        }
        if (winner){
            winScoreTeamA++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            adScoreA = 0;
            adScoreB = 0;
            setScoreTeamA = 0;
            setScoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            winner = false;
            displayWinScoreForTeamA(winScoreTeamA);
        }
        //Displaying messages
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamA(setScoreTeamA);
        displayWinScoreForTeamA(winScoreTeamA);
        displayWinScoreForTeamB(winScoreTeamB);
    }

    public void AdInTeamA(View view){
        if (scoreTeamA == 40 && scoreTeamB == 40) {
            if (deuce && !adInA && !adInB || !deuce && adInA && adScoreA == 0 && !adInB || !deuce && adInA && adScoreA == 1 && !adInB || !deuce && !adInB) {
                adScoreA++;
                adScoreB = 0;
                valueTeamA = "Advantage";
                adInB = false;
                deuce = false;
                adInA = true;
            }
            if (adScoreB == 1 && adInB && !adInA || adInB && !adInA || adInB && adScoreB == 1 || adInA && adInB) {
                adScoreA = 0;
                adScoreB = 0;
                deuce = true;
                valueTeamA = "Deuce";
                valueTeamB = "Deuce";
                adInB = false;
            }
            if (adScoreA == 2) {
                setWinner = true;
            }
            if (setWinner) {
                setScoreTeamA++;
                scoreTeamA = 0;
                scoreTeamB = 0;
                valueTeamA = "";
                valueTeamB = "";
                deuce = false;
                adInA = false;
                adInB = false;
                adScoreA = 0;
                adScoreB = 0;
                setWinner = false;
            }
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayAMessage(valueTeamA);
            displayBMessage(valueTeamB);
            displayScoreForTeamA(setScoreTeamA);
            displayWinScoreForTeamA(winScoreTeamA);
            displayWinScoreForTeamB(winScoreTeamB);
        }
        //Set score
        if (setScoreTeamA - setScoreTeamB >= 1 && setScoreTeamA >= 3){
            winner = true;
        }
        if (winner){
            winScoreTeamA++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            adScoreA = 0;
            adScoreB = 0;
            setScoreTeamA = 0;
            setScoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            winner = false;
            displayWinScoreForTeamA(winScoreTeamA);
        }
    }


    public void addPointTeamB(View view){
        //Win condition
        if (scoreTeamB == 40 && scoreTeamA == 0 || scoreTeamB == 40 && scoreTeamA == 15 || scoreTeamB == 40 && scoreTeamA == 30) {
            setWinner = true;
        }
        //Adding Points
        if (scoreTeamB == 0 || scoreTeamB == 15){
            scoreTeamB = scoreTeamB + 15;
            valueTeamB = "";
        }
        else if (scoreTeamB == 30){
            scoreTeamB = scoreTeamB + 10;
            valueTeamB = "";
        }

        //Checking for Love/Deuce
        if (scoreTeamB == 15 && scoreTeamA == 0 || scoreTeamB == 30 && scoreTeamA == 0 || scoreTeamB == 40 && scoreTeamA == 0) {
            valueTeamA = "Love";
        } else if (scoreTeamA == 40 && scoreTeamB == 40 && !deuce){
            valueTeamA = "Deuce";
            valueTeamB = "Deuce";
            deuce = true;
            adScoreB = 0;
        }

        //Checking Winrate
        if (setWinner){
            setScoreTeamB++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            adScoreA = 0;
            adScoreB = 0;
            setWinner = false;
        }
        //Set score
        if (setScoreTeamA - setScoreTeamB >= 1 && setScoreTeamB >= 3){
            winner = true;
        }
        if (winner){
            winScoreTeamB++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            adScoreA = 0;
            adScoreB = 0;
            setScoreTeamA = 0;
            setScoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            winner = false;
            displayWinScoreForTeamA(winScoreTeamA);
        }
        //Displaying messages
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamB(setScoreTeamB);
        displayWinScoreForTeamA(winScoreTeamA);
        displayWinScoreForTeamB(winScoreTeamB);
    }

    public void AdInTeamB(View view){
        if (scoreTeamA == 40 && scoreTeamB == 40) {
            if (deuce && !adInB && !adInA || !deuce && adInB && adScoreB == 0 && !adInA || !deuce && adInB && adScoreB == 1 && !adInA || !deuce && !adInA) {
                adScoreB++;
                adScoreA = 0;
                valueTeamB = "Advantage";
                adInA = false;
                deuce = false;
                adInB = true;
            }
            if (adScoreA == 1 && adInA && !adInB || adInA && !adInB || adInA && adScoreA == 1 || adInA && adInB) {
                adScoreA = 0;
                adScoreB = 0;
                deuce = true;
                valueTeamA = "Deuce";
                valueTeamB = "Deuce";
                adInA = false;
            }

            if (adScoreB == 2) {
                setWinner = true;
            }
            if (setWinner) {
                setScoreTeamB++;
                scoreTeamA = 0;
                scoreTeamB = 0;
                adScoreA = 0;
                adScoreB = 0;
                valueTeamA = "";
                valueTeamB = "";
                deuce = false;
                adInA = false;
                adInB = false;
                setWinner = false;
            }
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayAMessage(valueTeamA);
            displayBMessage(valueTeamB);
            displayScoreForTeamB(setScoreTeamB);
            displayWinScoreForTeamA(winScoreTeamA);
            displayWinScoreForTeamB(winScoreTeamB);
        }
        //Set score
        if (setScoreTeamA - setScoreTeamB >= 1 && setScoreTeamB >= 3){
            winner = true;
        }
        if (winner){
            winScoreTeamB++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            adScoreA = 0;
            adScoreB = 0;
            setScoreTeamA = 0;
            setScoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            winner = false;
            displayWinScoreForTeamA(winScoreTeamA);
        }
    }

    public void reset(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        adScoreA = 0;
        adScoreB = 0;
        setScoreTeamA = 0;
        setScoreTeamB = 0;
        winScoreTeamA = 0;
        winScoreTeamB = 0;
        deuce = false;
        adInA = false;
        adInB = false;
        setWinner = false;
        valueTeamA = "";
        valueTeamB = "";
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamA(setScoreTeamA);
        displayScoreForTeamB(setScoreTeamB);
        displayWinScoreForTeamA(winScoreTeamA);
        displayWinScoreForTeamB(winScoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayAMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.team_a_value);
        priceTextView.setText(message);
    }
    private void displayBMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.team_b_value);
        priceTextView.setText(message);
    }

    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_win_team_a);
        scoreView.setText(String.valueOf(score));
    }

    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_win_team_b);
        scoreView.setText(String.valueOf(score));
    }

    public void displayWinScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.game_win_team_a);
        scoreView.setText(String.valueOf(score));
    }
    public void displayWinScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.game_win_team_b);
        scoreView.setText(String.valueOf(score));
    }
}