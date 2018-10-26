package model;

import view.Login;

import javax.swing.*;
import java.io.IOException;

public class Pokedex {

    public Pokedex() {
    }
    public static void main(String[] args) {
        System.out.println("Started Program!");

        /*try {
            Types pokemonTypes = new Types("https://pokeapi.co/api/v2/type/");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            Pokemon pokemon = new Pokemon("https://pokeapi.co/api/v2/pokemon/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User("pedro", "123");
        JFrame login = new JFrame("Login");
        login.setContentPane(new Login().loginPanel);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.pack();
        login.setVisible(true);
    }
}
