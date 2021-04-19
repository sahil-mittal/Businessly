

package com.example.businessly.ui.notifications;
/*
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.businessly.CartModal;
import com.example.businessly.OrdersDataModal;
//import com.example.businessly.OrdersLVAdapter;
import com.google.firebase.database.DataSnapshot;
import com.example.businessly.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    // creating a variable for our list view,
    // arraylist and firebase Firestore.
    ListView ordersLV;
    //OrdersLVAdapter ordersLVAdapter;
    ArrayList<OrdersDataModal> ordersDataArrayList;
    DatabaseReference db;
    OrdersDataModal ordersDataModal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        //ordersDataArrayList = new ArrayList<OrdersDataModal>();

        View rootView =  inflater.inflate(R.layout.fragment_notifications, container, false);
        //ordersLV = rootView.findViewById(R.id.idLVOrders);
        //db = FirebaseDatabase.getInstance().getReference();
        //FloatingActionButton addToCartButton = rootView.findViewById(R.id.btnProceed);//

        //ordersLV = new OrdersLVAdapter(getActivity(), ordersDataArrayList);

        if (savedInstanceState == null) {
            loadDataInListView();
        }

        ordersLV.setAdapter(ordersLVAdapter);

        return rootView;
    }


    private void loadDataInListView()
    {
        // below line is use to get data from Firebase
        // firestore using collection in android.

        db.child("Orders").addValueEventListener(new ValueEventListener() {
            @Override
            public void onCancelled(DatabaseError DatabaseError) {
                Log.w("LogFragment", "loadLog:onCancelled", DatabaseError.toException());
            }

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //ordersDataArrayList.clear();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    ordersDataArrayList.add(snapshot.getValue(OrdersDataModal.class));
                    String cemail=snapshot.child("Orders").child("cemail").getValue(String.class);
                    //String itemsAll=snapshot.child("items").getValue(String.class);
                    ArrayList<String> itemsNames = new ArrayList<>();
                    for(DataSnapshot itm:dataSnapshot.child("items").getChildren())
                    {
                        itemsNames.add(itm.child("items").getValue(String.class));
                    }

                    //CartModal cartModal=new CartModal();

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
*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.businessly.R;
import com.example.businessly.ui.home.HomeViewModel;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notification);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
