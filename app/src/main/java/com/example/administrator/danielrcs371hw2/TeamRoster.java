package com.example.administrator.danielrcs371hw2;

import android.app.Activity;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;



/**
 * Created by rothschi18 on 9/19/2015.
 */
public class TeamRoster {
    protected HashMap<String, PlayerStats> teamPlayers;
    protected String teamName;
    protected ImageView teamImage;
    // protected HashMap<ImageButton, PlayerStats> Team;

    public TeamRoster(String teamName, ImageView teamImage)
    {
        this.teamName=teamName;
        this.teamImage = teamImage;
        teamPlayers = new HashMap<String, PlayerStats>();

    }




    public void clearPlayers(ImageButton[] buttons)
    {
        //If their are no players on the team, reset all images to blank
        if (teamPlayers.size() == 0) {
            for (int i = 0; i < 15; i++) {
                teamImage.setImageResource(R.mipmap.blankteam);
                buttons[i].setVisibility(View.INVISIBLE);

            }

        }
    }

    public PlayerStats returnPlayer(View view)
    {
        PlayerStats player = new PlayerStats();

        for(String key: teamPlayers.keySet()){
            if(view.getResources()==teamPlayers.get(key).playerImage.getResources())
            {
                player = teamPlayers.get(key);
            }
        }
        return player;
    }
/*
    public void g(View view, TextView[] textField, PlayerStats player)
    {
        textField[0].setText("Goals Scored: " + player.goalsScored);
        textField[1].setText("Fouls Commited: " + player.foulsCommitted);
        textField[2].setText("Games Won: " + player.gamesWon);
        textField[3].setText("First Name: " + player.firstName);
        textField[4].setText("Last Name: " + player.lastName);
        textField[5].setText("Team Name: " + player.team);
    }
    */

    //now display the images for each player
    public void showPlayers(ImageButton[] buttons)
    {
        int counter = 0;

        for(String key: teamPlayers.keySet())
        {
            buttons[counter].setVisibility(View.VISIBLE);
            buttons[counter].setBackground(teamPlayers.get(key).playerImage.getDrawable());
            counter++;
        }



    }

    public void addPlayer(PlayerStats player)
    {
        String key = player.fullName;

        if(teamPlayers.containsKey(key))
        {
            return;
        }

        teamPlayers.put(key, player);

    }

    public String getTeamName()
    {
        return teamName;
    }

    public void addPlayerToTeam(PlayerStats player)
    {

    }
}