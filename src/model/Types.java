package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Types{
    String []types = new String[20];
    private BufferedReader typesJson;
    {
        try {
            typesJson = new BufferedReader(new FileReader("data/json_files/types.json"));
            StringBuilder aux = new StringBuilder();
            while(typesJson.ready()){
                aux.append(typesJson.readLine());
            }
            JSONObject jsonData = new JSONObject(aux.toString());
            JSONArray results = jsonData.getJSONArray("results");
            for(int i = 0; i < 18; i++){
                JSONObject name = results.getJSONObject(i);
                types[i] = name.getString("name");
                for(int j = 0; j < i; j++){
                    if(types[j].compareTo(types[i]) > 0){
                        String auxStr = types[j];
                        types[j] = types[i];
                        types[i] = auxStr;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Types(){

    }
    public ArrayList<Object> comparePokemonTypes(String type, ArrayList <Pokemon> pokemons){
        ArrayList <Object> pokemonNames = new ArrayList<Object>();
        int j = 0, k = 0;
        for(int i = 0; i < 721; i++){
            if(type.equals(pokemons.get(i).getPokemonType1()) || type.equals(pokemons.get(i).getPokemonType2())){
                pokemonNames.add(pokemons.get(i).getName());
                for(j = 0; j < k; j++){
                    if(pokemonNames.get(j).toString().compareTo(pokemonNames.get(k).toString()) > 0){
                        Collections.swap(pokemonNames, j, k);
                    }
                }
                k++;
            }
        }
        return pokemonNames;
    }
    public Pokemon comparePokemonInfo(String name){
        int i;
        Pokemon pokemon = new Pokemon();

        for(i = 0; i < 721; i++){
            if(name.equals(Pokedex.allPokemons.get(i).getName().toString())){
                return Pokedex.allPokemons.get(i);
            }
        }
        return pokemon;
    }
    public Object[] getNameTypes() {
        return types;
    }

    public ArrayList<Object> getAllPokemonNames(){
        ArrayList<Object> names = new ArrayList<Object>();
        int i, j;
        for(i = 0; i < 721; i++){
            names.add(Pokedex.allPokemons.get(i).getName());
            for(j = 0; j < i; j++){
                if(names.get(j).toString().compareTo(names.get(i).toString()) > 0){
                    Collections.swap(names, j, i);
                }
            }
        }
        return names;
    }
    public static int caso = -1;
}