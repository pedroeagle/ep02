package view;

import model.Types;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

public class TypesList extends JFrame{
    public JList typesList;
    public JScrollPane typesScroll;
    public MainMenu typesTab = new MainMenu();
    public JPanel typesPanel = new JPanel();
    public TypesList() {
        Types types = null;
        try {
            types = new Types("https://pokeapi.co/api/v2/type/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame typesFrame = new JFrame("Pokédex - Types");
        typesList = new JList(types.getNameTypes());
        typesScroll = new JScrollPane(typesList);
        typesFrame.add(typesPanel);
        typesFrame.setLocationRelativeTo(null);
        typesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        typesFrame.getContentPane().add(typesScroll);
        typesScroll.setPreferredSize(new Dimension(250, 80));
        typesFrame.pack();
        typesFrame.setVisible(true);
        PokemonTypes pokemonTypesList = new PokemonTypes();
        typesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                Object[] listPokemonTypes;
                listPokemonTypes = pokemonTypesList.comparePokemonTypes(listSelectionEvent.toString());
                new PokemonTypes(listSelectionEvent.toString(), listPokemonTypes);
            }
        });
    }
}
