package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.listadecompras.Common_Functions.CommonFunctions
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.TAG
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.getUserProfile
import com.example.listadecompras.DataModels.Product
import com.example.listadecompras.DataModels.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class CargaProducto : AppCompatActivity() {

    private lateinit var carga_prod_name: EditText
    private lateinit var carga_prod_price: EditText
    private lateinit var carga_prod_brand: EditText
    private lateinit var carga_prod_cont_neto: EditText
    private lateinit var carga_prod_lugar_compra: EditText
    private lateinit var carga_prod_txt_count: EditText
    private var auth: FirebaseAuth? = null
    private var user: FirebaseUser? = null
    //private lateinit var carga_prod_img_photo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carga_producto)

        auth = FirebaseAuth.getInstance()

        carga_prod_name = findViewById(R.id.carga_prod_name)
        carga_prod_price = findViewById(R.id.carga_prod_price)
        carga_prod_brand = findViewById(R.id.carga_prod_brand)
        carga_prod_cont_neto = findViewById(R.id.carga_prod_cont_neto)
        carga_prod_lugar_compra = findViewById(R.id.carga_prod_lugar_compra)
        //carga_prod_img_photo = findViewById(R.id.carga_prod_img_photo)
        carga_prod_txt_count = findViewById(R.id.carga_prod_txt_count)
    }

    fun cargarProducto(view: View) {
        updateUI(auth?.currentUser)
        user = auth?.currentUser

        var name: String? = carga_prod_name.text.toString()
        var price: String? = carga_prod_price.text.toString()
        var brand: String? = carga_prod_brand.text.toString()
        var contNeto: String? = carga_prod_cont_neto.text.toString()
        var buyPlace: String? = carga_prod_lugar_compra.text.toString()
        //var photo: String? = carga_prod_img_photo.text.toString()
        var photo = null
        var count: Int = carga_prod_txt_count.text.toString().toInt()

        try {
            val dbRef = CommonFunctions.DBReference()
            val key = dbRef.child("listadoCompraPorUsers/${user?.uid}/").push().key
            val keyProductos = dbRef.child("productos").push().key
            val productObj = Product(name,price,photo,brand,contNeto,buyPlace,count,key)
            val postValues = productObj.toMap()
            val childUpdates = HashMap<String, Any>()
            childUpdates["/listadoCompraPorUsers/${user?.uid}/$key"] = postValues
            childUpdates["/productos/$key"] = postValues
            dbRef.updateChildren(childUpdates)
        }
        catch (ex: Throwable) {
            Log.d(TAG,"Error: ${ex.message}")
            CommonFunctions.ToastMessage("Error: ${ex.message}", this)
        }

        var newProduct = Product(name,price,photo,brand,contNeto,buyPlace,count)
        Log.d("product","${newProduct}")
        val arrayProductObjects: ArrayList<Product> = ArrayList()
        arrayProductObjects.add(newProduct)

        var productListIntent = Intent(this,ListViewProductos::class.java)
        productListIntent.putExtra("arrayProducts",arrayProductObjects)
        startActivity(productListIntent)
    }

    private fun updateUI(currentUser: FirebaseUser?){
        if (currentUser != null)
        {
            var user = auth?.currentUser
            user?.let {
                val name = user.displayName
                val email = user.email
                val uid = user.uid
            }
        }
    }
}