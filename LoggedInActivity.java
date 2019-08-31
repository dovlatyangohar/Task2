package com.example.javasharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.javasharedpref.MainActivity.KEY_PASSWORD;
import static com.example.javasharedpref.MainActivity.KEY_USERNAME;

public class LoggedInActivity extends AppCompatActivity {
    SharedPreferences prf;
    Intent intent;
    public static final String KEY_DETAILS = "User details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        prf = getSharedPreferences(KEY_DETAILS, MODE_PRIVATE);
        intent = new Intent(LoggedInActivity.this, MainActivity.class);
        if (prf.contains(KEY_USERNAME) && prf.contains(KEY_PASSWORD)) {
            startActivity(intent);
        }


    }
    public void logOut(View view){
        SharedPreferences.Editor editor = prf.edit();
        editor.clear();
        editor.commit();
        startActivity(intent);
    }
}
