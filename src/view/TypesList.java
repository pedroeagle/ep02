package view;

import model.Pokemon;
import model.Types;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

public class TypesList extends JFrame{
    JList typesList;
    JScrollPane typesScroll;
    public Main typesTab = new Main();
    public JPanel typesPanel = new JPanel();
    TypesList() {


        typesTab.typesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                PokemonTypes pokemonTypes = new PokemonTypes();
                pokemonTypes.pokemonTypeText = new JLabel("texto");
                JFrame typesPokemon = new JFrame("Pokémons: Types");
                typesPokemon.setContentPane(new PokemonTypes().pokemonsTypesPanel);
                typesPokemon.setLocationRelativeTo(null);
                //typesPokemon.getContentPane().add(pokemonTypes.typesPokemonScroll, BorderLayout.CENTER);
                typesPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                typesPokemon.pack();
                typesPokemon.setVisible(true);
            }
        });
    }
}
