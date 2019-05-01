package com.example.nootkeeper_kotlin;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MySettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.setting_container, new MySettingsFragment())
                .commit();
    }


}