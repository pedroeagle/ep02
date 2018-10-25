package model;

import view.Login;

import javax.swing.*;
import java.io.IOException;

public class Pokedex {

    public Pokedex() {
    }

    public static void main(String[] args) {
        System.out.println("Started Program!");

        try {
            Types pokemonTypes = new Types("https://pokeapi.co/api/v2/type/");
            System.out.println(pokemonTypes.getUrlTypes(5));
            System.out.println(pokemonTypes.getNameTypes(5));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame login = new JFrame("Login");
        login.setContentPane(new Login().panelLogin);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.pack();
        login.setVisible(true);
    }
}
