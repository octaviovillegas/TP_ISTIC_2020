package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listado.*

class Listado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)
        val busqueda=findViewById<SearchView>(R.id.busqueda) as SearchView
        val item=Item("Lazzie","",R.drawable.perro)
        val item2=Item("Homero","",R.drawable.terrier)
        val item3=Item("Lucky","",R.drawable.golden)
        val item4=Item("Acqua","",R.drawable.siberiano)
        val listaItems=listOf(item,item2,item3,item4)
       val adapter=ItemAdapter(this,android.R.layout.simple_list_item_1
       ,listaItems
       )
        lista.adapter= adapter
        lista.setOnItemClickListener(
                { parent, view, position, id ->
                    val intent = Intent(this, ItemActivity::class.java)
                    intent.putExtra("item", listaItems[position])
                    startActivity(intent)
                }
        )
        busqueda.setOnQueryTextListener(object :SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                busqueda.clearFocus()
                if (listaItems.contains(p0)){
                    adapter.filter.filter(p0)
                }else{
                    Toast.makeText(applicationContext,"no se encuentra en la lista",Toast.LENGTH_LONG).show()
                }

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })
    }
}


