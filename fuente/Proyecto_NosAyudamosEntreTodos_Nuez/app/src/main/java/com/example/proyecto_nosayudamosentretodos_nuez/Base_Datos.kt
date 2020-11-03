package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Base_Datos (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version){




    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, clave text,email text)")
        db.execSQL("create table MisArticulos(id INTEGER PRIMARY KEY AUTOINCREMENT,titulo text, categoria text, tipo text, descripcion text, localidad text, codipos text, telefono text  )")
        db.execSQL("create table PublicacionesUsuarios(id INTEGER PRIMARY KEY AUTOINCREMENT,titulo text, categoria text, tipo text, descripcion text, localidad text, codipos text, telefono text )")
        /*
        * INSERT INTO datetime_text (d1, d2) VALUES(datetime('now'),datetime('now', 'localtime'));
        */



        db.execSQL(" INSERT INTO PublicacionesUsuarios (titulo,categoria,tipo,descripcion,localidad,codipos,telefono) VALUES ('Heladera con Freezer','Electrodomesticos','Heladera','La heladera funciona muy bien tanto el freezer como la heladera, solo se rompio una pata trasera. Si alguien la necesita por favor contactarse','Temperley','1834','1563974129')" )
        db.execSQL(" INSERT INTO PublicacionesUsuarios (titulo,categoria,tipo,descripcion,localidad,codipos,telefono) VALUES ('Cocina Electroluz','Electrodomesticos','Cocina','La cocina se encuentra en exelentes condiciones, de color blanca. cualquier duda contactarse','Lomas de Zamora','1832','1574302981')" )
        db.execSQL(" INSERT INTO PublicacionesUsuarios (titulo,categoria,tipo,descripcion,localidad,codipos,telefono) VALUES ('Mesa de Madera','Muebles','Mesa','la mesa es de madera , mide 2.10 metros x 50cm , la mesa esta buena solo le faltaria darle una mano de barnis. contactarse a partir de las 18hs','Llavallol','1836','1522774568')" )
        db.execSQL(" INSERT INTO PublicacionesUsuarios (titulo,categoria,tipo,descripcion,localidad,codipos,telefono) VALUES ('Cama Cucheta','Muebles','Cama','Cama cucheta en buenas condiciones solo le falta la escalera. se entrega por falta de uso . quien la necesite contactarse a la brevedad ','Lanus','1838','1547856320')" )
        db.execSQL(" INSERT INTO PublicacionesUsuarios (titulo,categoria,tipo,descripcion,localidad,codipos,telefono) VALUES ('Televisor 29 pulgadas de tubo','TV y Video','Televisor','entrego TV de 29 pulgadas , funciona 10 puntos, cuenta con el control remoto. Contactarse despues de las 12 hs ','Monte Grande','1852','1579514382')" )
    }



    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

}