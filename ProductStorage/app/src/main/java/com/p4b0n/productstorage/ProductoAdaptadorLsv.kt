package com.p4b0n.productstorage

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ProductoAdaptadorLsv (private var contexto: Context, listado:ArrayList<Producto>) : BaseAdapter(){

    private var listado:ArrayList<Producto>?=null
    init {
        this.listado=listado
    }

    @Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")
    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //  TODO("Not yet implemented")
        var holder :ViewHolder?=null
        var vista: View?=convertView
        if(vista==null)
        {
            vista= LayoutInflater.from(contexto).inflate(R.layout.activity_producto_fila,null)
            holder =ViewHolder(vista)
            vista.tag=holder
        }
        else
        {
            holder=vista.tag as? ViewHolder
        }
        val unaPelicula=getItem(position)as Producto


        holder?.nombre?.text=unaPelicula.nombre

        return vista!!
    }

    override fun getItem(position: Int): Any {
        //  TODO("Not yet implemented")
        return listado?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        //TODO("Not yet implemented")
        return  position.toLong()
    }

    override fun getCount(): Int {
        //TODO("Not yet implemented")
        return listado?.count()!!// para obtener el valor !!
    }
    private class ViewHolder(vista: View){
        var nombre : TextView?=null
        init {
            nombre=vista.findViewById(R.id.txtNombreProducto)
        }
    }
}