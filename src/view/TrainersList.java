package view;

import model.Pokedex;
import model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TrainersList extends JFrame{
    private JList trainersList;
    private JPanel trainersListPanel;
    private JScrollPane trainersListScroll;
    public Object []names;

    public TrainersList(){
        JFrame trainersListFrame = new JFrame("Trainers");
        trainersList = new JList(User.treinador.getTrainerNames());
        trainersListScroll = new JScrollPane(trainersList);
        trainersListFrame.add(trainersListPanel);
        trainersListFrame.setLocationRelativeTo(null);
        trainersListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        trainersListFrame.getContentPane().add(trainersListScroll);
        trainersListScroll.setPreferredSize(new Dimension(220, 300));
        trainersListFrame.pack();
        trainersListFrame.setVisible(true);
        trainersList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                new TrainerPokemonsList(Login.user.getTrainerPokemons(trainersList.getSelectedValue().toString()), trainersList.getSelectedValue().toString());
                trainersListFrame.dispose();
            }
        });
    }

}
