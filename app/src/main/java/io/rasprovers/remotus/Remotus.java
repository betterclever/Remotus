package io.rasprovers.remotus;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by betterclever on 3/24/2017.
 */

public class Remotus extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
