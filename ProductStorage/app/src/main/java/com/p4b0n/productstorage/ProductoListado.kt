package com.p4b0n.productstorage

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.p4b0n.http_apis.ConsultaDatos
import kotlinx.android.synthetic.main.activity_producto_listado.*
import org.json.JSONObject

class ProductoListado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_listado)

        //Declaro listado donde se muestra la consulta obtenida
        val lsvPelicula = findViewById<ListView>(R.id.LsvProducto)

        //Traigo el dato de la actividad anterior para saber que boton selecciono
        val clave = intent.getStringExtra("clave")
        Toast.makeText(this, "Selecciono:  $clave", Toast.LENGTH_SHORT).show()

        val datos = ConsultaDatos.consultarDatos("https://api.themoviedb.org/3/movie/popular?api_key=44d0cfaf931127ae6456a322933ebdcc&language=en-US&page=1")

        //val arrayDenombreDePelis: ArrayList<String> = ArrayList()
        val arrayDeobjetosDePelis: ArrayList<Producto> = ArrayList()
        val datosJSONObject = JSONObject(datos)

        for (i in 0..100) {
            //Log.d("pelicula listado", datosJSONObject.getString("name"))
            arrayDeobjetosDePelis.add(
                Producto(
                    datosJSONObject.getJSONArray("results").getJSONObject(i).getString("title"),
                    datosJSONObject.getJSONArray("results").getJSONObject(i).getString("release_date"),
                    datosJSONObject.getJSONArray("results").getJSONObject(i).getString("original_language"),
                    datosJSONObject.getJSONArray("results").getJSONObject(i).getInt("popularity"),
                    datosJSONObject.getJSONArray("results").getJSONObject(i).getDouble("vote_average"),
                    datosJSONObject.getJSONArray("results").getJSONObject(i).getString("poster_path")

                )
            )

        }


        val adaptadorPelicula = ProductoAdaptadorLsv(this, arrayDeobjetosDePelis)
        lsvPelicula.adapter = adaptadorPelicula

        LsvProducto.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoDetalle::class.java)
            intent.putExtra("pelicula", arrayDeobjetosDePelis[position])
            startActivity(intent)
        }
    }
}
