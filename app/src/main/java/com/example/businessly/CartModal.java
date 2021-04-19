package com.example.businessly;

import java.util.ArrayList;

public class CartModal {

    private String cemail;
    private  ArrayList<String>items;

    public CartModal() {
        // empty constructor required for firebase.

    }
    public String getCemail() {
        return cemail;
    }
    public void setCemail(String cemail) {
        this.cemail=cemail;
    }

    public ArrayList<String> getItems() {
        return items;
    }
    public void setItems(ArrayList<String>items){
        this.items=items;
    }
}
