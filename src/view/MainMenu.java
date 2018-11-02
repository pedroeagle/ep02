package view;

import model.Pokemon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu {
    public JPanel main;
    public JButton buttonTypes;
    private JButton buttonSearch;
    public JList typesList;
    public JScrollPane typesScroll;

    public MainMenu(){
        JFrame mainFrame = new JFrame("Pokédex");
        mainFrame.add(main);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        buttonTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new TypesList();
            }
        });
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PokemonSearch();
            }
        });
    }
}
