package com.example.lubriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.getSerializableExtra("producto") as Producto

        nombre_producto.text = producto.nombre
        precio_producto.text = "${producto.precio}"
        descripcion_producto.text = producto.descripcion
        stock_producto.text = producto.stock.toString()
        imagen.setImageResource(producto.imagen)  //muestro en detalle los datos del producto que recibo en la val desde Productos
    }
}