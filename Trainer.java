import java.util.*;
import java.lang.*;

public class Trainer {
    private String name;
    public static Pokedex worldPokedex = new Pokedex();
    private HashMap<String, Pokemon> pokemon = new HashMap<String, Pokemon>();
    private Pokemon currentPokemon;
    
    public Trainer (String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public HashMap<String, Pokemon> getPokemon()
    {
        return pokemon;
    }
    
    public Pokemon getCurrentPokemon()
    {
        Pokemon poop = (Pokemon)pokemon.values().toArray()[0];
        return poop;
    }
    
    public void changeName(String newName)
    {
        name = newName;
    }
    
    public void addPokemon(Pokemon p)
    {
        pokemon.put(p.getName(), p);
    }
    
    public void setCurrentPokemon(Pokemon p)
    {
        currentPokemon = pokemon.get(p.getName());
    }
}
