package view;

import model.Types;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class AllPokemons {
    private JList pokemonsList;
    private JScrollPane pokemonsScroll;
    private JPanel AllPokemonsPanel;

    Types allPokemonNames = new Types();
    AllPokemons(){
        JFrame allPokemonsFrame = new JFrame("All Pokemons");
        pokemonsList = new JList(allPokemonNames.getAllPokemonNames().toArray());
        pokemonsScroll = new JScrollPane(pokemonsList);

        allPokemonsFrame.setLocation(450,250);
        allPokemonsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        allPokemonsFrame.getContentPane().add(pokemonsScroll);
        pokemonsScroll.setPreferredSize(new Dimension(220, 300));
        allPokemonsFrame.pack();
        allPokemonsFrame.setVisible(true);


        pokemonsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                new PokemonInfo(pokemonsList.getSelectedValue().toString());
                allPokemonsFrame.dispose();
            }
        });
    }
}
