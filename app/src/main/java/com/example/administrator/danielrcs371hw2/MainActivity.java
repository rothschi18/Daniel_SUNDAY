package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static com.example.administrator.danielrcs371hw2.R.mipmap.player1;


public class MainActivity extends ActionBarActivity {


    public static TeamRosterDatabase TeamData;
    public ImageButton[] playerButtons;
    //I want to preserve the order that teams are shown on the main page
    public PlayerStats playerShown;
    public static TeamRoster team;
    public LinkedHashMap<TeamRoster, Button> mainTeamButtons;
    HashMap<ImageButton, String> PlayerImages;
    public static String newTeam;
    protected void onCreate(Bundle savedInstanceState) {
        /*
        EditText newText = (EditText)findViewById(R.id.editText);
        if(newText.getText().toString()!=null) {
            Log.i("MESSAGE", newText.getText().toString());
        }
        */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayerImages = new HashMap<ImageButton, String>();

        //Because onCreate is called everytime we return to the main activity,
        //only create a new Team roster the first time the program is loaded
        if(TeamData==null) {

            TeamData = new TeamRosterDatabase(this);
            TeamData.declareTeams();
        }


        //viewTeams has to be called to refresh the current activity that is being worked on
        TeamData.viewTeams(this);

        playerButtons = new ImageButton[15];

        playerButtons[0] = (ImageButton)this.findViewById(R.id.player1);
        playerButtons[1] = (ImageButton)this.findViewById(R.id.player2);
        playerButtons[2] = (ImageButton)this.findViewById(R.id.player3);
        playerButtons[3] = (ImageButton)this.findViewById(R.id.player4);
        playerButtons[4] = (ImageButton)this.findViewById(R.id.player5);
        playerButtons[5] = (ImageButton)this.findViewById(R.id.player6);
        playerButtons[6] = (ImageButton)this.findViewById(R.id.player7);
        playerButtons[7] = (ImageButton)this.findViewById(R.id.player8);
        playerButtons[8] = (ImageButton)this.findViewById(R.id.player9);
        playerButtons[9] = (ImageButton)this.findViewById(R.id.player10);
        playerButtons[10] = (ImageButton)this.findViewById(R.id.player11);
        playerButtons[11] = (ImageButton)this.findViewById(R.id.player12);
        playerButtons[12] = (ImageButton)this.findViewById(R.id.player13);
        playerButtons[13] = (ImageButton)this.findViewById(R.id.player14);
        playerButtons[14] = (ImageButton)this.findViewById(R.id.player15);





    }

    public void deletePlayer(View view)
    {
        Intent intent = new Intent(this, DeletePlayer.class);
        startActivity(intent);
    }




    public void sendButtonID(View view)
    {
        team = TeamData.getTeamRoster((Button)view);

        if(team==null)
            return;

        team.showPlayers(playerButtons);
    }

    public void viewStats(View view)
    {

        //pass in an array of text fields to be set
        //playerShown = TeamData.returnPlayer(view);
        String playerName = "";
        PlayerStats player = new PlayerStats();

        PlayerImages = TeamData.createPlayerMap(PlayerImages, playerButtons, team);

        for(ImageButton image: PlayerImages.keySet())
        {
            if((view) == (image))
            {
                //Log.i("Inside Comparison", "setting player name");
                playerName = PlayerImages.get(image);

            }
        }

        for(String key: team.teamPlayers.keySet())
        {
            //Log.i("Players: ", team.teamPlayers.get(key).fullName + "searching..." + playerName);

            if(team.teamPlayers.get(key).fullName.equals(playerName))
            {
                //Log.i("Inside Comparison", "setting player");
                player = team.teamPlayers.get(key);
            }

        }
        TextView[] textBoxes = new TextView[6];
        textBoxes[0]= (TextView) this.findViewById(R.id.stats1);
        textBoxes[1]= (TextView) this.findViewById(R.id.stats2);
        textBoxes[2]= (TextView) this.findViewById(R.id.stats3);
        textBoxes[3]= (TextView) this.findViewById(R.id.stats4);
        textBoxes[4]= (TextView) this.findViewById(R.id.stats5);
        textBoxes[5]= (TextView) this.findViewById(R.id.stats6);

        textBoxes[0].setText("Goals Scored: " + player.goalsScored);
        textBoxes[1].setText("Fouls Commited: " + player.foulsCommitted);
        textBoxes[2].setText("Games Won: " + player.gamesWon);
        textBoxes[3].setText("First Name: " + player.firstName);
        textBoxes[4].setText("Last Name: " + player.lastName);
        textBoxes[5].setText("Team Name: " + player.team);







    }

    public void createTeam(View view)
    {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}