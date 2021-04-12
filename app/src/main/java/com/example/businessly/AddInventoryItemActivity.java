package com.example.businessly;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.businessly.AddItemInventoryFragment;

public class AddInventoryItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory_item);

        // Toolbar toolbar = findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        if(savedInstanceState==null)
        {
            Bundle args = new Bundle();
//            if (getIntent().getParcelableExtra("MOVIE")== null)
//                Log.v("not ok", "intent is null");
//            else
//                Log.v("ok", "intent is not null");
            // args.putParcelable(SearchFragment.MOVIE_DETAIL,(getIntent().getParcelableExtra("MOVIE")));
            AddItemInventoryFragment fragment = new AddItemInventoryFragment();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.addItemContainer, fragment).commit();
        }

    }
}