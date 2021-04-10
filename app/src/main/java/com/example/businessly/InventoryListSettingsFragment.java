package com.example.businessly;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class InventoryListSettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}