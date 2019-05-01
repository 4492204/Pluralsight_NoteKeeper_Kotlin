package com.example.nootkeeper_kotlin;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.google.android.material.snackbar.Snackbar;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;
import static com.example.nootkeeper_kotlin.ConstantsKt.*;

public class MySettingsFragment extends PreferenceFragmentCompat {

    private EditTextPreference mUserName;
    private EditTextPreference mUserEmail;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference, rootKey);
        mUserName = (EditTextPreference) findPreference("username");
        mUserEmail = (EditTextPreference) findPreference("userEmail");

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String userName = mSharedPreferences.getString("username", KEY_DEFAULT_USER_NAME);
        String userEmail = mSharedPreferences.getString("userEmail", KEY_DEFAULT_USER_EMAIL);

        mUserName.setSummary(userName);
        mUserEmail.setSummary(userEmail);

        mUserName.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                mUserName.setSummary(newValue.toString());
                return true;
            }
        });

        mUserEmail.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                mUserEmail.setSummary(newValue.toString());
                return true;
            }
        });
    }

}
