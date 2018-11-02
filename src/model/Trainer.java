package model;

public class Trainer extends Pokedex{
    public int getNumeroDePokemons() {
        return numeroDePokemons;
    }

    public void setNumeroDePokemons(int numeroDePokemons) {
        this.numeroDePokemons = numeroDePokemons;
    }

    int numeroDePokemons = 0;

    public String[] getMyPokemons() {
        return myPokemons;
    }

    public void setMyPokemons(String[] myPokemons) {
        this.myPokemons = myPokemons;
    }

    String[] myPokemons = new String[720];

}
