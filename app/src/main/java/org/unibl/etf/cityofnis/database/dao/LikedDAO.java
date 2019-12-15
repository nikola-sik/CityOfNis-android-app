package org.unibl.etf.cityofnis.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.unibl.etf.cityofnis.dto.Liked;
import org.unibl.etf.cityofnis.dto.Museum;

import java.util.List;


@Dao
public interface LikedDAO {

    @Query("SELECT * FROM liked")
    List<Liked> getAll();

    @Query("SELECT * FROM liked where nameEn=:name")
    List<Liked> getByName(String name);

    @Insert
    void insertAll(List<Liked> likedItems);

    @Insert
    void insert(Liked likedItem);

    @Delete
    void delete(Liked likedItem);

    @Query("DELETE FROM liked")
    void deleteAll();

    @Update
    void update(Liked likedItem);

}
