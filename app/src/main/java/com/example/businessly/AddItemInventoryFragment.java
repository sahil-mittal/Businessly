package com.example.businessly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddItemInventoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddItemInventoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseReference db;
    EditText itemName, itemPrice, itemQuantity;
    InventoryDataModal dataModal;
    public AddItemInventoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddItemInventoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddItemInventoryFragment newInstance(String param1, String param2) {
        AddItemInventoryFragment fragment = new AddItemInventoryFragment();
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
        Bundle args = getArguments();
        View rootView = inflater.inflate(R.layout.fragment_add_item_inventory, container, false);
        db = FirebaseDatabase.getInstance().getReference();
        dataModal = new InventoryDataModal();
        itemName = rootView.findViewById(R.id.txtItemName);
        itemPrice = rootView.findViewById(R.id.txtItemPrice);
        itemQuantity = rootView.findViewById(R.id.txtItemQty);


        Button saveBtn = rootView.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                dataModal.setItem(itemName.getText().toString().trim());
                dataModal.setPrice(Integer.parseInt(itemPrice.getText().toString()));
                dataModal.setQuantity((Integer.parseInt(itemQuantity.getText().toString())));
                db.child("InventoryData").push().setValue(dataModal);
                Toast.makeText(getContext(), "Item added successfully", Toast.LENGTH_SHORT).show();
                // getActivity().getFragmentManager().popBackStack();
                // TODO: Close the current fragment
            }
        });
        return rootView;
    }
}