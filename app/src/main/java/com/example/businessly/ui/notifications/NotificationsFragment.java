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

package com.example.businessly.ui.notifications;
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
import com.example.businessly.OrdersDataModal;
import com.example.businessly.OrdersLVAdapter;
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

public class NotificationsFragment extends Fragment {

    // creating a variable for our list view,
    // arraylist and firebase Firestore.
    ListView ordersLV;/***/
    OrdersLVAdapter ordersLVAdapter;
    ArrayList<OrdersDataModal> ordersDataArrayList;
    DatabaseReference db;
    OrdersDataModal ordersDataModal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        ordersDataArrayList = new ArrayList<OrdersDataModal>();

        View rootView =  inflater.inflate(R.layout.fragment_notifications, container, false);
        ordersLV = rootView.findViewById(R.id.idLVOrders);
        db = FirebaseDatabase.getInstance().getReference();
        //FloatingActionButton addToCartButton = rootView.findViewById(R.id.btnProceed);//

        //ordersLV = new OrdersLVAdapter(getActivity(), ordersDataArrayList);

        if (savedInstanceState == null) {
            loadDataInListView();
        }

        ordersLV.setAdapter(ordersLVAdapter);
//
       /* addToCartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (isNetworkAvailable()){
                    Intent searchIntent = new Intent(getActivity(), OrdersLVAdapter.class);
                    startActivity(searchIntent);
                }
                else {
                    Toast.makeText(getContext(), "No Connection!\nCheck your Internet Connection", Toast.LENGTH_LONG).show();
                }
            }

        });*/
//
        return rootView;
    }


    private void loadDataInListView()
    {
        // below line is use to get data from Firebase
        // firestore using collection in android.

        db.child("OrdersData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onCancelled(DatabaseError DatabaseError) {
                Log.w("LogFragment", "loadLog:onCancelled", DatabaseError.toException());
            }

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ordersDataArrayList.clear();

                for(DataSnapshot inventorySnapshot : dataSnapshot.getChildren()){
                    ordersDataArrayList.add(inventorySnapshot.getValue(OrdersDataModal.class));
                }
                ordersLVAdapter.notifyDataSetChanged();
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
