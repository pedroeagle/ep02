package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Types{
    String[] types = Pokedex.thread.getTypes();
    String[] typesObsolete = null;
    private BufferedReader typesJson;
    //O CÓDIGO ABAIXO (dentro do méotod Obsolete) SE TORNOU OBSOLETO POIS A REQUISIÇÃO DE TIPOS AGORA É FEITA
    //POR MEIO DA API
    public String [] Obsolete() {
        {
            try {
                typesJson = new BufferedReader(new FileReader("data/json_files/types.json"));
                StringBuilder aux = new StringBuilder();
                while (typesJson.ready()) {
                    aux.append(typesJson.readLine());
                }
                JSONObject jsonData = new JSONObject(aux.toString());
                JSONArray results = jsonData.getJSONArray("results");
                for (int i = 0; i < 18; i++) {
                    JSONObject name = results.getJSONObject(i);
                    typesObsolete[i] = name.getString("name");
                    typesObsolete[i] = typesObsolete[i].toLowerCase();
                    for (int j = 0; j < i; j++) {
                        if (typesObsolete[j].compareTo(typesObsolete[i]) > 0) {
                            String auxStr = typesObsolete[j];
                            typesObsolete[j] = typesObsolete[i];
                            typesObsolete[i] = auxStr;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return typesObsolete;
    }
    public Types(){

    }
    public ArrayList<Object> comparePokemonTypes(String type, ArrayList <Pokemon> pokemons){
        ArrayList <Object> pokemonNames = new ArrayList<Object>();
        int j = 0, k = 0;
        for(int i = 0; i < 721; i++){
            if(type.equals(pokemons.get(i).getPokemonType1().toLowerCase()) || type.equals(pokemons.get(i).getPokemonType2().toLowerCase())){
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

    public Object [] comparePokemonTypes2(String type, ArrayList <Pokemon> pokemons){
       Object[] pokemonNames = new Object[721];
        int j = 0, k = 0, l = 0;
        for(int i = 0; i < 721; i++){
            if(type.equals(pokemons.get(i).getPokemonType1().toLowerCase()) || type.equals(pokemons.get(i).getPokemonType2().toLowerCase())){
                pokemonNames[l] = (pokemons.get(i).getName());
                for(j = 0; j < l; j++){
                    if(pokemonNames[l].toString().compareTo(pokemonNames[k].toString()) > 0){
                        Object aux = pokemonNames[l];
                        pokemonNames[l] = pokemonNames[k];
                        pokemonNames[k] = aux;
                    }
                }
                l++;
                k++;
            }
        }
        return pokemonNames;
    }


    public Pokemon comparePokemonInfo(String name){
        String theName = name.toLowerCase();
        int i;
        Pokemon pokemon = new Pokemon();

        for(i = 0; i < 721; i++){
            if(theName.equals(Pokedex.allPokemons.get(i).getName().toLowerCase())){
                return Pokedex.allPokemons.get(i);
            }
        }
        return null;
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