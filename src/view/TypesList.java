package view;

import model.Types;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.io.IOException;

public class TypesList<typesList> {
        Types types;
    {
        try {
            types = new Types("https://pokeapi.co/api/v2/type/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public JPanel typesPanel = new JPanel();
    public JList typesList = new JList(types.getNameTypes());
    public JScrollPane typesScroll = new JScrollPane(typesList);
}
