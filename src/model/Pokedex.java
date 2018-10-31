package model;

import view.Login;

import java.io.IOException;

public class Pokedex {
    public static Pokemons allPokemons;
    public static void main(String[] args) {
        System.out.println("Program started!");
        new Login();
        try {
            allPokemons = new Pokemons("https://pokeapi.co/api/v2/pokemon/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
