package view;

import model.Types;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonSearch {
    private JTextField pokemonsSearch;
    private JList pokemonsList;
    private JScrollPane pokemonsScroll;
    private JPanel pokemonSearchPanel;
    private JButton button1;

    Types allPokemonNames = new Types();
    PokemonSearch(){
        JFrame pokemonSearchFrame = new JFrame("Search");
        pokemonsList = new JList(allPokemonNames.getAllPokemonNames().toArray());
        pokemonsScroll = new JScrollPane(pokemonsList);
        pokemonsSearch = new JTextField(30);

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
        pokemonsSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                allPokemonNames.getAllPokemonNames().removeAll(allPokemonNames.getAllPokemonNames());
            }
        });
    }
}
