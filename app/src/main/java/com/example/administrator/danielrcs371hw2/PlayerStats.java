package com.example.administrator.danielrcs371hw2;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rothschi18 on 9/19/2015.
 * Class: PlayerStats
 * Purpose: To keep track of the statistics of an individual player object
 */
public class PlayerStats {
    protected int goalsScored;
    protected int foulsCommitted;
    protected int gamesWon;
    protected String firstName;
    protected String lastName;
    protected ImageView playerImage;
    protected String team;
    protected String fullName;

    /**
     * Constructor for PlayerStats,
     * @param goalsScored
     * @param foulsCommitted
     * @param gamesWon
     * @param firstName
     * @param lastName
     * @param playerImage
     */
    //if you want to instantiate a player without setting the data fields

    public PlayerStats(int goalsScored, int foulsCommitted,
                            int gamesWon, String firstName, String lastName, ImageView playerImage, String team)
    {
        this.goalsScored=goalsScored;
        this.foulsCommitted=foulsCommitted;
        this.gamesWon=gamesWon;
        this.firstName=firstName;
        this.lastName=lastName;
        this.playerImage=playerImage;
        this.team=team;
        this.fullName = firstName + " " + lastName;

    }

    public PlayerStats(){}

    public void viewStats(View view, TextView[] textField)
    {
        textField[0].setText("Goals Scored: " + goalsScored);
        textField[1].setText("Fouls Commited: " + foulsCommitted);
        textField[2].setText("Games Won: " + gamesWon);
        textField[3].setText("First Name: " + firstName);
        textField[4].setText("Last Name: " + lastName);
        textField[5].setText("Team Name: " + team);
    }

}
