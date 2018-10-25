package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;



public class Types extends Pokedex{
    private String conteudoDaApi;
    private StringBuffer aux;

    public String getNameTypes(int index) {
        return nameTypes.get(index);
    }

    public String getUrlTypes(int index) {
        return urlTypes.get(index);
    }

    ArrayList <String> nameTypes = new ArrayList<>();
    ArrayList <String> urlTypes = new ArrayList<>();

    {
        aux = new StringBuffer();
    }

    Types(String urlApi) throws IOException{
        this.conteudoDaApi = conteudoDaApi;
        URL api = new URL(urlApi);
        HttpURLConnection conexao = (HttpURLConnection) api.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setConnectTimeout(15000);
        conexao.connect();
        int codigoDeResposta = conexao.getResponseCode();
        if(codigoDeResposta != 200) {
            throw new RuntimeException("HttpResponseCode: "+codigoDeResposta);
        }
        else {
            Scanner infoApi = new Scanner(api.openStream());
            while(infoApi.hasNext()){
                aux.append(infoApi.nextLine());
            }
            conteudoDaApi = aux.toString();
            JSONObject results = new JSONObject(conteudoDaApi);
            JSONArray types;
            types = results.getJSONArray("results");
            JSONObject nameObject = new JSONObject();
            for(int i = 0; i < types.length(); i++) {
                nameObject = types.getJSONObject(i);
                nameTypes.add(nameObject.getString("name"));
                urlTypes.add(nameObject.getString("url"));
            }
            infoApi.close();
        }
    }
}