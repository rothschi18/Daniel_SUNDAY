package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class DeletePlayer extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_player);
    }

    public void deletePlayerAndReturn(View view)
    {

        //Create a variable equal to the Edit Text field on the screen
        EditText player = (EditText)this.findViewById(R.id.deletePlayer);
        //Log.i("PLAYER NAME", player.getText().toString());
        //Loop through all the teams in the database
        for(String key: MainActivity.TeamData.rosterDatabase.keySet())
        {
            /*
            must use this style iterator for deleting elements over hashmaps
            
            Iterator<Map.Entry<String,String>> iter = TestMap.entrySet().iterator();
                while (iter.hasNext()) {
                 Map.Entry<String,String> entry = iter.next();
                 if("Sample".equalsIgnoreCase(entry.getValue())){
                     iter.remove();
    }
}

             */
            //loop through that team and try to find the player
            for (String name: MainActivity.TeamData.rosterDatabase.get(key).teamPlayers.keySet())
            {
                Log.i("PLAYER NAME vs Key", player.getText().toString() + " "+ name);
                if(name.equals(player.getText().toString()))
                {
                    //Remove the player:
                    Log.i("DELETING PLAYER:", player.getText().toString() );
                    MainActivity.TeamData.rosterDatabase.get(key).teamPlayers.remove(name);
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delete_player, menu);
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
