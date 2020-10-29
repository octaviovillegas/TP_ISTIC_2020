package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.listadecompras.Adapters.AdapterProductList
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.ToastMessage
import com.example.listadecompras.DataModels.Product

class ListViewProductos : AppCompatActivity() {

    private lateinit var lstProductView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val arrayProducts: ArrayList<Product> = intent.getSerializableExtra("arrayProducts") as ArrayList<Product>

        lstProductView = findViewById(R.id.list_view_lstProductos)

        ToastMessage("${arrayProducts}",this)
        Log.w("arrayProducts", arrayProducts.toString())
        val adaptadorSimple = AdapterProductList(this, arrayProducts)
        lstProductView.adapter = adaptadorSimple


    }
}