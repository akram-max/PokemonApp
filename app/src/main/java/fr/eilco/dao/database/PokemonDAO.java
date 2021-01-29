package fr.eilco.dao.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.eilco.model.Pokemon;

@Dao
public interface PokemonDAO {
    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAll();

    @Query("SELECT * FROM pokemon WHERE id = :id")
    List<Pokemon> getOneById(Long id);

    @Query("SELECT * FROM pokemon WHERE name like :name")
    List<Pokemon> getOneByName(String name);

    @Insert
    void insertAll(Pokemon... pokemon);

    @Delete
    void delete(Pokemon pokemon);

}
