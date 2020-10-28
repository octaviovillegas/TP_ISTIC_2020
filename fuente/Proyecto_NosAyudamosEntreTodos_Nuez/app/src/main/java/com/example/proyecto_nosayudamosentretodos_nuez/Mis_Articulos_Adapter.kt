package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.articulo_listado_simple.view.*

class Mis_Articulos_Adapter(val mContext:Context,val listPublicaciones:List<Articulo>):ArrayAdapter<Articulo>(mContext, 0, listPublicaciones)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.articulo_listado_simple,parent,false)

        val publicacion = listPublicaciones[position]
        layout.lbl_titulo_lsv_simple.text= publicacion.titulo
        layout.lbl_localidad_lsv_simple.text= publicacion.localidad
        //layout.lbl_id_lsv_simple.text= publicacion.id.toString()
        //layout.imageView_publicacion.setImageResource(publicacion.imagen)


        return layout

    }
}
