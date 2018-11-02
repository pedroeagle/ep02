package view;

import model.Types;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class PokemonSearch {
    private JTextField pokemonsSearch;
    private JList pokemonsList;
    private JScrollPane pokemonsScroll;
    private JPanel pokemonSearchPanel;

    Types allPokemonNames = new Types();
    PokemonSearch(){
        JFrame pokemonSearchFrame = new JFrame("Search");
        pokemonsList = new JList(allPokemonNames.getAllPokemonNames().toArray());
        pokemonsScroll = new JScrollPane(pokemonsList);
        pokemonSearchFrame.add(pokemonSearchPanel);
        pokemonSearchFrame.setLocationRelativeTo(null);
        pokemonSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pokemonSearchFrame.getContentPane().add(pokemonsScroll);
        pokemonsScroll.setPreferredSize(new Dimension(220, 300));
        pokemonSearchFrame.pack();
        pokemonSearchFrame.setVisible(true);


        pokemonsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                new PokemonInfo(pokemonsList.getSelectedValue().toString());
                pokemonSearchFrame.dispose();
            }
        });
    }
}
