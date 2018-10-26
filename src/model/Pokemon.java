package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
    private String conteudoDaApi;
    private StringBuffer aux;
    private ArrayList<String> pokemonAbilities;
    private ArrayList<String> pokemonAbilitiesUrl;

    public String getPokemonName(int index) {
        return pokemonName.get(index);
    }
    public String getPokemonUrl(int index) {
        return pokemonUrl.get(index);
    }

    ArrayList<String> pokemonName = new ArrayList<>();
    ArrayList<String> pokemonUrl = new ArrayList<>();

    {
        aux = new StringBuffer();
    }

    Pokemon(String urlApi) throws IOException {
        this.conteudoDaApi = conteudoDaApi;
        URL api = new URL(urlApi);
        HttpURLConnection conexao = (HttpURLConnection) api.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setConnectTimeout(15000);
        conexao.connect();
        int codigoDeResposta = conexao.getResponseCode();
        if (codigoDeResposta != 200) {
            throw new RuntimeException("HttpResponseCode: " + codigoDeResposta);
        } else {
            Scanner infoApi = new Scanner(api.openStream());
            while (infoApi.hasNext()) {
                aux.append(infoApi.nextLine());
            }
            conteudoDaApi = aux.toString();
            JSONObject results = new JSONObject(conteudoDaApi);
            JSONArray types;
            types = results.getJSONArray("results");
            JSONObject nameObject = new JSONObject();
            for (int i = 0; i < types.length(); i++) {
                nameObject = types.getJSONObject(i);
                pokemonName.add(nameObject.getString("name"));
                pokemonUrl.add(nameObject.getString("url"));
            }
            infoApi.close();
        }
    }


}
