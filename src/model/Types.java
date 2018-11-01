package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            for(int i = 0; i < 20; i++){
                JSONObject name = results.getJSONObject(i);
                types[i] = name.getString("name");
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
        int j = 0;
        for(int i = 0; i < 721; i++){
            if(type.equals(pokemons.get(i).getPokemonType1()) || type.equals(pokemons.get(i).getPokemonType2())){
                pokemonNames.add(pokemons.get(i).getName());
            }
        }
        return pokemonNames;
    }
    public Pokemon comparePokemonInfo(String name){
        int i;
        Pokemon pokemon = new Pokemon();
        for(i = 0; i < 721; i++){
            System.out.println(Pokedex.allPokemons.get(i));
            if(Pokedex.allPokemons.get(i).equals(name)){
                pokemon = Pokedex.allPokemons.get(i);
                break;
            }
        }
        return pokemon;
    }
    public Object[] getNameTypes() {
        return types;
    }
}