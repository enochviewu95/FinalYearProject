package com.example.avitor.finalyearproject;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Connecting extends AsyncTask {

    public static HttpURLConnection httpURLConnection;


    @Override
    protected Object doInBackground(Object[] objects) {
        String login_url = "http://10.0.2.2/FinalYearProject/LoginCredentials.php";
        try{
            URL url = new URL(login_url);
            httpURLConnection= (HttpURLConnection)url.openConnection();
            httpURLConnection.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpURLConnection;
    }
}
