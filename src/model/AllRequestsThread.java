package model;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AllRequestsThread extends Thread {
    public String[] getTypes() {
        return types;
    }

    //GET ALL TYPES FROM API
    String []types = new String[20];
    String [][]typesXpokemons;
    String []pokemons = new String[949];
    String []urlPokemons= new String[949];
    String [][]abilities = new String[949][3];
    int []experience = new int[949];
    int []height = new int[949];
    String []urlIcon = new String[949];
    ImageIcon []icon = new ImageIcon[949];
    int []speed = new int[949];
    int []spDefense = new int[949];
    int []spAtack = new int[949];
    int []defense = new int[949];
    int []atack = new int[949];
    int []hp = new int[949];
    int []weight = new int[949];
    @Override
    public void run() {
        try {
            URL urlTypes = new URL("https://pokeapi.co/api/v2/type/");

            HttpURLConnection typesConnection = (HttpURLConnection) urlTypes.openConnection();
            typesConnection.setRequestMethod("GET");
            typesConnection.setConnectTimeout(15000);
            typesConnection.connect();

            if (typesConnection.getResponseCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + typesConnection.getResponseCode());
            } else {
                Scanner readContent = new Scanner(urlTypes.openStream());
                StringBuffer getContent = new StringBuffer();
                while (readContent.hasNext()) {
                    getContent.append(readContent.nextLine());
                }
                String typesContent = new String(getContent.toString());
                JSONObject typesObject = new JSONObject(typesContent);

                URL urlTypesXPokemons;
                for (int i = 0; i < 18; i++) {
                    types[i] = typesObject.getJSONArray("results").getJSONObject(i).getString("name");
                    for(int j = 0; j < i; j++){
                        if(types[j].compareTo(types[i]) > 0){
                            String aux = types[i];
                            types[i] = types[j];
                            types[j] = aux;
                        }
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //O OBJETIVO ERA UTILIZAR TODAS AS REQUISOÇÕES ABAIXO PARA TODO O PROGRAMA PORÉM O TEMPO  PARA INCIAR
    //O PROGRAMA ERA DE APROXIMADAMENTE 5 MINUTOS PORTANTO, UTILIZANDO A API, FIZ A REQUISIÇÃO APENAS DOS TIPOS
    //COM O CÓDIGO ABAIXO É POSSÍVEL REQUISITAR TODOS OS DADOS DE TODOS OS POKEMONS
    //INCLUSO A RELAÇÃO ENTRE TIPOS E POKEMONS
    public void otherRun(){
        try {
            URL urlTypes = new URL("https://pokeapi.co/api/v2/type/");

            HttpURLConnection typesConnection = (HttpURLConnection) urlTypes.openConnection();
            typesConnection.setRequestMethod("GET");
            typesConnection.setConnectTimeout(15000);
            typesConnection.connect();

            if(typesConnection.getResponseCode() != 200) {
                throw new RuntimeException("HttpResponseCode: "+typesConnection.getResponseCode());
            }else{
                Scanner readContent = new Scanner(urlTypes.openStream());
                StringBuffer getContent = new StringBuffer();
                while(readContent.hasNext()){
                    getContent.append(readContent.nextLine());
                }
                String typesContent = new String(getContent.toString());
                JSONObject typesObject = new JSONObject(typesContent);

                URL urlTypesXPokemons;
                for(int i = 0; i < 20; i++){
                    types[i] = typesObject.getJSONArray("results").getJSONObject(i).getString("name");
                    urlTypesXPokemons = new URL(typesObject.getJSONArray("results").getJSONObject(i).getString("url"));
                    try {
                        HttpURLConnection connection = (HttpURLConnection) urlTypesXPokemons.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(15000);
                        connection.connect();
                        if(typesConnection.getResponseCode() != 200) {
                            throw new RuntimeException("HttpResponseCode: "+connection.getResponseCode());
                        }else {
                            Scanner readAllContent = new Scanner(urlTypesXPokemons.openStream());
                            StringBuffer getAllContent = new StringBuffer();
                            while (readAllContent.hasNext()) {
                                getAllContent.append(readAllContent.nextLine());
                            }
                            JSONObject typesXPokemonsObject = new JSONObject(getAllContent.toString());
                            typesXpokemons = new String[20][typesXPokemonsObject.getJSONArray("pokemon").length()];
                            for (int j = 0; j < typesXPokemonsObject.getJSONArray("pokemon").length(); j++) {
                                typesXpokemons[i][j] = typesXPokemonsObject.getJSONArray("pokemon").getJSONObject(j).getJSONObject("pokemon").getString("name");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //GET ALL POKEMON NAMES AND RESPECTIVE URL
        try {
            URL pokemonsUrl = new URL("https://pokeapi.co/api/v2/pokemon/");

            HttpURLConnection pokemonsConnection = (HttpURLConnection) pokemonsUrl.openConnection();
            pokemonsConnection.setRequestMethod("GET");
            pokemonsConnection.setConnectTimeout(15000);
            pokemonsConnection.connect();

            if(pokemonsConnection.getResponseCode() != 200) {
                throw new RuntimeException("HttpResponseCode: "+pokemonsConnection.getResponseCode());
            }else{
                Scanner readContent = new Scanner(pokemonsUrl.openStream());
                StringBuffer getContent = new StringBuffer();
                while(readContent.hasNext()){
                    getContent.append(readContent.nextLine());
                }
                String pokemonsContent = new String(getContent.toString());
                JSONObject typesObject = new JSONObject(pokemonsContent);
                for(int i = 0; i < 949; i++){
                    pokemons[i] = typesObject.getJSONArray("results").getJSONObject(i).getString("name");
                    urlPokemons[i] = typesObject.getJSONArray("results").getJSONObject(i).getString("url");
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for(int i = 0; i < 949; i++) {
                URL abilitiesUrl = new URL(urlPokemons[i]);

                HttpURLConnection abilitiesConnection = (HttpURLConnection) abilitiesUrl.openConnection();
                abilitiesConnection.setRequestMethod("GET");
                abilitiesConnection.setConnectTimeout(15000);
                abilitiesConnection.connect();

                if (abilitiesConnection.getResponseCode() != 200) {
                    throw new RuntimeException("HttpResponseCode: " + abilitiesConnection.getResponseCode());
                } else {
                    Scanner readContent = new Scanner(abilitiesUrl.openStream());
                    StringBuffer getContent = new StringBuffer();
                    while (readContent.hasNext()) {
                        getContent.append(readContent.nextLine());
                    }
                    String pokemonsContent = new String(getContent.toString());
                    JSONObject pokemonsObject = new JSONObject(pokemonsContent);
                    for(int j = 0; j < pokemonsObject.getJSONArray("abilities").length(); j++) {
                        abilities[i][j] = pokemonsObject.getJSONArray("abilities").getJSONObject(j).getJSONObject("ability").getString("name");
                    }
                    experience[i] = pokemonsObject.getInt("base_experience");
                    height[i] = pokemonsObject.getInt("height");
                    urlIcon[i] = pokemonsObject.getJSONObject("sprites").getString("front_default");
                    URL pokemonUrlIcon = new URL(urlIcon[i]);
                    icon[i] = new ImageIcon(pokemonUrlIcon);
                    while(icon[i].getImageLoadStatus() == MediaTracker.LOADING);




                    speed[i] = pokemonsObject.getJSONArray("stats").getJSONObject(0).getInt("base_stat");
                    spDefense[i] = pokemonsObject.getJSONArray("stats").getJSONObject(1).getInt("base_stat");
                    spAtack[i] = pokemonsObject.getJSONArray("stats").getJSONObject(2).getInt("base_stat");
                    defense [i] = pokemonsObject.getJSONArray("stats").getJSONObject(3).getInt("base_stat");
                    atack[i] = pokemonsObject.getJSONArray("stats").getJSONObject(4).getInt("base_stat");
                    hp[i] = pokemonsObject.getJSONArray("stats").getJSONObject(5).getInt("base_stat");
                    weight[i] = pokemonsObject.getInt("weight");

                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
