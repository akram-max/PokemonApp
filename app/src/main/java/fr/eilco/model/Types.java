package fr.eilco.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Types {

    @PrimaryKey
    private Long id;
    private int slot;
    private Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", slot=" + slot +
                ", type=" + type +
                '}';
    }
}
