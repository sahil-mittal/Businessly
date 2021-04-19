package com.example.businessly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<String> cartItems;
    private ListView listView;
    private CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        if (savedInstanceState == null){
            Bundle args = new Bundle();
            if (getIntent().getParcelableExtra("CART")== null)
                Log.v("not ok", "intent is null");
            else
                Log.v("ok", "intent is not null");
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            args.putParcelable(CartFragment.Cart_obj,(getIntent().getParcelableExtra("CART")));



            CartFragment fragment = new CartFragment();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.activityCartID, fragment).commit();
        }

    }

    public ArrayList<String> getCartItems()
    {
        return cartItems;
    }
}