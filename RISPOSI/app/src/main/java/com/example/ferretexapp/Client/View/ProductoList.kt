package com.example.ferretexapp.Client.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.Client.Controller.ProductoActivity
import com.example.ferretexapp.Client.Models.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_producto_list.*

class ProductoList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_list)

        val producto = Producto("Tornillos", 100.0, "Tornillos de cabeza hexagonal", R.drawable.tornillos)
        val producto2 = Producto("Tester", 2500.0, "Multimetro", R.drawable.tester)
        val listaProducto = listOf(producto, producto2)
        val adapter = ProductoAdapter(this, listaProducto)
        listElementos.adapter = adapter

        //Ahora agregamos para que al seleccionar la imagen pasemos a otra pantalla con detalles

        listElementos.setOnItemClickListener() { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProducto[position])
            startActivity(intent)
        }
    }
}
