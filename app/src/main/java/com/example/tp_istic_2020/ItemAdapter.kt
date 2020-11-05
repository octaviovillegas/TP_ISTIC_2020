package com.example.tp_istic_2020

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item.view.*

class ItemAdapter(private val mContext: Context, private val listaItems: List<Item>) : ArrayAdapter<Item>(mContext,0,listaItems)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout=LayoutInflater.from(mContext).inflate(R.layout.item,parent,false)



        val item=listaItems[position]
        layout.nombre.text=item.nombre

        layout.imagen.setImageResource(item.imagen)
        return layout
    }
}