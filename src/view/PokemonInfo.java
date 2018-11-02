package view;

import com.sun.tools.javac.Main;
import model.Pokedex;
import model.Pokemon;
import model.Types;

import javax.swing.*;
import java.awt.*;

public class PokemonInfo {
    private JLabel pokemonName;
    private JLabel type1Text;
    private JLabel pokemonType1;
    private JLabel type2Text;
    private JLabel pokemonType2;
    private JLabel ability1Text;
    private JLabel ability2Text;
    private JLabel ability3Text;
    private JLabel pokemonAbility1;
    private JLabel pokemonAbility2;
    private JLabel pokemonAbility3;
    private JLabel pokemonLegendary;
    private JLabel hpText;
    private JLabel pokemonHp;
    private JLabel atackText;
    private JLabel pokemonAtack;
    private JLabel pokemonDefense;
    private JLabel defenseText;
    private JLabel spAtackText;
    private JLabel spDefenseText;
    private JLabel pokemonSpAtack;
    private JLabel pokemonSpDefense;
    private JLabel pokemonGeneration;
    private JLabel speedText;
    private JLabel pokemonSpeed;
    private JLabel heightText;
    private JLabel pokemonHeight;
    private JLabel weightText;
    private JLabel pokemonWeight;
    private JLabel pokemonImage;
    private JLabel textExperience;
    private JLabel pokemonExperience;
    private JPanel pokemonInfoPanel;

    Types pokemonInfos = new Types();
    Pokemon pokemonToShow = new Pokemon();
    public PokemonInfo(String pokemon) {
        pokemonToShow.setName(pokemon);
        if(pokemonInfos.comparePokemonInfo(pokemon)!=null){
            pokemonToShow = pokemonInfos.comparePokemonInfo(pokemon);
        }

        else{
            System.out.println("Erro NullPointer");
            new MainMenu();
        }
        pokemonName.setText(pokemonToShow.getName());
        if (pokemonToShow.getPokemonType1().length() == 0) {
            type1Text.setText("");
        }
        pokemonType1.setText(pokemonToShow.getPokemonType1());
        if (pokemonToShow.getPokemonType2().length() == 0) {
            type2Text.setText("");
        }
        pokemonType2.setText(pokemonToShow.getPokemonType2());
        if (pokemonToShow.getAbility1().length() == 0) {
            ability1Text.setText("");
        }
        pokemonAbility1.setText(pokemonToShow.getAbility1());
        if (pokemonToShow.getAbility2().length() == 0) {
            ability2Text.setText("");
        }
        pokemonAbility2.setText(pokemonToShow.getAbility2());

        if (pokemonToShow.getAbility3().length() == 0) {
            ability3Text.setText("");
        }
            pokemonAbility3.setText(pokemonToShow.getAbility3());


        if (pokemonToShow.getLegendary().equals("True")) {
            pokemonLegendary.setText("This pokemon is Legendary");
        }
        else{
            pokemonLegendary.setText("");
        }
        pokemonHp.setText(String.valueOf(pokemonToShow.getHp()));
        pokemonAtack.setText(String.valueOf(pokemonToShow.getAtack()));
        pokemonDefense.setText(String.valueOf(pokemonToShow.getDefense()));
        pokemonSpAtack.setText(String.valueOf(pokemonToShow.getSpAtk()));
        pokemonSpDefense.setText(String.valueOf(pokemonToShow.getSpDef()));
        pokemonGeneration.setText(String.valueOf(pokemonToShow.getGeneration()+"º generation"));
        pokemonSpeed.setText(String.valueOf(pokemonToShow.getSpeed()));
        pokemonHeight.setText(String.valueOf(pokemonToShow.getHeight()));
        pokemonWeight.setText(String.valueOf(pokemonToShow.getWeight()));
        pokemonImage.setIcon(pokemonToShow.getPokemonImage());
        pokemonExperience.setText(String.valueOf(pokemonToShow.getExperience()));
        JFrame pokemonInfo = new JFrame(pokemonToShow.getName());
        pokemonInfo.add(pokemonInfoPanel);
        pokemonInfo.setLocationRelativeTo(null);
        pokemonInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pokemonInfo.pack();
        pokemonInfo.setVisible(true);
    }
}
