package fr.eilco.db;

import android.content.Context;

import androidx.room.Room;

public class DbConfig {

    private static final String DB_NAME = "pokemon_db";

    private DbConfig() { }

    public static AppDatabase getRoomInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }
}