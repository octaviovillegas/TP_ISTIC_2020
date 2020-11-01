package com.example.dinvercalculos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdaptadorLsvDollar(var contexto: Context, listado: ArrayList<ClaseDollar>) : BaseAdapter(){

    var listado:ArrayList<ClaseDollar>?=null
    init {
        this.listado=listado
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //  TODO("Not yet implemented")
        var holder :ViewHolder?=null
        var vista: View?=convertView
        if(vista==null)
        {
            vista= LayoutInflater.from(contexto).inflate(R.layout.datos_dollar,null)
            holder =ViewHolder(vista)
            vista.tag=holder
        }
        else
        {
            holder=vista.tag as? ViewHolder
        }
        val unDollar =getItem(position)as ClaseDollar

        holder?.nombre?.text=unDollar.nombre
        holder?.pVenta ?.text=unDollar.pVenta
        holder?.pCompra?.text=unDollar.pCompra
        holder?.pVariacion?.text=unDollar.pVariacion


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
        return listado?.count()!!// para optener el valor !!
    }
    private class ViewHolder(vista: View){
        var nombre : TextView?=null
        var pVenta : TextView?=null
        var pCompra : TextView?=null
        var pVariacion : TextView?=null

        init {
            nombre=vista.findViewById(R.id.txtNombreDollar)
            pVenta=vista.findViewById(R.id.txtCompraDollar)
            pCompra=vista.findViewById(R.id.txtVentaDollar)
            pVariacion=vista.findViewById(R.id.txtVariacionDollar)
        }
    }
}