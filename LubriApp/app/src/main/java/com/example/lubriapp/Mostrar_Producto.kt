package com.example.lubriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_productos.*

/* PANTALLA INACTIVA E INSERVIBLE
class Mostrar_Producto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val producto = Producto(
            "Crema limpia manos",
            "Marca molax, contiene 1 kilo",
            200,
            12,
            R.drawable.crema
        )
        val producto2 = Producto(
            "Esmalte sintético negro",
            "Marca molax, contiene 300 cc",
            120,
            5,
            R.drawable.esmalte
        )
        val producto3 = Producto(
            "Limpia inyectores",
            "Marca molax, contiene 500 cc",
            350,
            10,
            R.drawable.limpiainyectores
        )
        val producto4 = Producto(
            "Aceite para motores Petronas syntium",
            "Marca Petronas, semisintético",
            700,
            13,
            R.drawable.petronas
        )
        val producto5 = Producto(
            "Líquido refrigerante concentrado",
            "Marca molax, contiene 1 litro",
            500,
            8,
            R.drawable.refri
        )
        val producto6 = Producto(
            "Líquido par afrenos",
            "Marca Bardhal, contiene 1 litro",
            1100,
            6,
            R.drawable.liquidofrenos
        )

        val listaProductos = listOf(producto, producto2, producto3, producto4, producto5, producto6)

        val adapter = ProductosAdapter(this, listaProductos)

        lista.adapter = adapter

    }
}
*/