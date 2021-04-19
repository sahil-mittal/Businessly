package com.example.businessly;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/*
public class CartAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_adapter);
    }
}*/
public class CartAdapter extends ArrayAdapter<String> {
    // constructor for our list view adapter.
    private Context context;
    private List<String> list;
    private CartActivity cartActivity;
    public CartAdapter(@NonNull Context context, ArrayList<String> ItemsList)
    {
        super(context, 0, ItemsList);
        this.context = context;
        list = ItemsList;
    }

    public CartAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            //listitemView = LayoutInflater.from(getContext()).inflate(R.layout.inventory_lv_item, parent, false);
            //listitemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_inventory, parent, false);
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_cart_adapter, parent,false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        //**//InventoryDataModal dataModal = getItem(position);

        ArrayList<String> items = cartActivity.getCartItems();
        String itemName = items.get(position);
        // initializing our UI components of list view item.
        TextView item = listitemView.findViewById(R.id.txtItemCart);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        //**//item.setText(dataModal.getItem());
        //price.setText("40");
        //**//quantity.setText(String.valueOf(dataModal.getQuantity()));

        item.setText(itemName);

        // in below line we are using Picasso to
        // load image from URL in our Image VIew.

        // below line is use to add item click listener
        // for our item of list view.


        return listitemView;
    }

}