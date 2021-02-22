package com.example.parcial_julissa.datamodels

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.parcial_julissa.R


class AmigoAdapter(private val context: Context,
                   private val dataSource: ArrayList<Persona>
) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("WrongViewCast", "ViewHolder", "CutPasteId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.activity_amigos, parent, false)
        val titleTextView = rowView.findViewById(R.id.amigo_list_view) as TextView

        val subtitleTextView = rowView.findViewById(R.id.amigo_list_view) as TextView

        val amigo = getItem(position) as Persona

        titleTextView.text = amigo.nombre
        subtitleTextView.text = amigo.dni


        return rowView
    }

}