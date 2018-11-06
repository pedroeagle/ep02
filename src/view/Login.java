package view;

import model.Pokedex;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Login{
    public JButton loginButton;
    public JPanel loginPanel;
    private JTextField loginUser;
    private JPasswordField loginPassword;
    private JButton registerButton;
    private JLabel textRegisterError;
    public static User user = new User();
    public Login(){
        JFrame login = new JFrame("Login");
        login.setContentPane(loginPanel);
        login.setLocation(450,250);
        if(Pokedex.registerError){
            textRegisterError.setText("Este usuário já existe. Tente novamente.");
            textRegisterError.setForeground(Color.RED);
        }
        else if(Pokedex.loginError){
            textRegisterError.setText("<html><body>Senha/Usuário incorretos.<br> Tente novamente ou registre um novo usuário.</body></html>");
            textRegisterError.setForeground(Color.RED);
        }
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.pack();
        login.setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if(user.LoginUser(loginUser.getText(), loginPassword.getText())){
                        user.getAllUserData(loginUser.getText());
                        new MainMenu();
                        login.dispose();
                    }
                    else{
                        Pokedex.registerError = false;
                        Pokedex.loginError = true;
                        login.dispose();
                        new Login();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if(user.CreateUser(loginUser.getText(), loginPassword.getText())){
                        login.dispose();
                        Pokedex.registerError = true;
                        Pokedex.loginError = false;
                        new Login();
                    }
                    else{
                        user.getAllUserData(loginUser.getText());
                        login.dispose();
                        new MainMenu();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
