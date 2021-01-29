package fr.eilco.model;

import java.util.List;

public class Family {

    private Long id;
    private Long evolutionStage;
    private List<String> evolutionLine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvolutionStage() {
        return evolutionStage;
    }

    public void setEvolutionStage(Long evolutionStage) {
        this.evolutionStage = evolutionStage;
    }

    public List<String> getEvolutionLine() {
        return evolutionLine;
    }

    public void setEvolutionLine(List<String> evolutionLine) {
        this.evolutionLine = evolutionLine;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", evolutionStage=" + evolutionStage +
                ", evolutionLine=" + evolutionLine +
                '}';
    }
}
