package com.pedroigor.pokedex;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Task extends AsyncTask<String, Integer, String> {
    String apiUrl = new String();
    String []types = new String[20];
    @Override
    protected String doInBackground(String... strings) {
        apiUrl = strings[0];
        InputStream inputStream = null;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            inputStream = conexao.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer buffer = null;
        buffer = new StringBuffer();
        String linha = "";

        while (true){
            try {
                linha = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(linha == null){
                break;
            }
            else{
                buffer.append(linha);
                continue;
            }
        }
        return buffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String type = null;
        if (apiUrl == "https://pokeapi.co/api/v2/type/") {
            try {
                JSONObject api = new JSONObject(s);
                type = api.getString("results");
                JSONArray results = new JSONArray(type);
                for (int i = 0; i < api.getInt("count"); i++) {
                    type = results.getString(i);
                    JSONObject names = new JSONObject(type);
                    type = names.getString("name");
                    types[i] = type;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public String[] getTypes() {
        return types;
    }
}

