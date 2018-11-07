package view;

import model.Pokedex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPokemons extends JFrame {
    private JPanel SearchPanel;
    private JTextField searchBox;
    private JButton searchButton;
    private JLabel resultText;

    public SearchPokemons() {
        JFrame searchPokemonsFrame = new JFrame("Search: Pokemons");
        searchPokemonsFrame.add(SearchPanel);
        searchPokemonsFrame.setLocation(450, 250);
        searchPokemonsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchPokemonsFrame.pack();
        searchPokemonsFrame.setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (PokemonInfo.pokemonInfos.comparePokemonInfo(searchBox.getText().toLowerCase()) != null) {
                    new PokemonInfo(searchBox.getText().toLowerCase());
                    searchPokemonsFrame.dispose();
                } else {
                    new SearchPokemons();
                    searchPokemonsFrame.dispose();
                }
            }
        });
    }

}
