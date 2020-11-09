package com.example.food_locator

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.food_locator.AppDatabase.transdb.C_EMAIL
import com.example.food_locator.AppDatabase.transdb.C_FNAME
import com.example.food_locator.AppDatabase.transdb.C_INFO
import com.example.food_locator.AppDatabase.transdb.C_LOC
import com.example.food_locator.AppDatabase.transdb.C_MON
import com.example.food_locator.AppDatabase.transdb.C_NAME
import com.example.food_locator.AppDatabase.transdb.C_PASSWORD
import com.example.food_locator.AppDatabase.transdb.C_TYPE_food
import com.example.food_locator.AppDatabase.transdb.C_URI
import com.example.food_locator.AppDatabase.transdb.TABLE_LOGIN
import com.example.food_locator.AppDatabase.transdb.TABLE_NAME
import com.example.food_locator.AppDatabase.transdb.Table_pic
import com.example.food_locator.AppDatabase.transdb.abc


import java.lang.Exception



class AppDatabase:SQLiteOpenHelper  {

object transdb{
    val DB_NAME = "DataOfApp"
    val TABLE_NAME = "nombre"
    val Table_pic ="PIC"
    val PIC_NAME ="pname"
    val PIC_URI = "puri"
    val TABLE_LOGIN = "login"
    val C_NAME = "Name"
    val C_EMAIL = "EmailId"
    val C_PASSWORD = "Password"
    val C_MON = "mno"
    val C_FNAME = "name"
    val C_TYPE_food = "foodType"
    val C_INFO = "foodInfo"
    val C_LOC = "location"
    val C_URI = "Puri"
    var abc:ArrayList<String> = arrayListOf()
}
    var fA:Activity?=null
    override fun onCreate(sqliteDatabase: SQLiteDatabase?) {
        sqliteDatabase?.execSQL("CREATE TABLE "+ transdb.TABLE_NAME +"( "+transdb.C_TYPE_food+" STRING,"+
                transdb.C_INFO + " STRING,"+transdb.C_LOC+" STRING,"+ transdb.C_URI + " STRING,"+transdb.C_FNAME+" STRING);")


        sqliteDatabase?.execSQL("CREATE TABLE "+ transdb.TABLE_LOGIN +"( "+transdb.C_NAME+" STRING,"+
                transdb.C_EMAIL + " STRING,"+transdb.C_PASSWORD+" STRING,"+ transdb.C_MON + " STRING);")


        sqliteDatabase?.execSQL("CREATE TABLE "+ transdb.Table_pic+"( "+transdb.PIC_NAME+" STRING,"+transdb.PIC_URI+" STRING);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : super(
        context,
        name,
        factory,
        version
    )


    fun queryLogin(na: String,pas: String){
        val db = this.readableDatabase
        var rvalue = false
        try {
            val query = "SELECT * FROM "+ transdb.TABLE_LOGIN
            var cSor = db.rawQuery(query,null)
            if (cSor.moveToFirst()){
                    rvalue = false
                do {
                    var _n = cSor.getString(cSor.getColumnIndexOrThrow(transdb.C_NAME))
                    var _p = cSor.getString(cSor.getColumnIndexOrThrow(transdb.C_PASSWORD))
                    if(_n.equals(na,true)&&_p.equals(pas)){
                    rvalue = true
                    Datahelper.car.foodHname = _n
                    }
                }while (cSor.moveToNext())
            }else{
               rvalue = false
            }
            cSor.close()
        }catch (e:Exception){
            e.printStackTrace()
        }
        Datahelper.car.testtry = rvalue
//        _name.equals(na,true)&&_pass.equals(pas)

    }

    fun qfun(){
        val db = this.readableDatabase
        val query = "SELECT * FROM " + AppDatabase.transdb.TABLE_NAME
        var csor = db.rawQuery(query,null)
        Datahelper.car.Huri.clear()
        Datahelper.car.Hname.clear()
        Datahelper.car.Hinfo.clear()
        Datahelper.car.Htype.clear()
        var pnts = 0
        Datahelper.car.pnts =0
        if (csor.moveToFirst()){
            do{
                var _type = csor.getString(csor.getColumnIndexOrThrow(AppDatabase.transdb.C_TYPE_food))
                var _info = csor.getString(csor.getColumnIndexOrThrow(AppDatabase.transdb.C_INFO))
                var _uri = csor.getString(csor.getColumnIndexOrThrow(AppDatabase.transdb.C_URI))
                var _loc = csor.getString(csor.getColumnIndexOrThrow(AppDatabase.transdb.C_LOC))
                var _name = csor.getString(csor.getColumnIndexOrThrow(AppDatabase.transdb.C_FNAME))
             //   Datahelper.car.ttr = _type
                Datahelper.car.Htype.add(_type)
                Datahelper.car.Hinfo.add(_info)
                Datahelper.car.Hname.add(_name)
                Datahelper.car.Hloc.add(_loc)
                Datahelper.car.Huri.add(_uri)
                if(Datahelper.car.foodHname.equals(_name)){
                    pnts = pnts+10
                }
            }while(csor.moveToNext())
        Datahelper.car.pnts = pnts

        }
        csor.close()
    }
    fun qpic(){
        val db = this.readableDatabase
        val query = "SELECT * FROM "+ AppDatabase.transdb.Table_pic+" WHERE pname = '${Datahelper.car.foodHname}'"
        var csor = db.rawQuery(query,null)
       Datahelper.car.ttr ="false1"
        if (csor.moveToFirst()){
            Datahelper.car.ttr = "false2"
            do{
                var _name = csor.getString(csor.getColumnIndexOrThrow(AppDatabase.transdb.PIC_NAME))
                var _uri = csor.getString(csor.getColumnIndexOrThrow(AppDatabase.transdb.PIC_URI))
                Datahelper.car.picuri = _uri
                Datahelper.car.ttr = "true"
            }while (csor.moveToNext())
        }else{
            Datahelper.car.ttr = "false3"
        }
    }
       fun storeDetails(name: String?,email: String?,pass: String?,mno: String?){
           val db = this.writableDatabase
           var contentValues = ContentValues()
           contentValues.put(transdb.C_NAME,name)
           contentValues.put(transdb.C_EMAIL,email)
           contentValues.put(transdb.C_PASSWORD,pass)
           contentValues.put(transdb.C_MON,mno)
           db.insert(TABLE_LOGIN,null,contentValues)
     //      Datahelper.car.testtry = "abcde"
       }

    fun storeData(typefoodData: String?,infoData: String?,locData: String?,UriData: String?,nameData: String?){
        val db = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(transdb.C_TYPE_food,typefoodData)
        contentValues.put(transdb.C_INFO,infoData)
        contentValues.put(transdb.C_LOC,locData)
        contentValues.put(transdb.C_URI,UriData)
        contentValues.put(transdb.C_FNAME,nameData)
        db.insert(TABLE_NAME,null,contentValues)
  //  Datahelper.car.testtry = "abcde"
    }
    fun storePic(name : String?,uri : String?){
        val db = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(transdb.PIC_NAME,name)
        contentValues.put(transdb.PIC_URI,uri)
        db.insert(transdb.Table_pic,null,contentValues)
        Datahelper.car.ttr = "true2"
    }
    fun updateData(typefoodData: String?, infoData: String?, locData: String?, UriData: String?, nameData: String?):Long
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(transdb.C_TYPE_food,typefoodData)
        values.put(transdb.C_INFO,infoData)
        values.put(transdb.C_LOC,locData)
        values.put(transdb.C_URI,UriData)
        values.put(transdb.C_FNAME,nameData)

        return db.update(transdb.TABLE_NAME, values, "${transdb.C_FNAME}=?",arrayOf(nameData)).toLong()


    }



fun storePics(na :String?,ur :String?){
    val db = this.writableDatabase
    var conval = ContentValues()
    conval.put(transdb.PIC_NAME,na)
    conval.put(transdb.PIC_URI,ur)
    db.insert(transdb.Table_pic, null,conval)
}


    }

