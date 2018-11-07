package view;
import model.Types;
import model.User;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class MyPokemons extends JFrame {
    private JPanel myPokemonsPanel;
    private JList myPokemonsList;
    private JScrollPane myPokemonsScroll;

    MyPokemons() {
        JPanel myPokemonsPanel = new JPanel();
        JFrame myPokemonsFrame = new JFrame("My Pokemons");

        myPokemonsList = new JList(User.treinador.getMyPokemons());
        myPokemonsScroll = new JScrollPane(myPokemonsList);
        myPokemonsFrame.add(myPokemonsPanel);
        myPokemonsFrame.setLocation(450, 250);
        myPokemonsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myPokemonsFrame.getContentPane().add(myPokemonsScroll);
        myPokemonsScroll.setPreferredSize(new Dimension(220, 300));
        myPokemonsFrame.pack();
        myPokemonsFrame.setVisible(true);
        Types allMyPokemonsList = new Types();
        myPokemonsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                new PokemonInfo(myPokemonsList.getSelectedValue().toString());
                myPokemonsFrame.dispose();
            }
        });
    }

}
