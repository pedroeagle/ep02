package view;

import model.Pokedex;
import model.Pokemon;
import model.Types;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchTypes extends JFrame{
    private JTextField searchBox;
    private JButton searchButton;
    private JLabel infoText;
    private JPanel SearchTypesPanel;
    SearchTypes(){
        JFrame searchTypesFrame = new JFrame("Search Pokemons");
        searchTypesFrame.add(SearchTypesPanel);
        searchTypesFrame.setLocation(450, 250);
        searchTypesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchTypesFrame.pack();
        searchTypesFrame.setVisible(true);
        Types searchForTypes = new Types();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Pokedex.thread.existType(searchBox.getText().toLowerCase())) {
                    new PokemonTypes(searchBox.getText().toLowerCase(), searchForTypes.comparePokemonTypes2(searchBox.getText().toLowerCase(), Pokedex.allPokemons));
                    searchTypesFrame.dispose();
                } else {
                    new SearchTypes();
                    searchTypesFrame.dispose();
                }
            }
        });
    }
}