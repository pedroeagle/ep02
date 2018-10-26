package view;

import model.Pokedex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TypesList typesList = new TypesList();
                JFrame typesPanel = new JFrame("Types");
                typesPanel.setContentPane(new TypesList().typesPanel);
                typesPanel.setLocationRelativeTo(null);
                typesPanel.getContentPane().add(typesList.typesScroll, BorderLayout.CENTER);
                typesList.typesScroll.setPreferredSize(new Dimension(250, 250));
                typesPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                typesPanel.pack();
                typesPanel.setVisible(true);
            }
        });
    }
}
