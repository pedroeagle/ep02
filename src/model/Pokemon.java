package model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pokemon extends Pokedex{
    private void setPokemonType1(String pokemonType1) {
        this.pokemonType1 = pokemonType1;
    }

    public String getLegendary() {
        return legendary;
    }

    public String getAbility1() {
        return ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public String getAbility3() {
        return ability3;
    }

    public int getHp() {
        return hp;
    }

    public int getAtack() {
        return atack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGeneration() {
        return generation;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    private void setPokemonType2(String pokemonType2) {
        this.pokemonType2 = pokemonType2;
    }

    private void setLegendary(String legendary) {
        this.legendary = legendary;
    }

    private void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    private void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    private void setAbility3(String ability3) {
        this.ability3 = ability3;
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    private void setAtack(int atack) {
        this.atack = atack;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    private void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    private void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    private void setGeneration(int generation) {
        this.generation = generation;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }
    //atributos dos pokemons
    private String pokemonType1, pokemonType2, legendary, ability1, ability2, ability3;
    private int hp, atack, defense, spAtk, spDef, speed, generation, height, weight;
    private ImageIcon pokemonImage;

    public String getPokemonType1() {
        return pokemonType1;
    }

    public String getPokemonType2() {
        return pokemonType2;
    }

    public ImageIcon getPokemonImage() {
        return pokemonImage;
    }

    public void setPokemonImage(String path) {
        pokemonImage = new ImageIcon(path);
    }
    public Pokemon() {
    }

    public void setAll(int limit) throws IOException{
        BufferedReader POKEMONS_DATA_1 = new BufferedReader(new FileReader("data/csv_files/POKEMONS_DATA_1.csv"));
        BufferedReader POKEMONS_DATA_2 = new BufferedReader(new FileReader("data/csv_files/POKEMONS_DATA_2.csv"));
        String linhaAux1;
        String linhaAux2;
        for(int i = 0; i < limit+1; i++) {
            POKEMONS_DATA_1.readLine();
            POKEMONS_DATA_2.readLine();
        }
        //first file
        linhaAux1 = POKEMONS_DATA_1.readLine();
        String []partsAux1 = linhaAux1.split(",");
        setName(partsAux1[1]); //método herdado da classe Pokédex
        setPokemonImage("data/images/" + getName().toLowerCase()+".png");
        setPokemonType1(partsAux1[2]);
        setPokemonType2(partsAux1[3]);
        setHp(Integer.parseInt(partsAux1[5]));
        setAtack(Integer.parseInt(partsAux1[6]));
        setDefense(Integer.parseInt(partsAux1[7]));
        setSpAtk(Integer.parseInt(partsAux1[8]));
        setSpDef(Integer.parseInt(partsAux1[9]));
        setSpeed(Integer.parseInt(partsAux1[10]));
        setGeneration(Integer.parseInt(partsAux1[11]));
        setLegendary(partsAux1[12]);
        //second file
        linhaAux2 = POKEMONS_DATA_2.readLine();
        String []partsAux2 = linhaAux2.split(",");
        setExperience(Integer.parseInt(partsAux2[2])); //método herdado da classe Pokédex
        setHeight(Integer.parseInt(partsAux2[3]));
        setWeight(Integer.parseInt(partsAux2[4]));
        setAbility1(partsAux2[5]);
        setAbility2(partsAux2[6]);
        setAbility3(partsAux2[7]);
        POKEMONS_DATA_1.close();
        POKEMONS_DATA_2.close();
    }
}