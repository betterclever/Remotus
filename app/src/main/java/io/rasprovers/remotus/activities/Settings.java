package io.rasprovers.remotus.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

        final ProgressDialog progressdialog = new ProgressDialog(this,ProgressDialog.THEME_HOLO_DARK);
        progressdialog.setMessage("Please Wait....");
        progressdialog.setTitle("Registering You & Saving Your Data... ");
        progressdialog.setCancelable(false);
        progressdialog.show();


        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("Password",((TextView) findViewById(R.id.password)).getText()+"");
        editor.putString("host",((TextView) findViewById(R.id.host)).getText()+"");
        editor.commit();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(mAuth.getCurrentUser().getEmail()
                , ((TextView) findViewById(R.id.password)).getText()+"").addOnCompleteListener
                (new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(Settings.this, "Settings saved!!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Settings.this, MainActivity.class));
                finish();
                progressdialog.hide();
                progressdialog.dismiss();
            }});




    }
}
