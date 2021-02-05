package fr.eilco.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PokemonResult {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "PokemonResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
