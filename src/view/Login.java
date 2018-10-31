package view;

import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login{
    String usuario;
    String senha;
    public JButton loginButton;
    public JPanel loginPanel;
    private JTextField userTextBox;
    private JPasswordField loginPassword;
    private JButton registerButton;
    public Login(){
        User user = new User("pedro", "123");
        JFrame login = new JFrame("Login");
        login.setContentPane(loginPanel);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.pack();
        login.setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MainMenu();
                login.dispose();
            }
        });
    }
}
