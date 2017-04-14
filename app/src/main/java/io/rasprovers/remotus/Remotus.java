package io.rasprovers.remotus;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.database.FirebaseDatabase;

import io.rasprovers.remotus.services.ExampleBackgroundService;

/**
 * Created by betterclever on 3/24/2017.
 */

public class Remotus extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    
        Intent intent = new Intent(this, ExampleBackgroundService.class);
        startService(intent);
    }
}
