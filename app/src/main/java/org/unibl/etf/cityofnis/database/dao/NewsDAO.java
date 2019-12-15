package org.unibl.etf.cityofnis.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.unibl.etf.cityofnis.dto.News;

import java.util.List;

@Dao
public interface NewsDAO {

    @Query("SELECT * FROM news")
    List<News> getAll();

    @Insert
    void insertAll(List<News> news);

    @Delete
    void delete(News item);

    @Query("DELETE FROM news")
    void deleteAll();



}
