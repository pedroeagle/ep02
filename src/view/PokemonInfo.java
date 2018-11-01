package view;

import model.Pokedex;
import model.Pokemon;
import model.Types;

import javax.swing.*;

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
    private JLabel defendeText;
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    Types pokemonInfos;
    Pokemon pokemonToShow;
    public PokemonInfo(String pokemon) {
        pokemonToShow.setName(pokemon);
        pokemonToShow = pokemonInfos.comparePokemonInfo(pokemon);
        pokemonName = new JLabel();
        pokemonType1 = new JLabel(pokemonToShow.getPokemonType1());
        pokemonType2 = new JLabel(pokemonToShow.getPokemonType2());
        pokemonAbility1 = new JLabel(pokemonToShow.getAbility1());
        pokemonAbility2 = new JLabel(pokemonToShow.getAbility2());
        pokemonAbility3 = new JLabel(pokemonToShow.getAbility3());
        if (pokemonToShow.getLegendary().equals("true")) {
            pokemonLegendary = new JLabel("This pokemon is Legendary");
        }
        else{
            pokemonLegendary = new JLabel("This pokemon is not legendary");
        }
        pokemonHp = new JLabel(String.valueOf(pokemonToShow.getHp()));
        pokemonAtack = new JLabel(String.valueOf(pokemonToShow.getAtack()));
        pokemonDefense = new JLabel(String.valueOf(pokemonToShow.getDefense()));
        pokemonSpAtack = new JLabel(String.valueOf(pokemonToShow.getSpAtk()));
        pokemonSpDefense = new JLabel(String.valueOf(pokemonToShow.getSpDef()));
        pokemonGeneration = new JLabel(String.valueOf(pokemonToShow.getGeneration()));
        pokemonSpeed = new JLabel(String.valueOf(pokemonToShow.getSpeed()));
        pokemonHeight = new JLabel(String.valueOf(pokemonToShow.getHeight()));
        pokemonWeight = new JLabel(String.valueOf(pokemonToShow.getWeight()));
        pokemonImage = new JLabel(String.valueOf(pokemonToShow.getPokemonImage()));
        pokemonExperience = new JLabel(String.valueOf(pokemonToShow.getExperience()));


        JFrame pokemonInfo = new JFrame(pokemonToShow.getName());
        pokemonInfo.add(pokemonInfoPanel);
        pokemonInfo.setLocationRelativeTo(null);
        pokemonInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
