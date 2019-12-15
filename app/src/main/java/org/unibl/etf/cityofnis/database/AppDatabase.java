package org.unibl.etf.cityofnis.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import org.unibl.etf.cityofnis.database.dao.AdventureDAO;
import org.unibl.etf.cityofnis.database.dao.AttractionDAO;
import org.unibl.etf.cityofnis.database.dao.CityInstitutionDAO;
import org.unibl.etf.cityofnis.database.dao.EventDAO;
import org.unibl.etf.cityofnis.database.dao.HotelDAO;
import org.unibl.etf.cityofnis.database.dao.LikedDAO;
import org.unibl.etf.cityofnis.database.dao.MuseumDAO;
import org.unibl.etf.cityofnis.database.dao.NewsDAO;
import org.unibl.etf.cityofnis.database.dao.RestaurantDAO;
import org.unibl.etf.cityofnis.dto.Adventure;
import org.unibl.etf.cityofnis.dto.Attraction;
import org.unibl.etf.cityofnis.dto.CityInstitution;
import org.unibl.etf.cityofnis.dto.Event;
import org.unibl.etf.cityofnis.dto.Hotel;
import org.unibl.etf.cityofnis.dto.Liked;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.dto.News;
import org.unibl.etf.cityofnis.dto.Restaurant;

import java.util.concurrent.Executors;

@Database(entities = {News.class,Museum.class,Attraction.class, Liked.class, CityInstitution.class, Hotel.class, Event.class,Restaurant.class, Adventure.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase INSTANCE;
    public abstract NewsDAO newsDAO();
    public abstract CityInstitutionDAO cityInstitutionDAO();
    public abstract AttractionDAO attractionDAO();
    public abstract MuseumDAO museumDAO();
    public abstract HotelDAO hotelDAO();
    public abstract LikedDAO likedDAO();
    public abstract EventDAO eventDAO();
    public abstract RestaurantDAO restaurantDAO();
    public abstract AdventureDAO adventureDAO();
    public static AppDatabase getAppDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (AppDatabase.class){INSTANCE =

                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "cityofnis").addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    getAppDatabase(context).cityInstitutionDAO().insertAll(CityInstitution.insertCityInstitutionData());
                                    getAppDatabase(context).museumDAO().insertAll(Museum.insertMuseumData());
                                    getAppDatabase(context).attractionDAO().insertAll(Attraction.insertAttractionData());
                                    getAppDatabase(context).hotelDAO().insertAll(Hotel.insertHotelData());
                                    getAppDatabase(context).restaurantDAO().insertAll(Restaurant.insertRestaurantData());
                                    getAppDatabase(context).eventDAO().insertAll(Event.insertEventData());
                                    getAppDatabase(context).adventureDAO().insertAll(Adventure.insertAdventureData());

                                }
                            });
                        }
                    }).allowMainThreadQueries()
                            .build();

            }}
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }



}
