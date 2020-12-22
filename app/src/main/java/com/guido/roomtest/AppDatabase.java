package com.guido.roomtest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Auto.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {

    //DECLARACION DE LOS DAO
    public abstract AutoDAO autoDAO();

    //CREACION DE LA BASE
    private static AppDatabase appDatabase = null;

    //Traigo la base de datos
    public static AppDatabase getDatabase(Context context) {
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(
                        context,
                        AppDatabase.class,
                    "room_database").fallbackToDestructiveMigration().build();
        }
        return appDatabase;
    }

}
