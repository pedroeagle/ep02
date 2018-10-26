package view;

import model.Pokedex;
import model.Types;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JFrame{
    String usuario;
    String senha;
    private JButton loginButton;
    public JPanel loginPanel;
    private JTextField userTextBox;
    private JPasswordField loginPassword;
    private JButton registerButton;

    public Login() {

        loginButton.addActionListener(new ActionListener() {
            Types types;
            {
                try {
                    types = new Types("https://pokeapi.co/api/v2/type/");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main main = new Main();
                JFrame mainTab = new JFrame("Pokédex");
                JFrame typesTab = new JFrame();
                main.typesList = new JList(types.getNameTypes());
                main.typesScroll = new JScrollPane(main.typesList);
                mainTab.setContentPane(new Main().tabbedPanel);
                mainTab.setLocationRelativeTo(null);
                mainTab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainTab.getContentPane().gadd(main.typesScroll);
                main.typesScroll.setPreferredSize(new Dimension(250, 80));
                mainTab.pack();
                mainTab.setVisible(true);
            }
        });
    }
}
