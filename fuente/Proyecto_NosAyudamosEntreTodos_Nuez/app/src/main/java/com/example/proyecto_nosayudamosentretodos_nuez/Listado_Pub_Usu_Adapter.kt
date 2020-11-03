package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.articulo_listado_simple.view.*

class Listado_Pub_Usu_Adapter (val mContext: Context, val listPublicaciones:List<Articulo>): ArrayAdapter<Articulo>(mContext, 0, listPublicaciones){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.articulo_listado_simple,parent,false)

        val publicacion = listPublicaciones[position]
        val id_pub_imagen = publicacion.id
        layout.lbl_titulo_lsv_simple.text= publicacion.titulo
        layout.lbl_localidad_lsv_simple.text= publicacion.localidad
        //layout.imageView_lsv_simple.setImageResource(publicacion.imagen)
        if (id_pub_imagen == 1) {
            layout.imageView_lsv_simple.setImageResource(R.drawable.imagen_heladera_app)
        }
        if (id_pub_imagen == 2) {
            layout.imageView_lsv_simple.setImageResource(R.drawable.cocina_imagen_app)
        }
        if (id_pub_imagen == 3) {
            layout.imageView_lsv_simple.setImageResource(R.drawable.imagen_heladera_app)
        }
        if (id_pub_imagen == 4) {
            layout.imageView_lsv_simple.setImageResource(R.drawable.imagen_cama_app)
        }
        if (id_pub_imagen == 5) {
            layout.imageView_lsv_simple.setImageResource(R.drawable.imagen_tv2_app)
        }


        return layout

    }



}