package com.example.businessly;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

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

//public class OrdersLVAdapter extends AppCompatActivity {
//
//    public OrdersLVAdapter(FragmentActivity activity, ArrayList<OrdersDataModal> ordersDataArrayList) {
//
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_orders_l_v_adapter);
//    }
//}

public class OrdersLVAdapter extends ArrayAdapter<OrdersDataModal> {
    // constructor for our list view adapter.
    private Context context;
    private List<OrdersDataModal> list;

    public OrdersLVAdapter(@NonNull Context context, ArrayList<OrdersDataModal> OrdersDataModaLArrayList)
    {
        super(context, 0, OrdersDataModaLArrayList);
        this.context = context;
        list = OrdersDataModaLArrayList;
    }

    public OrdersLVAdapter(@NonNull Context context, int resource) {
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
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_orders_l_v_adapter, parent,false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        OrdersDataModal dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView item = listitemView.findViewById(R.id.txtItem);
        TextView price = listitemView.findViewById(R.id.txtPrice);
        TextView quantity = listitemView.findViewById(R.id.txtQty);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        item.setText(dataModal.getItem());
        price.setText("40");
        quantity.setText(String.valueOf(dataModal.getQuantity2()));
//        price.setText(String.valueOf(dataModal.getPrice()));
//        quantity.setText(String.valueOf(dataModal.getQuantity()));

        // in below line we are using Picasso to
        // load image from URL in our Image VIew.

        // below line is use to add item click listener
        // for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + dataModal.getItem(), Toast.LENGTH_SHORT).show();
            }
        });

        return listitemView;
    }

}