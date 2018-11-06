package view;

import model.Pokedex;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public JPanel main;
    public JButton buttonTypes;
    private JButton buttonAllPokemons;
    private JButton buttonMyPokemons;
    private JButton buttonTrainers;
    private JButton buttonSearch;
    private JButton exitButton;

    public MainMenu(){
        JFrame mainFrame = new JFrame("Pokédex");
        mainFrame.add(main);
        mainFrame.setLocation(450,250);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        buttonTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new TypesList();
            }
        });
        buttonAllPokemons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AllPokemons();
            }
        });
        buttonMyPokemons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MyPokemons();
            }
        });
        buttonTrainers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new TrainersList();
            }
        });
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SearchPokemons();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Pokedex.loginError = false;
                Pokedex.registerError = false;
                mainFrame.dispose();
                new Login();
            }
        });
    }
}
