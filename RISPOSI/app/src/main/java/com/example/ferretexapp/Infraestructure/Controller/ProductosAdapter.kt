package com.example.ferretexapp.Infraestructure.Controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R

class ProductosAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        val producto = listaProductos[position]

        layout.nombre.text = producto.nombre
        layout.precio.text = "US$${producto.precio}"

        return layout
    }

}