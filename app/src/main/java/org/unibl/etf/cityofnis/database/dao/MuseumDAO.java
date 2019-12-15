package org.unibl.etf.cityofnis.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.unibl.etf.cityofnis.dto.Attraction;
import org.unibl.etf.cityofnis.dto.Museum;

import java.util.List;

@Dao
public interface MuseumDAO {

    @Query("SELECT * FROM museum")
    List<Museum> getAll();

    @Query("SELECT * FROM museum where nameEn like :name")
    Museum getAllByNameEn(String name);

    @Query("SELECT * FROM museum where favourite like :like")
    List<Museum> getAllLiked(boolean like);

    @Insert
    void insertAll(List<Museum> museumItems);

    @Insert
    void insert(Museum museumItem);

    @Delete
    void delete(Museum museumItem);

    @Query("DELETE FROM museum")
    void deleteAll();

    @Update
    void update(Museum museumItem);

    @Query("UPDATE museum SET favourite=0 WHERE nameEn like :name")
    void updateLiked(String name);

}
