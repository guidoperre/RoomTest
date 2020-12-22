package com.guido.roomtest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AutoDAO {

    //Infiere segun el tipo de retorno y la anotacion//

    @Query("SELECT * FROM auto")
    LiveData<List<Auto>> getLiveData();

    @Query("SELECT * FROM auto")
    List<Auto> getAll();

    @Insert
    Long insert(Auto auto);

    @Update
    void update(Auto auto);

    @Delete
    void delete(Auto auto);

    @Query("DELETE FROM auto")
    void deleteAll();

}
