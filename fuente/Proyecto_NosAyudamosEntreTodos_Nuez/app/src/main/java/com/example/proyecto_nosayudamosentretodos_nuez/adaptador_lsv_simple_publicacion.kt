package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class adaptador_lsv_simple_publicacion (var contexto: Context, listado:ArrayList<Articulo>) : BaseAdapter() {

    var listado:ArrayList<Articulo>?=null
    init {
        this.listado=listado
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //  TODO("Not yet implemented")
        var holder :ViewHolder?=null
        var vista: View?=convertView
        if(vista==null)
        {
            vista= LayoutInflater.from(contexto).inflate(R.layout.articulo_listado_simple,null)
            holder =ViewHolder(vista)
            vista.tag=holder
        }
        else
        {
            holder=vista.tag as? ViewHolder
        }
        val unArticulo=getItem(position) as Articulo

        holder?.titulo?.text=unArticulo.titulo
        holder?.categoria?.text=unArticulo.categoria
        holder?.tipo?.text=unArticulo.tipo
        holder?.descripcion?.text=unArticulo.descripcion
        holder?.localidad?.text=unArticulo.localidad
        holder?.codiPos?.text=unArticulo.codiPos
        holder?.telefono?.text=unArticulo.telefono


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
        var titulo: TextView?=null
        var categoria: TextView?=null
        var tipo: TextView?=null
        var descripcion: TextView?=null
        var localidad: TextView?=null
        var codiPos: TextView?=null
        var telefono: TextView?=null
        init {
            titulo=vista.findViewById(R.id.lbl_tituño_pub)
            categoria=vista.findViewById(R.id.lbl_categoria_pub)
            tipo=vista.findViewById(R.id.lbl_tipo_pub)
            descripcion=vista.findViewById(R.id.lbl_descripcion_pub)
            localidad=vista.findViewById(R.id.lbl_localidad_pub)
            codiPos=vista.findViewById(R.id.lbl_codpos_pub)
            telefono=vista.findViewById(R.id.lbl_telefono_pub)
        }
    }

}