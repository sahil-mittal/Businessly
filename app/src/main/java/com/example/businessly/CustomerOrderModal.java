package com.example.businessly;

public class CustomerOrderModal {



    private int sno;
    private String item;
    private int price;
    private int quantity2;      //qty selected by the customer
    public CustomerOrderModal() {
        // empty constructor required for firebase.

    }
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno=sno;
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item){
        this.item=item;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity2(int i){return quantity2;}
    public void setQuantity2(int quantity2){this.quantity2=quantity2;}
}
