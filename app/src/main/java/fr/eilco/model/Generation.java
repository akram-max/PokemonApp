package fr.eilco.model;

import java.util.List;

public class Generation {

    private Long id;
    private String name;
    private List<PokemonResult> pokemon_species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonResult> getPokemon_species() {
        return pokemon_species;
    }

    public void setPokemon_species(List<PokemonResult> pokemon_species) {
        this.pokemon_species = pokemon_species;
    }

    @Override
    public String toString() {
        return "Generation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pokemon_species=" + pokemon_species +
                '}';
    }
}
