package com.example.businessly.ui.inventory;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.businessly.AddInventoryItemActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.example.businessly.InventoryLVAdapter;
import com.example.businessly.InventoryDataModal;
import com.example.businessly.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InventoryFragment extends Fragment {

    // creating a variable for our list view,
    // arraylist and firebase Firestore.
    ListView inventoryLV;
    InventoryLVAdapter inventoryLVAdapter;
    ArrayList<InventoryDataModal> inventoryDataArrayList;
    DatabaseReference db;

    EditText editItem;
    EditText editPrice;
    EditText editQty;
    Button btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inventoryDataArrayList = new ArrayList<InventoryDataModal>();

        View rootView =  inflater.inflate(R.layout.fragment_inventory, container, false);
        inventoryLV = rootView.findViewById(R.id.idLVInventory);
        db = FirebaseDatabase.getInstance().getReference();
        FloatingActionButton addItemButton = rootView.findViewById(R.id.addInventoryBtn);
        if (savedInstanceState == null) {
            loadDataInListView();
        }

        inventoryLVAdapter = new InventoryLVAdapter(getActivity(), inventoryDataArrayList);
        inventoryLV.setAdapter(inventoryLVAdapter);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetworkAvailable()){
                    Intent searchIntent = new Intent(getActivity(), AddInventoryItemActivity.class);
                    startActivity(searchIntent);
                }
                else {
                    Toast.makeText(getContext(), "No Connection!\nCheck your Internet Connection", Toast.LENGTH_LONG).show();
                }
            }

        });

        return rootView;
    }


    private void loadDataInListView()
    {
        // below line is use to get data from Firebase
        // firestore using collection in android.

        db.child("InventoryData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onCancelled(DatabaseError DatabaseError) {
                Log.w("LogFragment", "loadLog:onCancelled", DatabaseError.toException());
            }

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot inventorySnapshot : dataSnapshot.getChildren()){
                    inventoryDataArrayList.add(inventorySnapshot.getValue(InventoryDataModal.class));
                }
            }

        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
