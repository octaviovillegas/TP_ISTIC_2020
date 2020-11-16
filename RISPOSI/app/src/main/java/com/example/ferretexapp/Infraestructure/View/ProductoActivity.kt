package com.example.ferretexapp.Infraestructure.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_producto2.*

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto2)

        val producto = intent.getSerializableExtra("producto") as Producto

        nombre_producto.text = producto.nombre
        precio_producto.text = "$${producto.precio}"
        detalles_producto.text = producto.descripcion



    }
}

