package com.example.ferretexapp.Infraestructure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.Infraestructure.Controller.ProductosAdapter
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_prinpal.*
import java.util.Observer

class Principal : AppCompatActivity() {

    private var listaProductos = emptyList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getDatabase(this)

        db.productosDao().getAll().observe(this, Observer {
            listaProductos = it
            val adapter = ProductosAdapter(this, listaProductos)

            lista.adapter = adapter
        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }

        add_fab.setOnClickListener{
            val intent = Intent(this, NuevoProductoActivity::class.java)
            startActivity(intent)
        }
    }

}
