/*package com.example.businessly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerListViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
/*
public class CustomerListViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomerListViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomerListViewFragment.
     */
/*
    // TODO: Rename and change types and number of parameters
    public static CustomerListViewFragment newInstance(String param1, String param2) {
        CustomerListViewFragment fragment = new CustomerListViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_list_view, container, false);
    }
}
*/

package com.example.businessly;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.businessly.AddInventoryItemActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

public class CustomerListViewFragment extends Fragment {

    // creating a variable for our list view,
    // arraylist and firebase Firestore.
    ListView inventoryLV;/***/
    CustomerLVAdapter customerLVAdapter;
    ArrayList<InventoryDataModal> inventoryDataArrayList;
    ArrayList<String> customerOderArrayList;

    DatabaseReference db;
    InventoryDataModal inventoryDataModal;
    public FirebaseAuth auth;
    public FirebaseUser currentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
        // Inflate the layout for this fragment
        inventoryDataArrayList = new ArrayList<InventoryDataModal>();

        View rootView =  inflater.inflate(R.layout.fragment_customer_list_view, container, false);
        inventoryLV = rootView.findViewById(R.id.idLVCustomers);
        db = FirebaseDatabase.getInstance().getReference();
        FloatingActionButton addToCartButton = rootView.findViewById(R.id.btnProceed);//

        customerLVAdapter = new CustomerLVAdapter(getActivity(), inventoryDataArrayList);

        if (savedInstanceState == null) {
            loadDataInListView();
        }

        inventoryLV.setAdapter(customerLVAdapter);
//

        addToCartButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                customerOderArrayList=customerLVAdapter.getCustomerOderArrayList();

                if (isNetworkAvailable()){

                    CartModal cartModal = new CartModal();
                    cartModal.setCemail(currentUser.getEmail());
                    cartModal.setItems(customerOderArrayList);
                    db.child("Orders").push().setValue(cartModal);
//                    Intent cartIntent = new Intent(getActivity(), CartActivity.class);
//                    startActivity(cartIntent);
                    Toast.makeText(getContext(), "Order placed successfully\nWill be delivered asap...", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getContext(), "No Connection!\nCheck your Internet Connection", Toast.LENGTH_LONG).show();
                }
            }

        });
//
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

                inventoryDataArrayList.clear();

                for(DataSnapshot inventorySnapshot : dataSnapshot.getChildren()){
                    inventoryDataArrayList.add(inventorySnapshot.getValue(InventoryDataModal.class));
                }
                customerLVAdapter.notifyDataSetChanged();
            }

        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /*private void saveDataToDB()
    {
        db.child("OrdersDB").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot customerSnapshot : snapshot.getChildren())
                {
                    //customerOderArrayList.add(snapshot.)
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/

}
