package com.example.businessly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomerLVAdapter extends ArrayAdapter<InventoryDataModal> {
    // constructor for our list view adapter.
    private Context context;
    private List<InventoryDataModal> list;
    private EditText qty2;
    ArrayList<String> customerOderArrayList;

    public CustomerLVAdapter(@NonNull Context context, ArrayList<InventoryDataModal> InventoryDataModalArrayList)
    {
        super(context, 0, InventoryDataModalArrayList);
        this.context = context;
        list = InventoryDataModalArrayList;
        customerOderArrayList=new ArrayList<String>();
        notifyDataSetChanged();
    }

    public CustomerLVAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;

        if (listitemView == null) {

            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.customer_lv, parent,false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        InventoryDataModal dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView item = listitemView.findViewById(R.id.txtItem1);
        TextView price = listitemView.findViewById(R.id.txtPrice1);
        Button addItemBtn = listitemView.findViewById(R.id.addBtn);
        //EditText quantity2=(EditText) listitemView.findViewById(R.id.EdittxtQty1);
        //String quantity = quantity2.getText().toString();

        //TextView quantity = listitemView.findViewById(R.id.txtQty1);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        item.setText(dataModal.getItem());
        price.setText(dataModal.getPrice()+"");


        // in below line we are using Picasso to
        // load image from URL in our Image VIew.

        // below line is use to add item click listener
        // for our item of list view.
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + dataModal.getItem(), Toast.LENGTH_SHORT).show();
                /*AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new Fragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.idaddTocart, myFragment).addToBackStack(null).commit();*/
                customerOderArrayList.add(dataModal.getItem());

                Toast.makeText(getContext(), "No. of Items in cart: " + customerOderArrayList.size(), Toast.LENGTH_SHORT).show();
            }

        });

        return listitemView;
    }

    public ArrayList<String> getCustomerOderArrayList() {
        return customerOderArrayList;
    }
    //CheckBox ch=(CheckBox)findViewById(R.id.checkBox);
    /*public boolean onCheckboxClicked(View view) {

        // Is the view now checked?
        boolean check=false;
        boolean checked = ((CheckBox) view).isChecked();
        if(checked)
        {
            if(Integer.parseInt(qty2.getText().toString())>0)
            {
                check= true;
            }

        }
        return check;
    }*/

}