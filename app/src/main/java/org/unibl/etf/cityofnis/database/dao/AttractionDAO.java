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
public interface AttractionDAO {

    @Query("SELECT * FROM attraction")
    List<Attraction> getAll();

    @Query("SELECT * FROM attraction where nameEn like :name")
    Attraction getAllByNameEn(String name);

    @Query("SELECT * FROM attraction where favourite like :like")
    List<Attraction> getAllLiked(boolean like);

    @Insert
    void insertAll(List<Attraction> attractionItems);

    @Insert
    void insert(Attraction attractionItem);

    @Delete
    void delete(Attraction attractionItem);

    @Query("DELETE FROM attraction")
    void deleteAll();

    @Update
    void update(Attraction attractionItem);

    @Query("UPDATE attraction SET favourite=0 WHERE nameEn like :name")
    void updateLiked(String name);
}
