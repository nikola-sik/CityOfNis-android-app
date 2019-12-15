package org.unibl.etf.cityofnis.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.unibl.etf.cityofnis.dto.Adventure;


import java.util.List;

@Dao
public interface AdventureDAO {
    @Query("SELECT * FROM adventure")
    List<Adventure> getAll();

    @Query("SELECT * FROM adventure where nameEn like :name")
    Adventure getAllByNameEn(String name);

    @Query("SELECT * FROM adventure where favourite like :like")
    List<Adventure> getAllLiked(boolean like);

    @Insert
    void insertAll(List<Adventure> adventureItems);

    @Insert
    void insert(Adventure adventureItem);

    @Delete
    void delete(Adventure adventureItem);

    @Query("DELETE FROM adventure")
    void deleteAll();

    @Update
    void update(Adventure adventureItem);

    @Query("UPDATE adventure SET favourite=0 WHERE nameEn like :name")
    void updateLiked(String name);

}
