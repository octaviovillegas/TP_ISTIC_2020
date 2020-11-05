package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_listado.*

class Listado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)
        val item=Item("Lazzie","Sin desparacitar",R.drawable.perro)
        val item2=Item("Homero","Darle medicamento Lun-Mierc-Viernes 1 por dia durante 3 semanas",R.drawable.terrier)
        val item3=Item("Lucky","Llevar al veterinario 10/11 a las 11hs",R.drawable.golden)
        val item4=Item("Acqua","Coordinar con paseador para empezar una rutina",R.drawable.siberiano)
        val listaItems=listOf(item,item2,item3,item4)
       val adapter=ItemAdapter(this,listaItems)
        lista.adapter= adapter
        lista.setOnItemClickListener { parent, view, position, id ->
            val intent= Intent(this,ItemActivity::class.java)
            intent.putExtra("item",listaItems[position])
            startActivity(intent)
        }
    }
}