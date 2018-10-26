package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.Login;

import javax.swing.*;
import java.io.*;

public class User {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    String userName;
    String userPass;
    StringBuilder conteudoDaApi = new StringBuilder();
    JSONObject usersApi;
    User(String name, String password){
        /*try (FileReader data = new FileReader("data/data.json")) {
            JSONParser parser = new JSONParser();
            usersApi = (JSONObject) parser.parse(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setUserName((String) usersApi.get("results"));
        JSONObject conteudoUsers;
        conteudoUsers = usersApi.getJSONObject("users");
        System.out.println(userName);
        JSONArray usersArray = new JSONArray(conteudoUsers);
        System.out.println(usersArray.toString(0));
        /*for (int i = 0; i < types.length(); i++) {
            nameObject = types.getJSONObject(i);
            pokemonName.add(nameObject.getString("name"));
            pokemonUrl.add(nameObject.getString("url"));
        }
        infoApi.close();
    }
        return true;*/
    }
}
