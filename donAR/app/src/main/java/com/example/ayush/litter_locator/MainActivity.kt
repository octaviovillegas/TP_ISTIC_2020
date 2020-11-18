package com.example.food_locator

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.Button

import com.example.food_locator.MainActivity.sta.drawerLayout

class MainActivity : AppCompatActivity() {
    var naviconList: ArrayList<String> = arrayListOf()
    var recibirFood: Button? = null
    var reportFood: Button? = null
    var pbtn: Button? = null
    var mActivity: Activity? = null
    var feeds: Button? = null

    object sta {
        var drawerLayout: DrawerLayout? = null
        var LOGIN_PRFS = "login feature"
    }

    var dbfood: AppDatabase = AppDatabase(this, "nombre", null, 1)
    var iconList: IntArray = intArrayOf(R.drawable.navigation_aboutus, R.drawable.logout)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loginpr = mActivity?.getSharedPreferences(sta.LOGIN_PRFS, Context.MODE_PRIVATE)?.edit()
        loginpr?.putBoolean("feature", true)
        loginpr?.apply()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)

        naviconList.add("Sobre Nosotros")
        naviconList.add("Salir")

        val toogle = ActionBarDrawerToggle(
            this@MainActivity, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout?.setDrawerListener(toogle)
        toogle.syncState()
        var navAdapter = navigationAdapter(naviconList, iconList, this@MainActivity)
        navAdapter.notifyDataSetChanged()

        var nav_dr_lay = findViewById<RecyclerView>(R.id.navigation_recycler_view)
        nav_dr_lay.layoutManager = LinearLayoutManager(this)
        nav_dr_lay.itemAnimator = DefaultItemAnimator()
        nav_dr_lay.adapter = navAdapter
        nav_dr_lay.setHasFixedSize(true)

        reportFood = findViewById(R.id.rFood)
        reportFood?.setOnClickListener({
            var intent: Intent? = null
            intent = Intent(this@MainActivity, Uploadfood::class.java)
            startActivity(intent)
        })
        feeds = findViewById(R.id.bFeeds)
        feeds?.setOnClickListener {
            var intent: Intent? = null
            intent = Intent(this@MainActivity, FeedsActivity::class.java)
            startActivity(intent)
//            dbfood.qfun()
//            Toast.makeText(this@MainActivity,Datahelper.car.ttr,Toast.LENGTH_LONG).show()
        }
        recibirFood = findViewById(R.id.btn_recibirdonacion)
        recibirFood?.setOnClickListener {
            var intent: Intent? = null
            intent = Intent(this@MainActivity, AceptarDona::class.java)
            startActivity(intent)
//            dbfood.qfun()
//            Toast.makeText(this@MainActivity,Datahelper.car.ttr,Toast.LENGTH_LONG).show()
        }



            pbtn = findViewById(R.id.pbtnms)
            pbtn?.setOnClickListener {
                var intent: Intent? = null
                intent = Intent(this@MainActivity, MyProfile::class.java)

                startActivity(intent)


            }
        }

        override fun onStart() {
            super.onStart()
        }
}
