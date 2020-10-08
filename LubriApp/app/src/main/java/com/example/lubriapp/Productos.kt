package com.example.lubriapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle as Bundle1
import android.widget.GridView

class Productos : AppCompatActivity() {

    private var gridView: GridView? = null
    private var arrayList:ArrayList<Languageitem> ? = null
    private var lanugaeAdapter:LanugaeAdapter ? = null


    override fun onCreate(savedInstanceState: Bundle1?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        gridView = findViewById(R.id.my_grid_view)
        arrayList = ArrayList()
        lanugaeAdapter = LanugaeAdapter(applicationContext , arrayList!!)
        gridView?.adapter = lanugaeAdapter
    }

    private fun setDataList() : ArrayList<Languageitem> {

        var arrayList:ArrayList<Languageitem> = ArrayList()

        arrayList.add(Languageitem(R.drawable.cicon ,"esmalte"))
        arrayList.add(Languageitem(R.drawable.cicon ,"pasta"))
        arrayList.add(Languageitem(R.drawable.cicon ,"pino"))
        arrayList.add(Languageitem(R.drawable.cicon ,"refri molax"))
        arrayList.add(Languageitem(R.drawable.cicon ,"syntium"))

        /*
        arrayList.add(Languageitem(R.drawable.cicon , name: "syntium"))
        arrayList.add(Languageitem(R.drawable.cicon , name: "esmalte"))
        arrayList.add(Languageitem(R.drawable.cicon , name: "pasta"))
        arrayList.add(Languageitem(R.drawable.cicon , name: "pino"))
        arrayList.add(Languageitem(R.drawable.cicon , name: "refri molax"))
      */


        return arrayList

    }
}