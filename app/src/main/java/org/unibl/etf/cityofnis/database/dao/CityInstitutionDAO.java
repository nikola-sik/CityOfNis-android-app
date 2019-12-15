package org.unibl.etf.cityofnis.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import org.unibl.etf.cityofnis.dto.CityInstitution;

import java.util.List;

@Dao
public interface CityInstitutionDAO {

    @Query("SELECT * FROM cityinstitution")
    List<CityInstitution> getAll();

    @Query("SELECT * FROM cityinstitution where nameEn like :name")
    CityInstitution getAllByNameEn(String name);

    @Query("SELECT * FROM cityinstitution where favourite like :like")
    List<CityInstitution> getAllLiked(boolean like);

    @Insert
    void insertAll(List<CityInstitution> cityInstitutionItems);

    @Insert
    void insert(CityInstitution cityInstitutionItem);

    @Delete
    void delete(CityInstitution cityInstitutionItem);

    @Query("DELETE FROM cityinstitution")
    void deleteAll();

    @Update
    void update(CityInstitution cityInstitutionItem);

    @Query("UPDATE cityinstitution SET favourite=0 WHERE nameEn like :name")
    void updateLiked(String name);
}
