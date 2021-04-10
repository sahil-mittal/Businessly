package com.example.businessly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.businessly.ui.inventory.InventoryFragment;

public class InventoryDatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "INVENTORY";

    // Table columns
    public static final String SNO = "sno";
    public static final String ITEM = "item";
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantity";

    // Database Information
    static final String DB_NAME = "INVENTORY.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + SNO
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM + " TEXT NOT NULL, " + PRICE + " INTEGER, "+QUANTITY+" INTEGER);";

    public InventoryDatabaseHelper(InventoryFragment context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}