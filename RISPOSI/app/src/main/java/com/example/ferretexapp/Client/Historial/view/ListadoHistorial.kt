package com.example.ferretexapp.Client.Historial.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.Client.Historial.controller.HistorialActivity
import com.example.ferretexapp.Client.Historial.controller.ProductoAdapter
import com.example.ferretexapp.Client.Historial.model.Historial
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_listado_historial.*

class ListadoHistorial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_historial)


        val productoHistorial = Historial("Tornillos", 100.0, "Tornillos de cabeza hexagonal", R.drawable.tornillos)
        val productoHistorial2 = Historial("Tester", 2500.0, "Multimetro", R.drawable.tester)
        val listaProductoHistorial = listOf(productoHistorial, productoHistorial2)
        val adapter = ProductoAdapter(this, listaProductoHistorial)
        listElementosHistorial.adapter = adapter

        //Ahora agregamos para que al seleccionar la imagen pasemos a otra pantalla con detalles

        listElementosHistorial.setOnItemClickListener() { parent, view, position, id ->
            val intentHistorial = Intent(this, HistorialActivity::class.java)
            intentHistorial.putExtra("productoHistorial", listaProductoHistorial[position])
            startActivity(intentHistorial)

        }
    }
}

