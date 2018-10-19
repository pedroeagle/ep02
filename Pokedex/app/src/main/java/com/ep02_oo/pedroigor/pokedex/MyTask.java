package com.ep02_oo.pedroigor.pokedex;

import android.os.AsyncTask;

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

public class MyTask extends AsyncTask<String, Void, String>{
@Override
protected void onPreExecute() {
        super.onPreExecute();
}
@Override
protected String doInBackground(String... strings) {
        String stringUrl = strings[0];
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        StringBuffer buffer = null;
        try {
        URL url = new URL(stringUrl);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        inputStream = conexao.getInputStream();
        //lê os dados em bytes e decodifica para caracteres não legíveis
        inputStreamReader = new InputStreamReader(inputStream);
        //faz a conversão para leitura dos caracteres legiveis
        BufferedReader reader = new BufferedReader(inputStreamReader);
        buffer = new StringBuffer();
        String linha = "";
        //leitura de todas as linhas enquanto houver linhas
        while((linha = reader.readLine())!=null){
        buffer.append(linha);
        }
        } catch (MalformedURLException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        return buffer.toString();
}
protected void onPostExecute(String pokemon) {
            super.onPostExecute(pokemon);
            String results = null;
            try {
                JSONObject api = new JSONObject(pokemon);//objeto da api principal
                results = api.getString("results");
                JSONArray nameUrl = new JSONArray(results);
                for(int i = 0; i < api.getInt("count"); i++) {
                    results = nameUrl.getString(i);
                    JSONObject name = new JSONObject(results);
                    results = name.getString("name");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //MainActivity.text.setText(results); //tem que tirar o comentário pra fazer alteração no textview
        }
}
