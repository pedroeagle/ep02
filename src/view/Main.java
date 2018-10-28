package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public JPanel main;
    public JButton buttonTypes;
    public JList typesList;
    public JScrollPane typesScroll;

    public Main(){
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
    }
}
