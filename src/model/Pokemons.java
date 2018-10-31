package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pokemons {
    //atributos dos pokemons
    private String conteudoDaApi;
    private String conteudoInfoPokemon;
    ArrayList<String> pokemonName = new ArrayList<>();
    ArrayList<String> pokemonUrl = new ArrayList<>();
    public String [][]pokemonAbilities;
    public String [][]pokemonTypes;
    int []pokemonExperience;
    //ArrayList<List<String>> pokemonAbilitiesUrl = new ArrayList<List<String>>();//caso dê tempo de detalhar as habilidades utilizo a url

    //variáveis auxiliares
    private StringBuffer aux1 = new StringBuffer();
    private StringBuffer aux2 = new StringBuffer();
    //getters
    public String getPokemonName(int index) {
        return pokemonName.get(index);
    }

    public String getPokemonUrl(int index) {
        return pokemonUrl.get(index);
    }
    //Todos o setter são realizados automaticamente no construtor para reduzir o tempo de execução
    public Pokemons(String urlApi) throws IOException {
        BufferedReader teste = new BufferedReader(new FileReader("data/json_files/pokemonsName.json"));
        URL api = new URL(urlApi); //URL da api de todos os pokemons
        HttpURLConnection conexao = (HttpURLConnection) api.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setConnectTimeout(15000);
        conexao.connect();
        //Testa se a conexão foi bem sucedida:
        if (conexao.getResponseCode() != 200) {
            throw new RuntimeException("HttpResponseCodePokemonNames: " + conexao.getResponseCode());
        } else {
            //lê o conteúdo da api
            Scanner infoApi = new Scanner(api.openStream());
            while (infoApi.hasNext()) {
                aux1.append(infoApi.nextLine());
            }

            //transforma todo o conteúdo da api em um objeto
            conteudoDaApi = aux1.toString();
            JSONObject apiObject = new JSONObject(conteudoDaApi);
            JSONArray names;
            names = apiObject.getJSONArray("results");
            JSONObject namesObject = new JSONObject();

            aux1.setLength(0);

            //instancia os atributos que receberão informações
            pokemonAbilities = new String[names.length()][100];
            pokemonExperience = new int[949];
            pokemonTypes = new String[names.length()][100];

            //passa por todos os nomes e pra cada nome armazena habilidades, experiência, tipo e url do pokemon
            int i;
            int j;
            for (i = 0; i < names.length(); i++) {
                namesObject = names.getJSONObject(i);
                pokemonName.add(namesObject.getString("name"));
                pokemonUrl.add(namesObject.getString("url"));

                //pega a URL do pokemon
                URL abilities = new URL(pokemonUrl.get(i).toString());
                //inicia uma conexão das informações individuais do pokemon
                HttpURLConnection conexaoInfoPokemon = (HttpURLConnection) abilities.openConnection();
                conexaoInfoPokemon.setRequestMethod("GET");
                conexaoInfoPokemon.setConnectTimeout(15000);
                conexaoInfoPokemon.connect();

                //leitura das informações de cada pokemon
                if (conexaoInfoPokemon.getResponseCode() != 200) {
                    throw new RuntimeException("HttpResponseCodeInfoPokemon: " + conexaoInfoPokemon.getResponseCode());
                } else {
                    Scanner infoPokemon = new Scanner(abilities.openStream());
                    while (infoPokemon.hasNext()) {
                        aux2.append(infoPokemon.nextLine());
                    }
                    conteudoInfoPokemon = aux2.toString();
                    aux2.setLength(0);
                    JSONObject infoObject= new JSONObject(conteudoInfoPokemon);
                    JSONObject pokemonAux = new JSONObject();
                    JSONArray abilityArray = new JSONArray();
                    JSONArray typesArray = new JSONArray();
                    abilityArray = infoObject.getJSONArray("abilities");
                    typesArray = infoObject.getJSONArray("types");
                    pokemonExperience[i] = infoObject.getInt("base_experience");
                    ArrayList <String> auxList = null;
                    JSONObject abilitiesObject = new JSONObject();
                    for (j = 0; j < abilityArray.length(); j++) {
                        pokemonAux = abilityArray.getJSONObject(j);
                        abilitiesObject = pokemonAux.getJSONObject("ability");
                        pokemonAbilities[i][j] = abilitiesObject.getString("name").toString();
                    }
                    pokemonAux = null;
                    JSONObject typesObject = new JSONObject();
                    for(j = 0; j < typesArray.length(); j++){
                        pokemonAux = typesArray.getJSONObject(j);
                        typesObject = pokemonAux.getJSONObject("type");
                        pokemonTypes[i][j] = typesObject.getString("name");
                    }
                }
            }
            infoApi.close();
        }
    }
}
