package com.pauapps.pau.projectefoca;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WhatEat.db";

    public static final String TABLE_MEASURE = "measure";
    public static final String TABLE_MEASURE_ID = "measure_id";//int
    public static final String TABLE_MEASURE_NAME = "measure_name";//string
    public static final String TABLE_MEASURE_VALUE = "measure_value";//string

    public static final String TABLE_PRODUCTS = "products";
    public static final String TABLE_PRODUCTS_ID = "product_id";//int
    public static final String TABLE_PRODUCTS_NAME = "product_name";//string
    public static final String TABLE_PRODUCTS_MEASURE = "product_mesure";//FK measure_id
    public static final String TABLE_PRODUCTS_PRICE = "product_price"; //double

    public static final String TABLE_MEALS = "meals";
    public static final String TABLE_MEALS_ID = "meals_id";//int
    public static final String TABLE_MEALS_NAME = "meals_name";//string
    public static final String TABLE_MEALS_QUANTITY = "meals_quantity";//double
    public static final String TABLE_MEALS_DAY = "meals_day";//string

    public static final String TABLE_PRODUCTS_MEALS = "products_meals";
    public static final String TABLE_PRODUCTS_MEALS_PRODUCT = "products_meals_product";//FK product_id
    public static final String TABLE_PRODUCTS_MEALS_MEALS = "products_meals_meals";//FK meals_id

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table measures
        db.execSQL("CREATE TABLE " + TABLE_MEASURE +
                "( '" + TABLE_MEASURE_ID + "' INTEGER  PRIMARY KEY AUTOINCREMENT, "
                + TABLE_MEASURE_NAME + " TEXT NOT NULL, "
                + TABLE_MEASURE_VALUE + " TEXT NOT NULL);");

        //Create table products
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTS +
                "( '" + TABLE_PRODUCTS_ID + "' INTEGER  PRIMARY KEY AUTOINCREMENT, "
                + TABLE_PRODUCTS_NAME + " TEXT NOT NULL, "
                + TABLE_PRODUCTS_MEASURE + " INTEGER,"
                + TABLE_PRODUCTS_PRICE + " REAL,"
                + "FOREIGN KEY(" + TABLE_PRODUCTS_MEASURE + ") REFERENCES " + TABLE_MEASURE + "(" + TABLE_MEASURE_ID + "));");

        //Create table meals
        db.execSQL("CREATE TABLE " + TABLE_MEALS +
                "( '" + TABLE_MEALS_ID + "' INTEGER  PRIMARY KEY AUTOINCREMENT, "
                + TABLE_MEALS_NAME + " TEXT NOT NULL, "
                + TABLE_MEALS_QUANTITY + " REAL,"
                + TABLE_MEALS_DAY + " TEXT NOT NULL);");

        //Create table meals
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTS_MEALS +
                "( '" + TABLE_PRODUCTS_MEALS_PRODUCT + "' INTEGER NOT NULL,  "
                + TABLE_PRODUCTS_MEALS_MEALS + " INTEGER NOT NULL,  "
                + "FOREIGN KEY(" + TABLE_PRODUCTS_MEALS_PRODUCT + ") REFERENCES " + TABLE_PRODUCTS + "(" + TABLE_PRODUCTS_ID + "), "
                + "FOREIGN KEY(" + TABLE_PRODUCTS_MEALS_MEALS + ") REFERENCES " + TABLE_MEALS + "(" + TABLE_MEALS_ID + "));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEASURE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEALS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS_MEALS);
        onCreate(db);
    }

    public void select(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("SELECT * FROM "+TABLE_PRODUCTS+";");
    }
}
