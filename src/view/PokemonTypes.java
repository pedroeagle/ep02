package view;

import model.Pokedex;

import javax.swing.*;
import java.awt.*;

public class PokemonTypes extends JFrame{
    public JPanel pokemonsTypesPanel;
    public JLabel pokemonTypesText;
    private JList pokemonTypesList;
    private JScrollPane pokemonTypesScroll;
    Object[] names = new Object[950];
    public Object[] comparePokemonTypes(String type){
        int k = 0;
        System.out.println(Pokedex.allPokemons.pokemonTypes[0][0]);
        for(int i = 0; i < 950; i++){
            for(int j = 0; j < 3;j++){
                if(type == Pokedex.allPokemons.pokemonTypes[i][j]){
                    names[k] = Pokedex.allPokemons.getPokemonName(i);
                    k++;
                    break;
                }
            }
        }
        return names;
    }
    public PokemonTypes(){

    }
    public PokemonTypes(String type, Object[] listNames){
        JFrame pokemonTypesFrame = new JFrame("Type: "+type);
        pokemonTypesText.setText(type);
        pokemonTypesList = new JList(listNames);
        pokemonTypesScroll = new JScrollPane(pokemonTypesList);
        pokemonTypesFrame.add(pokemonsTypesPanel);
        pokemonTypesFrame.setLocationRelativeTo(null);
        pokemonTypesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pokemonTypesFrame.getContentPane().add(pokemonTypesScroll);
        pokemonTypesScroll.setPreferredSize(new Dimension(250, 80));
        pokemonTypesFrame.pack();
        pokemonTypesFrame.setVisible(true);
    }
}
