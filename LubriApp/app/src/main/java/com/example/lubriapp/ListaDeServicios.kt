package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_productos.*

class ListaDeServicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_servicios)

        val servicio = Servicio("Luis", "10/09/2020", "ABT520", "cambio de aceite", 1135987410)
        val servicio2 = Servicio("Cristian","04/11/2020", "AD659AB", "alineacion y balanceo",1121325984)
        val servicio3 = Servicio("Gisela", "15/08/2020", "FDO125","cambio de aceite", 1145659812)

        val listaTurnos = listOf(servicio, servicio2, servicio3)

        val adapter = ServiciosAdapter(this,listaTurnos)

        lista.adapter = adapter
    }
/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item!!.itemId) {
            R.id.action_add -> {
                val intentAdd = Intent(applicationContext, AgregarTurno::class.java)
                startActivity(intentAdd)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }*/
}