package com.example.food_locator

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

class navigationAdapter(_contentList: ArrayList<String>,_getImages : IntArray,_context : Context)
    : RecyclerView.Adapter<navigationAdapter.navViewHolder>(){
    var contentList:ArrayList<String>?=null
    var getImages: IntArray?=null
    var mcontext: Context?=null
    init {
        this.contentList = _contentList
        this.getImages=_getImages
        this.mcontext = _context
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): navViewHolder {
        var itemView = LayoutInflater.from(p0?.context)
            .inflate(R.layout.row_coustom_layout,p0,false)
        val rthis = navViewHolder(itemView)
        return  rthis
    }

    override fun getItemCount(): Int {
        return contentList?.size as Int
    }

    override fun onBindViewHolder(p0: navViewHolder, p1: Int) {
        p0.icon_get?.setBackgroundResource(getImages?.get(p1) as Int)
        p0.text_get?.setText(contentList?.get(p1))
        p0.ContentHolder?.setOnClickListener({
            if(p1 == 0){
                var intent: Intent?=null
                intent = Intent(mcontext,AboutUsActivity::class.java)
                startActivity(mcontext as Context,intent,null)
            }
            if(p1==1){
                var intent: Intent?=null
                intent = Intent(mcontext,LoginActivity::class.java)
                startActivity(mcontext as Context,intent,null)
                Datahelper.car.foodHname = "null"
                val mActivitym:Activity?=null
                val loginprf = mActivitym?.getSharedPreferences(MainActivity.sta.LOGIN_PRFS,Context.MODE_PRIVATE)?.edit()
                loginprf?.putBoolean("feature",false)
                loginprf?.apply()
            }
            MainActivity.sta.drawerLayout?.closeDrawers()
        })
    }

    class navViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icon_get : ImageView?=null
        var text_get : TextView?=null
        var ContentHolder : RelativeLayout?=null
        init {
            icon_get = itemView?.findViewById(R.id.icon_navdrawer)
            text_get = itemView?.findViewById(R.id.text_navdrawer)
            ContentHolder = itemView?.findViewById(R.id.navdrawer_item_content_holder)
        }
    }
}