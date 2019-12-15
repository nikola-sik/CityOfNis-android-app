package org.unibl.etf.cityofnis.util;

import android.app.Application;
import android.content.Context;

import org.unibl.etf.cityofnis.database.AppDatabase;

public class AppController extends Application {


    private static AppController mInstance;
    public static Context context;
    public static AppDatabase appDatabase;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        this.context = this;
    }

    public static synchronized AppController getmInstance(){
        return mInstance;
    }



}
