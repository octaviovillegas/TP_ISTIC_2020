package com.example.ferretexapp.Client.Historial.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ferretexapp.Client.Historial.model.Historial
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_historial.*
import kotlinx.android.synthetic.main.activity_producto.*

class HistorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val productoHistorial = intent.getSerializableExtra("productoHistorial") as Historial
        txtNameProductHistoric.text=productoHistorial.nombre
        txtDescripcionProductoHistoric.text=productoHistorial.descripcion
        txtPrecioProductoHistoric.text=productoHistorial.precio.toString()
        imageViewHistoric.setImageResource(productoHistorial.imagen)
    }
}

