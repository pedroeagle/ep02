package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class User {

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
            for(int i = 0; i < count; i++){
                String [] compareName = new String[count];
                compareName[i] = userJsonArray.getJSONObject(i).getString("name");
                JSONObject compareNameObject = new JSONObject();
                if(compareName[i].equals(name)){
                    exist = true;
                }
            }
        }catch (FileNotFoundException e) {
                e.printStackTrace();
        }
        if(exist){
            return true;
        }
        else {
            FileWriter salvarRegistro = null;
            JSONObject fileJson = new JSONObject();
            count++;
            fileJson.put("count", count);
            JSONObject nameJson = new JSONObject();
            nameJson.put("password", password);
            nameJson.put("name", name);
            JSONObject userJson = new JSONObject();
            JSONObject allInfo = new JSONObject();
            userJsonArray.put(nameJson);
            fileJson.put("users", userJsonArray);
            try {
                salvarRegistro = new FileWriter("data/json_files/users.json");
                salvarRegistro.write(fileJson.toString());
                salvarRegistro.close();
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
        BufferedReader infoReader = null;
        try {
            infoReader = new BufferedReader(new FileReader("data/json_files/users.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder aux = new StringBuilder();
        while (infoReader.ready()) {
            aux.append(infoReader.readLine());
        }
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
        return exist;
    }
}
