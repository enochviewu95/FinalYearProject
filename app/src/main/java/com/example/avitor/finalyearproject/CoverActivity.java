package com.example.avitor.finalyearproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class CoverActivity extends Activity {

    //Boolean variable for the splash screen
    private static boolean splashLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //On create instance to start the application
        super.onCreate(savedInstanceState);

        /*Code to load the splash screen once*/
        if(!splashLoaded){

            setContentView(R.layout.activity_cover);                //Set the layout activity to the activity cover
            int secondsDelayed =1;                                  //initialize the delay seconds variable
            startConnection();                                      //Start the database connection


            new Handler().postDelayed(new Runnable(){               //Start new runnable to delay the loading of the login activity
                @Override                                           //Until database connection is established
                public void run() {
                    if(Connecting.httpURLConnection != null){       //If connection is established launch the login activity class
                        Intent intent = new Intent(CoverActivity.this,LoginActivity.class);     //the intent of the login activity
                        startActivity(intent);                                                              //The code to start the intent
                        finish();
                    }
                }
            },secondsDelayed * 500);

            splashLoaded = true;                //Set splashLoaded to true to prevent splash screen from
        }else{                                  //loading again when back button is pressed
            Intent goToMainActivity = new Intent(CoverActivity.this,LoginActivity.class);       //Intent to create login activity
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);                               //Using intent to make login activity the first
            startActivity(goToMainActivity);                                                                //to load when back button is pressed
            finish();
        }


    }

    /* Method to start connection to database*/

    public void startConnection(){
        Connecting connecting = new Connecting();
        connecting.execute("");
    }
}
