package com.example.javasharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    SharedPreferences pref;
    Intent intent;
    public static final String USER_PREF = "USER_PREF";
    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_PASSWORD = "KEY_PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username_edit);
        passwordEditText = findViewById(R.id.password_edit);

        pref = getSharedPreferences(USER_PREF, MODE_PRIVATE);
        intent = new Intent(MainActivity.this, LoggedInActivity.class);

    }

    public void logIn(View view) {

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (username != "" && password != "") {
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(KEY_USERNAME, username);
            editor.putString(KEY_PASSWORD, password);
            editor.commit();
            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else Toast.makeText(getApplicationContext(),"Make sure to fill blank",Toast.LENGTH_SHORT).show();

    }
}
