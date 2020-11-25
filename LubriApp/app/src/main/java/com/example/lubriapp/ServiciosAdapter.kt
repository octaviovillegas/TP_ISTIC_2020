package com.example.lubriapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_producto.view.*
import kotlinx.android.synthetic.main.item_servicio.view.*
import java.text.FieldPosition

class ServiciosAdapter (private val mContext: Context,private val listaServicios: List<Servicio>) : ArrayAdapter<Servicio>(mContext,0,listaServicios) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_servicio, parent, false)

        val servicio = listaServicios[position]

        layout.nombre.text = servicio.nombre
        layout.fecha.text = servicio.fecha
        layout.patente.text = servicio.patente
        layout.servicio.text = servicio.servicio
        layout.celular.text = servicio.celular.toString()

        return layout


    }
}
