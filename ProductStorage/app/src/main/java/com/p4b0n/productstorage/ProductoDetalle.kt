package com.p4b0n.productstorage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_producto_detalle.*


class ProductoDetalle : AppCompatActivity() {

    private lateinit var database: DatabaseReference// ...
    private lateinit var postReference: DatabaseReference
    private lateinit var postKey: String
    private var postListener: ValueEventListener? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_detalle)

        val unaPelicula = intent.getSerializableExtra("pelicula") as Producto

        val urlPoster = "https://image.tmdb.org/t/p/original${unaPelicula.imagenpeli}"

        txtNombrePeliculaDet.text = "Nombre: " + unaPelicula.nombre
        txtLanzamiento.text = "Fecha lanzamiento: " + unaPelicula.lanzamiento
        txtLenguaje.text = "Idioma: " + unaPelicula.lenguaje
        txtPublico.text = "Espectadores: " + unaPelicula.publico.toString()
        txtPuntaje.text = "Valoracion: " + unaPelicula.puntaje.toString()
        Picasso.get().load(urlPoster).into(imgPeli)

        postReference = FirebaseDatabase.getInstance().reference
     .child("Producto")

     val btnGuardarPelicula = findViewById<Button>(R.id.btnGuardarPelicula)
     btnGuardarPelicula.setOnClickListener {
         // [START initialize_database_ref]
         database = FirebaseDatabase.getInstance().reference
         // [END initialize_database_ref]
         val key = database.child("Producto").push().key
         if (key == null) {
             // Log.w("error", "Couldn't get push key for posts")
             Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
         }


         val post = Post(unaPelicula.nombre, unaPelicula.lanzamiento, unaPelicula.lenguaje, unaPelicula.publico, unaPelicula.puntaje, unaPelicula.imagenpeli)
         val postValues = post.toMap()
         val childUpdates = HashMap<String, Any>()
         childUpdates["/Producto/${unaPelicula.nombre}/$key"] = postValues
         database.updateChildren(childUpdates)

         val intent = Intent(this@ProductoDetalle, ProductoListado::class.java)
         startActivity(intent)

         Toast.makeText(this, "Producto agregado a favoritos satisfactoriamente", Toast.LENGTH_LONG).show()
     }

    }
    // [START post_class]
    @IgnoreExtraProperties
    data class Post(
     var NombreDet: String? = "",
     var LanzamientoDet: String? = "",
     var LenguajeDet: String? = "",
     var PublicoDet: Int? = 0,
     var PuntajeDet: Double? = 0.0,
     var Imagen: String? = ""

    ) {

     // [START post_to_map]
     @Exclude
     fun toMap(): Map<String, Any?> {
         return mapOf(
             "Nombre" to NombreDet,
             "Lanzamiento" to LanzamientoDet,
             "Lenguaje" to LenguajeDet,
             "Espectadores" to PublicoDet,
             "Puntaje" to PuntajeDet,
             "Imagen" to Imagen
         )
     }

    }
}