package com.example.ferretexapp.Client.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ferretexapp.Client.Models.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_producto.view.*
import kotlinx.android.synthetic.main.item_producto.view.*

//Clase Adaptador para que coloque la clase Producto en el listView
class ProductoAdapter(private val nContext: Context, private val listaProducto: List<Producto>) : ArrayAdapter<Producto>(nContext, 0, listaProducto){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(nContext).inflate(R.layout.item_producto,parent,false)
        val producto = listaProducto[position]
        layout.txtName.text = producto.nombre
        layout.txtPrice.text = producto.precio.toString()
        layout.imageView.setImageResource(producto.imagen)
        return layout
    }
}