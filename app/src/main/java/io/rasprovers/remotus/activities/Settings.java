package io.rasprovers.remotus.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.rasprovers.remotus.R;

public class Settings extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "USER_SETTINGS" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);



    }

    public void save(View view) {
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("Password",((TextView) findViewById(R.id.password)).getText()+"");
        editor.putString("Eamil",((TextView) findViewById(R.id.email)).getText()+"");
        editor.putString("host",((TextView) findViewById(R.id.host)).getText()+"");
        editor.commit();

        Toast.makeText(Settings.this,"Settings saved!!",Toast.LENGTH_LONG).show();

        startActivity(new Intent(Settings.this, MainActivity.class));


    }
}
