package com.example.businessly;

public class OrdersDataModal
{
    private int sno;
    private String item;
    private int price;
    private int quantity;
    private int quantity2;      //qty selected by the customer
    public OrdersDataModal() {
        // empty constructor required for firebase.

    }
//    public int getSno() {
//        return sno;
//    }
//    public void setSno(int sno) {
//        this.sno=sno;
//    }

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

//    public int getQuantity() {
//        return quantity;
//    }
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public int getQuantity2(){return quantity2;}
    public void setQuantity2(int quantity2){this.quantity2=quantity2;}
}
