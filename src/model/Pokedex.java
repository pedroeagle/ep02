package model;

import view.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pokedex {

    public void setName(String name) {
        this.name = name;
    }

    void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    private String name;
    private int experience;

    public int getExperience() {
        return experience;
    }

    public static ArrayList<Pokemon> allPokemons = new ArrayList<Pokemon>();
    public static void main(String[] args) {
        System.out.println("Program started!");
        Pokemon pokemons = new Pokemon();
        for(int i = 0; i < 721; i++) {
            try {
                pokemons.setAll(i);
                allPokemons.add(pokemons);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pokemons = new Pokemon();
        }
        new Login();
    }
}
