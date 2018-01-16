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
    int winScoreTeamA;
    int winScoreTeamB;
    String valueTeamA;
    String valueTeamB;
    boolean deuce = false;
    boolean adInA = false;
    boolean adInB = false;
    boolean winner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPointTeamA(View view){
        //Adding Points
        if (scoreTeamA == 0 || scoreTeamA == 15){
            scoreTeamA = scoreTeamA + 15;
            valueTeamA = "";
        }
        else if (scoreTeamA == 30){
            scoreTeamA = scoreTeamA + 10;
            valueTeamA = "";
        }

        //Checking for Love/Advantage/Deuce
        if (scoreTeamA == 15 && scoreTeamB == 0 || scoreTeamA == 30 && scoreTeamB == 0 || scoreTeamA == 40 && scoreTeamB == 0) {
            valueTeamB = "Love";
        }

        if (scoreTeamA == 40 && scoreTeamB == 40 && !deuce){
            valueTeamA = "Deuce";
            valueTeamB = "Deuce";
            deuce = true;
            adScoreA = 0;
        }

        //Checking Winrate
        if (winner){
            winScoreTeamA++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            adScoreA = 0;
            adScoreB = 0;
            winner = false;
        }
        if (scoreTeamA == 40 && scoreTeamB == 0 || adScoreA == 2){
            winner = true;
        }

        //Displaying messages
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamA(winScoreTeamA);
    }

    public void AdInTeamA(View view){
        if (deuce && adScoreA == 0 || deuce && adScoreA == 1){
            valueTeamA = "Ad In";
            valueTeamB = "Deuce";
            adScoreA++;
            adScoreB = 0;
        }
        if (scoreTeamA == 40 && scoreTeamB == 0 || adScoreA == 2){
            winner = true;
        }
        if (winner) {
            winScoreTeamA++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            adScoreA = 0;
            adScoreB = 0;
            winner = false;
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamA(winScoreTeamA);
    }


    public void addPointTeamB(View view){
        //Adding Points
        if (scoreTeamB == 0 || scoreTeamB == 15){
            scoreTeamB = scoreTeamB + 15;
            valueTeamB = "";
        }
        else if (scoreTeamB == 30){
            scoreTeamB = scoreTeamB + 10;
            valueTeamB = "";
        }

        //Checking for Love/Advantage/Deuce
        if (scoreTeamB == 15 && scoreTeamA == 0 || scoreTeamB == 30 && scoreTeamA == 0 || scoreTeamB == 40 && scoreTeamA == 0) {
            valueTeamA = "Love";
        }

        if (scoreTeamA == 40 && scoreTeamB == 40 && !deuce){
            valueTeamA = "Deuce";
            valueTeamB = "Deuce";
            deuce = true;
            adScoreB = 0;
        }

        //Checking Winrate
        if (winner){
            winScoreTeamB++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            adScoreA = 0;
            adScoreB = 0;
            winner = false;
        }
        if (scoreTeamB == 40 && scoreTeamA == 0 || adScoreB == 2){
            winner = true;
        }

        //Displaying messages
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamB(winScoreTeamB);
    }

    public void AdInTeamB(View view){
        if (deuce && adScoreB == 0 || deuce && adScoreB == 1){
            valueTeamB = "Ad In";
            valueTeamA = "Deuce";
            adScoreB++;
            adScoreA = 0;
        }
        if (scoreTeamB == 40 && scoreTeamA == 0 || adScoreB == 2){
            winner = true;
        }
        if (winner) {
            winScoreTeamB++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            adScoreA = 0;
            adScoreB = 0;
            valueTeamA = "";
            valueTeamB = "";
            deuce = false;
            adInA = false;
            adInB = false;
            winner = false;
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamB(winScoreTeamB);
    }

    public void reset(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        adScoreA = 0;
        adScoreB = 0;
        winScoreTeamA = 0;
        winScoreTeamB = 0;
        deuce = false;
        adInA = false;
        adInB = false;
        winner = false;
        valueTeamA = "";
        valueTeamB = "";
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAMessage(valueTeamA);
        displayBMessage(valueTeamB);
        displayScoreForTeamA(winScoreTeamA);
        displayScoreForTeamB(winScoreTeamB);
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
}