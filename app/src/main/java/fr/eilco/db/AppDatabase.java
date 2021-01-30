package fr.eilco.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fr.eilco.dao.database.PokemonDAO;
import fr.eilco.model.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDAO pokemonDAO();
}
