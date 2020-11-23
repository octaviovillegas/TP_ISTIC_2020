package com.example.ferretexapp.Client.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import com.example.ferretexapp.TiempoEspera
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {

    //Firebase
    //=================================================================
    private lateinit var database: DatabaseReference// ...
    private lateinit var postReference: DatabaseReference
    private lateinit var postKey: String
    private var postListener: ValueEventListener? = null
    //=================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)


        val producto = intent.getSerializableExtra("producto") as Producto

        txtNameProduct.text=producto.nombre
        txtDescripcionProducto.text=producto.descripcion
        txtPrecioProducto.text=producto.precio.toString()
        imageView2.setImageResource(producto.imagen)


        //==========================================================================
        //Firebase Guardado

        postReference = FirebaseDatabase.getInstance().reference
            .child("Historial de Compra")

        val btnComprarProducto = findViewById<Button>(R.id.btnComprarProducto)
        btnComprarProducto.setOnClickListener {
            database = FirebaseDatabase.getInstance().reference
            val key = database.child("Historial de Compra").push().key
            if (key == null) {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
            val post = Post(producto.nombre,producto.precio.toString(),producto.descripcion)
            val postValues = post.toMap()
            val childUpdates = HashMap<String, Any>()
            //childUpdates["/Clima/$timezone/$temp/$key"] = postValues
            childUpdates["/Historial_Producto/${producto.nombre}"] = postValues
            database.updateChildren(childUpdates)

            val intent = Intent(this, TiempoEspera::class.java)
            startActivity(intent)
        }

    }
    // [START post_class]
    @IgnoreExtraProperties
    data class Post(
        var nombre: String? = "",
        var precio: String? = "",
        var descripcion: String? = ""
        //var temp: String? = ""
        //var starCount: Int = 0,
        //var stars: MutableMap<String, Boolean> = HashMap()
    ) {

        // [START post_to_map]
        @Exclude
        fun toMap(): Map<String, Any?> {
            return mapOf(
                "Nombre" to nombre,
                "Precio" to precio,
                "Descripcion" to descripcion
                //"Temperatura" to temp
                //"destino" to destino,
                //"mensaje" to mensaje
            )
        }

    }
}
