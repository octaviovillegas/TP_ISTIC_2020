package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class ListaDeServicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_servicios)


    }

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
    }
}