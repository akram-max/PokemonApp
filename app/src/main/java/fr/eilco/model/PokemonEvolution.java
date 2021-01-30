package fr.eilco.model;

public class PokemonEvolution {

    private Family family;
    private String sprite;
    private String description;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PokemonEvolution{" +
                "family=" + family +
                ", sprite='" + sprite + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
