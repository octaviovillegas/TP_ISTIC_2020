package com.example.food_locator

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.Toast
import java.util.*


class FeedsActivity : AppCompatActivity() {



    var iconList: IntArray = intArrayOf(R.drawable.navigation_aboutus, R.drawable.logout)
    var naviconList: ArrayList<String> = arrayListOf()
    //var recibeFood: Button? = null
    var dbfood: AppDatabase = AppDatabase(this, "nombre", null, 1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeds)
        var name = Datahelper.car.Hname

//        Datahelper.car.Htype = naviconList
//        Datahelper.car.Hinfo = naviconList
//        Datahelper.car.Hname = naviconList
//        Datahelper.car.Huri = naviconList


        dbfood.qfun()

        Collections.reverse(Datahelper.car.Hinfo)
        Collections.reverse(Datahelper.car.Htype)
        Collections.reverse(Datahelper.car.Huri)
        Collections.reverse(Datahelper.car.Hname)
        Collections.reverse(Datahelper.car.Hloc)
        var adpt = FeedsAdapter(
            Datahelper.car.Hname,
            Datahelper.car.Hinfo,
            Datahelper.car.Htype,
            Datahelper.car.Huri,
            Datahelper.car.Hloc
        )
        adpt.notifyDataSetChanged()

        //Toast.makeText(this@FeedsActivity,Datahelper.car.ttr,Toast.LENGTH_SHORT).show()
        var recycle = findViewById<RecyclerView>(R.id.feedsRecycle)
        recycle?.layoutManager = LinearLayoutManager(this)
        recycle?.itemAnimator = DefaultItemAnimator()
        recycle?.adapter = adpt

       // recibeFood = findViewById(R.id.btn_recibirdonacion)
       // recibeFood?.setOnClickListener {
           // var intent1: Intent? = null
          //  intent = Intent(this@FeedsActivity, SucessActivity::class.java)
           // ContextCompat.startActivity(intent1)

      //  }

    }
}


