package com.example.lubriapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class LanugaeAdapter(var contex: Context , var arrayList: ArrayList<Languageitem> ) : BaseAdapter() {


    override fun getItem(position: Int) : Any {
       return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view:View = View.inflate(contex , R.layout.grid_item_list , root: null)

        var icons: ImageView = view.findViewById(R.id.icons)
        var names: TextView = view.findViewById(R.id.name_text_view)

        var languageitem: Languageitem = arrayList.get(position)

        icons.setImageResource(languageitem.icons!!)
        names.text = languageitem.name

        return view

    }
}