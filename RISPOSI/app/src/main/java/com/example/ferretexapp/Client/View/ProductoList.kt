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
        val producto2 = Producto("Tester", 2500.0, "Multimetro chino", R.drawable.tester)
        val producto3 = Producto("Destornillador", 170.0, "Destornillador tipo philliphs", R.drawable.destornillador)
        val producto4 = Producto("Llave Alem", 80.0, "LLave alem de cabeza hexagonal 2.5 pulgadas", R.drawable.llavealem)
        val producto5 = Producto("martillo", 200.0,"Martillo de marca Adeco", R.drawable.martillo)
        val producto6 = Producto ("Tester Fluke",580.0, "Tester Fluke con todas las funciones", R.drawable.testerfluke)

        val listaProducto = listOf(producto, producto2, producto3, producto4, producto5, producto6)
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
