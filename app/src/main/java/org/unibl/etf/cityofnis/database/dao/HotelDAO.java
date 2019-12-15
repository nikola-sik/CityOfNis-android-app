package org.unibl.etf.cityofnis.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.unibl.etf.cityofnis.dto.Hotel;
import org.unibl.etf.cityofnis.dto.Liked;
import org.unibl.etf.cityofnis.dto.Museum;

import java.util.List;

@Dao
public interface HotelDAO {

    @Query("SELECT * FROM hotel")
    List<Hotel> getAll();

    @Query("SELECT * FROM hotel where nameEn like :name")
    Hotel getAllByNameEn(String name);

    @Query("SELECT * FROM hotel where favourite like :like")
    List<Hotel> getAllLiked(boolean like);

    @Insert
    void insertAll(List<Hotel> hotelItems);

    @Insert
    void insert(Hotel hotelItem);

    @Delete
    void delete(Hotel hotelItem);

    @Query("DELETE FROM hotel")
    void deleteAll();

    @Update
    void update(Hotel hotelItem);

    @Query("UPDATE hotel SET favourite=0 WHERE nameEn like :name")
    void updateLiked(String name);
}
