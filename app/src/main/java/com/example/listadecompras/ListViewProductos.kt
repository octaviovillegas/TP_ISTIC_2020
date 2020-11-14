package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.listadecompras.Adapters.AdapterProductList
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.TAG
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.ToastMessage
import com.example.listadecompras.DataModels.Product
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ListViewProductos : AppCompatActivity() {

    private lateinit var lstProductView: ListView
    private var auth: FirebaseAuth? = null
    private var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        auth = FirebaseAuth.getInstance()
        user = auth?.currentUser

        val arrayProducts: ArrayList<Product> = intent.getSerializableExtra("arrayProducts") as ArrayList<Product>

        lstProductView = findViewById(R.id.list_view_lstProductos)

        //ToastMessage("${arrayProducts}",this)
        //Log.d("arrayProducts", arrayProducts.toString())
        //var arrayProducts: ArrayList<Product> = getProducts(user?.email)
        val adaptadorSimple = AdapterProductList(this, arrayProducts)
        lstProductView.adapter = adaptadorSimple


        lstProductView.setOnItemClickListener { parent, view, position, id ->
            var detalleProductIntent = Intent(this, DetalleProducto::class.java)
            detalleProductIntent.putExtra("detalleProducto", arrayProducts[position])
            startActivity(detalleProductIntent)
        }
    }
}