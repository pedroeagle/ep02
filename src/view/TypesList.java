package view;
import model.Types;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import static model.Pokedex.allPokemons;

public class TypesList extends JFrame{
    public JList typesList;
    public JScrollPane typesScroll;
    public JPanel typesPanel = new JPanel();
    public static Types types = new Types();
    public TypesList() {

        JFrame typesFrame = new JFrame("Pokédex - Types");
        typesList = new JList(types.getNameTypes());
        typesScroll = new JScrollPane(typesList);
        typesFrame.add(typesPanel);
        typesFrame.setLocation(450,250);
        typesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        typesFrame.getContentPane().add(typesScroll);
        typesScroll.setPreferredSize(new Dimension(220, 300));
        typesFrame.pack();
        typesFrame.setVisible(true);
        Types pokemonTypesList = new Types();
        typesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                ArrayList <Object> listPokemonTypes;
                listPokemonTypes = pokemonTypesList.comparePokemonTypes(typesList.getSelectedValue().toString().toLowerCase(), allPokemons);
                new PokemonTypes(typesList.getSelectedValue().toString(), listPokemonTypes.toArray());
                typesFrame.dispose();
            }
        });
    }
}