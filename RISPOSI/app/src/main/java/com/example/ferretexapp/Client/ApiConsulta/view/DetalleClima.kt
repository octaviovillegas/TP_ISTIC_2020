package com.example.ferretexapp.Client.ApiConsulta.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.ferretexapp.Client.ApiConsulta.model.Clima
import com.example.ferretexapp.R
import com.example.ferretexapp.TiempoEspera
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detalle_clima.*
import kotlinx.android.synthetic.main.filacondatos.*
import kotlinx.android.synthetic.main.filacondatos.txtTimezone

class DetalleClima : AppCompatActivity() {

    //Firebase
    //=================================================================
    private lateinit var database: DatabaseReference// ...
    private lateinit var postReference: DatabaseReference
    private lateinit var postKey: String
    private var postListener: ValueEventListener? = null
    //=================================================================


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_clima)

        val clima = intent.getSerializableExtra("DetalleClima") as Clima
        txtTimezone.text = clima.name
        txtLat.text = clima.lat
        txtLong.text = clima.long
        txtTemp.text = clima.temp


        //==========================================================================
        //Firebase Guardado

        postReference = FirebaseDatabase.getInstance().reference
            .child("Clima")

        val btnGuardar = findViewById<Button>(R.id.btnGuardarClima)
        btnGuardar.setOnClickListener {
            database = FirebaseDatabase.getInstance().reference
            val key = database.child("Clima").push().key
            if (key == null) {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
            val post = Post(clima.name,clima.lat,clima.long,clima.temp)
            val postValues = post.toMap()
            val childUpdates = HashMap<String, Any>()
            //childUpdates["/Clima/$timezone/$temp/$key"] = postValues
            childUpdates["/Info_Clima/${clima.name}"] = postValues
            database.updateChildren(childUpdates)

            val intent = Intent(this@DetalleClima, TiempoEspera::class.java)
            startActivity(intent)
        }

    }
    // [START post_class]
    @IgnoreExtraProperties
    data class Post(
        var name: String? = "",
        var lat: String? = "",
        var long: String? = "",
        var temp: String? = ""
        //var starCount: Int = 0,
        //var stars: MutableMap<String, Boolean> = HashMap()
    ) {

        // [START post_to_map]
        @Exclude
        fun toMap(): Map<String, Any?> {
            return mapOf(
                "Nombre" to name,
                "Latitud" to lat,
                "Longitud" to long,
                "Temperatura" to temp
                //"destino" to destino,
                //"mensaje" to mensaje
            )
        }

    }
}