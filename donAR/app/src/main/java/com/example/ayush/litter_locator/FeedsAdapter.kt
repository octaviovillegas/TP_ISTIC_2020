package com.example.food_locator

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class FeedsAdapter(nameFeed:ArrayList<String>,infoFeed:ArrayList<String>,typeFeed:ArrayList<String>,iconFeed:ArrayList<String>,LocFeed:ArrayList<String>)
    :RecyclerView.Adapter<FeedsAdapter.FeeViewHolder>() {
    var nFeed:ArrayList<String>?=null
    var iFeed:ArrayList<String>?=null
    var tFeed:ArrayList<String>?=null
    var lFeed:ArrayList<String>?=null
    var pFeed:ArrayList<String>?=null
    init {
        this.nFeed = nameFeed
        this.iFeed = infoFeed
        this.pFeed = iconFeed
        this.tFeed = typeFeed
        this.lFeed = LocFeed
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FeeViewHolder {

        var itemView =   LayoutInflater.from(p0.context)
           .inflate(R.layout.feeds_adapter,p0,false)
            val rthis = FeeViewHolder(itemView)
        return rthis
         }

    override fun getItemCount(): Int {
        return tFeed?.size as Int
    }

    override fun onBindViewHolder(p0: FeeViewHolder, p1: Int) {
       var suri = Uri.parse(pFeed?.get(p1))
        p0.icon_get?.setImageURI(suri)
        p0.type_get?.setText(tFeed?.get(p1))
        p0.info_get?.setText(iFeed?.get(p1))
        p0.name_get?.setText(nFeed?.get(p1))
        p0.loc_get?.setText(lFeed?.get(p1))

           }

    class FeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icon_get:ImageView?=null
        var type_get:TextView?=null
        var name_get:TextView?=null
        var info_get:TextView?=null
        var loc_get:TextView?=null
        var container:RelativeLayout?=null
        init {
            icon_get = itemView.findViewById(R.id.feedpic)
            type_get = itemView.findViewById(R.id.feedType)
            name_get = itemView.findViewById(R.id.feedname)
            loc_get = itemView.findViewById(R.id.feedLoc)
            info_get = itemView.findViewById(R.id.feedinfo)
            container = itemView.findViewById(R.id.contenerHolder)
        }
    }
}