package com.example.dinvercalculos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdaptadorLsvBitcoin (var contexto: Context, listado: ArrayList<ClaseBTC>) : BaseAdapter(){

    var listado:ArrayList<ClaseBTC>?=null
    init {
        this.listado=listado
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //  TODO("Not yet implemented")
        var holder :ViewHolder?=null
        var vista: View?=convertView
        if(vista==null)
        {
            vista= LayoutInflater.from(contexto).inflate(R.layout.datos_btc,null)
            holder =ViewHolder(vista)
            vista.tag=holder
        }
        else
        {
            holder=vista.tag as? ViewHolder
        }
        val unBTC =getItem(position)as ClaseBTC

        holder?.nombre?.text=unBTC.nombre
        holder?.simbolo?.text=unBTC.simbolo
        holder?.precio?.text=unBTC.precio.toString()


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
        var simbolo : TextView?=null
        var precio : TextView?=null

        init {
            nombre=vista.findViewById(R.id.txtNombreBTC)
            simbolo=vista.findViewById(R.id.txtSimboloBTC)
            precio=vista.findViewById(R.id.txtPrecioBTC)
        }
    }
}