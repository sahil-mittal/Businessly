/*
package com.example.businessly;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.businessly.ui.inventory.InventoryFragment;

public class InventoryDBManager {

    private InventoryDatabaseHelper inventoryDatabaseHelper;

    private InventoryFragment context;

    private SQLiteDatabase database;

    public InventoryDBManager(InventoryFragment c) {
        context = c;
    }

    public InventoryDBManager open() throws SQLException {
        inventoryDatabaseHelper = new InventoryDatabaseHelper(context);
        database = inventoryDatabaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        inventoryDatabaseHelper.close();
    }

    public void insert(String itemName, Integer price, Integer quantity) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(InventoryDatabaseHelper.ITEM, itemName);
        contentValue.put(InventoryDatabaseHelper.PRICE, price);
        contentValue.put(InventoryDatabaseHelper.QUANTITY, quantity);
        database.insert(InventoryDatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { InventoryDatabaseHelper.SNO, InventoryDatabaseHelper.ITEM, InventoryDatabaseHelper.PRICE, InventoryDatabaseHelper.QUANTITY };
        Cursor cursor = database.query(InventoryDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(int sno, String itemName, int price, int qty) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryDatabaseHelper.SNO, sno);
        contentValues.put(InventoryDatabaseHelper.ITEM, itemName);
        contentValues.put(InventoryDatabaseHelper.PRICE, price);
        contentValues.put(InventoryDatabaseHelper.QUANTITY, qty);

        int i = database.update(InventoryDatabaseHelper.TABLE_NAME, contentValues, InventoryDatabaseHelper.SNO + " = " + sno, null);
        return i;
    }

    public void delete(int sno) {
        database.delete(InventoryDatabaseHelper.TABLE_NAME, InventoryDatabaseHelper.SNO + "=" + sno, null);
    }

}

*/