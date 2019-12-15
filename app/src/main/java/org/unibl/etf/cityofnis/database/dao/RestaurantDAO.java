package org.unibl.etf.cityofnis.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.unibl.etf.cityofnis.dto.Restaurant;

import java.util.List;

@Dao
public interface RestaurantDAO {


    @Query("SELECT * FROM restaurant")
    List<Restaurant> getAll();

    @Query("SELECT * FROM restaurant where nameEn like :name")
    Restaurant getAllByNameEn(String name);

    @Query("SELECT * FROM restaurant where favourite like :like")
    List<Restaurant> getAllLiked(boolean like);

    @Insert
    void insertAll(List<Restaurant> restaurantItems);

    @Insert
    void insert(Restaurant restaurantItem);

    @Delete
    void delete(Restaurant restaurantItem);

    @Query("DELETE FROM restaurant")
    void deleteAll();

    @Update
    void update(Restaurant restaurantItem);

    @Query("UPDATE restaurant SET favourite=0 WHERE nameEn like :name")
    void updateLiked(String name);


}
