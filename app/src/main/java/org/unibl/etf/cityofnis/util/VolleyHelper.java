package org.unibl.etf.cityofnis.util;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.toolbox.Volley;


public class VolleyHelper  {

    private static RequestQueue requestQueue;

    private static VolleyHelper volleyHelperInstance;
    private static Context context;



    public VolleyHelper(Context cont) {
        context=cont;
        getmRequestQueue();
    }

    public RequestQueue getmRequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized   VolleyHelper getVolleyHelperInstance(Context cont){
if(volleyHelperInstance==null){
    volleyHelperInstance=new VolleyHelper(cont);
}

return volleyHelperInstance;
    }

    public <T> void addToRequesQueue(Request<T> request){

        requestQueue.add(request);
    }

}
