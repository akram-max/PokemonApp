package fr.eilco.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fr.eilco.dao.database.PokemonDAO;
import fr.eilco.dao.database.PokemonResultDAO;
import fr.eilco.model.Pokemon;
import fr.eilco.model.PokemonResult;

@Database(entities = {Pokemon.class, PokemonResult.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDAO pokemonDAO();
    public abstract PokemonResultDAO pokemonResultDAO();
}
