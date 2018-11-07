package view;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class PokemonTypes extends JFrame {
    public JPanel pokemonsTypesPanel;
    public JList pokemonTypesList;
    private JScrollPane pokemonTypesScroll;

    public PokemonTypes() {

        pokemonTypesList.addComponentListener(new ComponentAdapter() {
        });
        pokemonTypesList.addComponentListener(new ComponentAdapter() {
        });
    }

    public PokemonTypes(String type, Object[] listNames) {
        JFrame pokemonTypesFrame = new JFrame("Type: " + type);
        pokemonTypesList = new JList(listNames);
        pokemonTypesScroll = new JScrollPane(pokemonTypesList);
        if (pokemonsTypesPanel != null) {
            pokemonTypesFrame.add(pokemonsTypesPanel);
        }

        pokemonTypesFrame.setLocation(450, 250);
        pokemonTypesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pokemonTypesFrame.getContentPane().add(pokemonTypesScroll);
        pokemonTypesScroll.setPreferredSize(new Dimension(220, 300));
        pokemonTypesFrame.pack();
        pokemonTypesFrame.setVisible(true);
        pokemonTypesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                new PokemonInfo(pokemonTypesList.getSelectedValue().toString());
                pokemonTypesFrame.dispose();
            }
        });
    }
}