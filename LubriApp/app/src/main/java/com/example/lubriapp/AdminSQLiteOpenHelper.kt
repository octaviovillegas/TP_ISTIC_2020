package com.example.lubriapp

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table articulos(codigo int primary key, descripcion text, precio real)") //esta actividad tiene esta base de datos, que usa AltaServicios Prueba
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}