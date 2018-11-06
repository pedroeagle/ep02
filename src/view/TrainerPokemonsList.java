package view;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class TrainerPokemonsList extends JFrame{
    private JList trainerPokemonsList;
    private JPanel trainerPokemonsListPanel;
    private JScrollPane trainerPokemonsListScroll;
    public TrainerPokemonsList(Object[] pokemonsList, String trainerName){
        JFrame trainerPokemonsListFrame = new JFrame(trainerName+"'s Pokemons");
        trainerPokemonsList = new JList(pokemonsList);
        trainerPokemonsListScroll = new JScrollPane(trainerPokemonsList);
        if(trainerPokemonsList != null) {
            trainerPokemonsListFrame.add(trainerPokemonsListPanel);
        }
        trainerPokemonsListFrame.setLocation(450,250);
        trainerPokemonsListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        trainerPokemonsListFrame.getContentPane().add(trainerPokemonsListScroll);
        trainerPokemonsListScroll.setPreferredSize(new Dimension(220, 300));
        trainerPokemonsListFrame.pack();
        trainerPokemonsListFrame.setVisible(true);
        trainerPokemonsList.addComponentListener(new ComponentAdapter() {
        });
        trainerPokemonsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                new PokemonInfo(trainerPokemonsList.getSelectedValue().toString());
                trainerPokemonsListFrame.dispose();
            }
        });
    }
}
