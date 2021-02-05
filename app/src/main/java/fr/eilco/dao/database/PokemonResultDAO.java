package fr.eilco.dao.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fr.eilco.model.PokemonResult;

@Dao
public interface PokemonResultDAO {
    @Query("SELECT * FROM pokemonResult")
    List<PokemonResult> getAll();

    @Query("SELECT * FROM pokemonResult WHERE id = :id")
    List<PokemonResult> getOneById(Long id);

    @Query("SELECT * FROM pokemonResult WHERE name like :name")
    List<PokemonResult> getOneByName(String name);

    @Insert
    void insertAll(PokemonResult... pokemonResult);

    @Delete
    void delete(PokemonResult pokemonResult);

}
