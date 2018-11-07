package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;

public class User extends Trainer {
    public User() {

    }

    public boolean CreateUser(String name, String password) throws IOException {
        int count = 0;
        boolean exist = false;
        JSONArray userJsonArray = new JSONArray();
        BufferedReader infoReader = null;
        try {
            infoReader = new BufferedReader(new FileReader("data/json_files/users.json"));
            StringBuilder aux = new StringBuilder();
            while (infoReader.ready()) {
                try {
                    aux.append(infoReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            JSONObject infoJson = new JSONObject(aux.toString());
            count = infoJson.getInt("count");
            userJsonArray = infoJson.getJSONArray("users");
            for (int i = 0; i < count; i++) {
                String[] compareName = new String[count];
                compareName[i] = userJsonArray.getJSONObject(i).getString("name");
                JSONObject compareNameObject = new JSONObject();
                if (compareName[i].equals(name)) {
                    exist = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (exist) {
            return true;
        } else {
            FileWriter salvarRegistro;
            JSONObject fileJson = new JSONObject();
            count++;
            fileJson.put("count", count);
            JSONObject nameJson = new JSONObject();
            nameJson.put("name", name);
            nameJson.put("password", password);
            nameJson.put("experience", 60);
            nameJson.put("n", 0);
            JSONArray pokemonsArray = new JSONArray();
            nameJson.put("pokemons", (Object) pokemonsArray);
            userJsonArray.put(nameJson);
            fileJson.put("users", userJsonArray);
            try {
                salvarRegistro = new FileWriter("data/json_files/users.json");
                salvarRegistro.write(fileJson.toString(2));
                salvarRegistro.close();
                getAllUserData(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean LoginUser(String name, String password) throws IOException {
        int count = 0;
        boolean exist = false;
        JSONArray userJsonArray = new JSONArray();
        BufferedReader infoReader = new BufferedReader(new FileReader("data/json_files/users.json"));

        StringBuilder aux = new StringBuilder();
        while (infoReader.ready()) {
            aux.append(infoReader.readLine());
        }
        try {
            JSONObject infoJson = new JSONObject(aux.toString());
            count = infoJson.getInt("count");
            userJsonArray = infoJson.getJSONArray("users");
            String[] compareName = new String[count];
            String[] comparePass = new String[count];
            for (int i = 0; i < count; i++) {
                compareName[i] = userJsonArray.getJSONObject(i).getString("name");
                comparePass[i] = userJsonArray.getJSONObject(i).getString("password");
                JSONObject compareNameObject = new JSONObject();
                if (compareName[i].equals(name)) {
                    if (comparePass[i].equals(password)) {
                        exist = true;
                    } else {
                        exist = false;
                    }
                    break;
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return exist;
    }

    public static Trainer treinador = new Trainer();
    Object[][] trainerPokemons;
    int count = 0;

    public void getAllUserData(String name) throws IOException {
        JSONArray userJsonArray = new JSONArray();
        BufferedReader infoReader = new BufferedReader(new FileReader("data/json_files/users.json"));
        StringBuilder aux = new StringBuilder();

        while (infoReader.ready()) {
            aux.append(infoReader.readLine());
        }
        JSONObject infoJson = new JSONObject(aux.toString());
        count = infoJson.getInt("count");
        userJsonArray = infoJson.getJSONArray("users");
        String[] compareName = new String[count];

        ArrayList <String> trainerNames = new ArrayList<>();
        trainerPokemons = new Object[count][1000];
        int n;
        for (int i = 0; i < count; i++) {
            trainerNames.add(userJsonArray.getJSONObject(i).getString("name"));
            compareName[i] = userJsonArray.getJSONObject(i).getString("name");
            n = userJsonArray.getJSONObject(i).getInt("n"); //quantidade de pokemons
            for(int k = 0; k < n; k++){
                trainerPokemons[i][k] = userJsonArray.getJSONObject(i).getJSONArray("pokemons").getJSONObject(k).getString("name");
            }
            JSONObject compareNameObject = new JSONObject();
            if (compareName[i].equals(name)) {
                treinador.setName(compareName[i]);
                treinador.setExperience(userJsonArray.getJSONObject(i).getInt("experience"));
                treinador.setNumeroDePokemons(userJsonArray.getJSONObject(i).getInt("n"));
                String []nomeDosPokemons = new String[treinador.getNumeroDePokemons()];
                int q = 0;
                for (int j = 0; j < treinador.getNumeroDePokemons(); j++) {
                    nomeDosPokemons[q] = (userJsonArray.getJSONObject(i).getJSONArray("pokemons").getJSONObject(j).getString("name"));
                    q++;
                }
                if(nomeDosPokemons != null) {
                    treinador.setMyPokemons(nomeDosPokemons);
                }
            }
        }
        treinador.setTrainerNames(trainerNames.toArray());
    }
    public Object[] getTrainerPokemons(String trainerName){
        for(int i = 0; i < count; i++){
            if(treinador.getTrainerNames()[i].equals(trainerName)){
                return trainerPokemons[i];
            }
        }
        return null;
    }

    public boolean pokemonAlreadyExists(String pokemonName) {
        for (int i = 0; i < treinador.getNumeroDePokemons(); i++) {
            if (pokemonName.equals(treinador.getMyPokemons()[i])) {
                return true;
            }
        }
        return false;
    }
    //retorna 1 se já tem o pokemon, 2 se tem experiência inferior, 0 se conseguiu,
    public int tryToCatch(String pokemonName, String userName, int pokemonExperience) {
        JSONArray userJsonArray = new JSONArray();
        BufferedReader infoReader = null;
        StringBuilder aux = new StringBuilder();
        try {
            infoReader = new BufferedReader(new FileReader("data/json_files/users.json"));
            while (infoReader.ready()) {
                aux.append(infoReader.readLine());
            }
        }catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        JSONObject pokemon;
        JSONObject infoJson = new JSONObject(aux.toString());
        JSONArray pokemonArray = new JSONArray();
        int count = infoJson.getInt("count");
        int indexUser = 0;
        for (int i = 0; i < count; i++) {
            if (userName.equals(infoJson.getJSONArray("users").getJSONObject(i).getString("name"))) {
                indexUser = i;
                break;
            }
        }
        if (pokemonAlreadyExists(pokemonName)) {
            return 1;
        }
        else if(pokemonExperience > infoJson.getJSONArray("users").getJSONObject(indexUser).getInt("experience")){
            return 2;
        }
        else {
            JSONObject nameObject = new JSONObject();
            nameObject.put("name", pokemonName);
            infoJson.getJSONArray("users").getJSONObject(indexUser).getJSONArray("pokemons").put(nameObject);
            int userExperience = infoJson.getJSONArray("users").getJSONObject(indexUser).getInt("experience");
            userExperience += pokemonExperience / 2;
            infoJson.getJSONArray("users").getJSONObject(indexUser).remove("experience");
            infoJson.getJSONArray("users").getJSONObject(indexUser).put("experience", userExperience);
            int n = infoJson.getJSONArray("users").getJSONObject(indexUser).getInt("n");
            infoJson.getJSONArray("users").getJSONObject(indexUser).remove("n");
            infoJson.getJSONArray("users").getJSONObject(indexUser).put("n", n + 1);
            FileWriter salvarMudança = null;
            try {
                salvarMudança = new FileWriter("data/json_files/users.json");
                salvarMudança.write(infoJson.toString(2));
                salvarMudança.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}
