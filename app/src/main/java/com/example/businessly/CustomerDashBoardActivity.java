package com.example.businessly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CustomerDashBoardActivity extends AppCompatActivity implements AddToCart {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dash_board);

        if(savedInstanceState==null)
        {
            Bundle args = new Bundle();
//            if (getIntent().getParcelableExtra("MOVIE")== null)
//                Log.v("not ok", "intent is null");
//            else
//                Log.v("ok", "intent is not null");
            // args.putParcelable(SearchFragment.MOVIE_DETAIL,(getIntent().getParcelableExtra("MOVIE")));
            CustomerListViewFragment fragment = new CustomerListViewFragment();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_customer, fragment).commit();
        }
    }

    @Override
    public void onAddToCart(ArrayList<String> addedItems) {
        Intent intent = new Intent(this, CartActivity.class);
        intent.putExtra("CART", addedItems);
        startActivity(intent);
    }
}