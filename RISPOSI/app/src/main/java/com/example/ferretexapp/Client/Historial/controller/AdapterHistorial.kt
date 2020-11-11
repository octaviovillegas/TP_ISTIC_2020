package com.example.ferretexapp.Client.Historial.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ferretexapp.Client.Historial.model.Historial
import com.example.ferretexapp.Client.Historial.view.ListadoHistorial
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.item_producto.view.*

class ProductoAdapter(private val nContext: Context, private val ListadoHistorial: List<Historial>) : ArrayAdapter<Historial>(nContext, 0, ListadoHistorial){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(nContext).inflate(R.layout.item_producto,parent,false)
        val producto = ListadoHistorial[position]
        layout.txtName.text = producto.nombre
        layout.txtPrice.text = producto.precio.toString()
        layout.imageView.setImageResource(producto.imagen)
        return layout
    }
}