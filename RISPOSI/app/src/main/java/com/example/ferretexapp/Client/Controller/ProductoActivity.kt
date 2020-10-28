package com.example.ferretexapp.Client.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.Client.Models.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.getSerializableExtra("producto") as Producto
        txtNameProduct.text=producto.nombre
        txtDescripcionProducto.text=producto.descripcion
        txtPrecioProducto.text=producto.precio.toString()
        imageView2.setImageResource(producto.imagen)

    }
}
