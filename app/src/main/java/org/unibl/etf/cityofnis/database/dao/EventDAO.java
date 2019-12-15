package org.unibl.etf.cityofnis.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.unibl.etf.cityofnis.dto.Event;


import java.util.List;
@Dao
public interface EventDAO {
    @Query("SELECT * FROM event")
    List<Event> getAll();

    @Query("SELECT * FROM event where nameEn like :name")
    Event getAllByNameEn(String name);

    @Query("SELECT * FROM event where favourite like :like")
    List<Event> getAllLiked(boolean like);

    @Insert
    void insertAll(List<Event> eventItems);

    @Insert
    void insert(Event eventItem);

    @Delete
    void delete(Event eventItem);

    @Query("DELETE FROM event")
    void deleteAll();

    @Update
    void update(Event eventItem);

    @Query("UPDATE event SET favourite=0 WHERE nameEn like :name")
    void updateLiked(String name);
}
