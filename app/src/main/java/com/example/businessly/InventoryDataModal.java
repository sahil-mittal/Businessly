package com.example.businessly;

public class InventoryDataModal
{
    private int sno;
    private String item;
    private int price;
    private int quantity;

    public InventoryDataModal() {
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

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
