package view;

import model.Pokedex;
import model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.util.List;

public class PokemonTypes extends JFrame{
    public JPanel pokemonsTypesPanel;
    public JLabel pokemonTypesText;
    private JList pokemonTypesList;
    private JScrollPane pokemonTypesScroll;
    Object[] names = new Object[950];
    /*public Object[] comparePokemonTypes(String type){
        int k = 0;
        System.out.println(Pokedex.allPokemon.pokemonTypes[0][0]);
        for(int i = 0; i < 950; i++){
            for(int j = 0; j < 3;j++){
                if(type == Pokedex.allPokemon.pokemonTypes[i][j]){
                    names[k] = Pokedex.allPokemon.getPokemonName(i);
                    k++;
                    break;
                }
            }
        }
        return names;
    }*/
    public PokemonTypes(){

        pokemonTypesList.addComponentListener(new ComponentAdapter() {
        });
    }
    public PokemonTypes(String type, Object[] listNames){
        JFrame pokemonTypesFrame = new JFrame("Type: "+type);
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
