package com.example.ferretexapp.Client.ApiConsulta.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.ferretexapp.Client.ApiConsulta.model.Clima
import com.example.ferretexapp.R

class adaptadorClima (var contexto: Context, listado: ArrayList<Clima>) : BaseAdapter() {
    var listado:ArrayList<Clima>?=null
    init {
        this.listado=listado
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //  TODO("Not yet implemented")
        var holder :ViewHolder?=null
        var vista: View?=convertView
        if(vista==null)
        {
            vista= LayoutInflater.from(contexto).inflate(R.layout.filacondatos, null)
            holder =ViewHolder(vista)
            vista.tag=holder
        }
        else
        {
            holder=vista.tag as? ViewHolder
        }
        val unClima=getItem(position)as Clima


        holder?.name?.text = unClima.name
        holder?.lat?.text = unClima.lat
        holder?.long?.text = unClima.long
        holder?.temp?.text = unClima.temp


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
        var name : TextView? = null
        var lat: TextView? = null
        var long: TextView? = null
        var temp: TextView? = null
        init {
            name = vista.findViewById(R.id.txtTimezone)
            lat = vista.findViewById(R.id.txtLat)
            long = vista.findViewById(R.id.txtLong)
            temp = vista.findViewById(R.id.txtTemp)
            //poster = vista.findViewById(R.id.imgBandera)
        }
    }


}