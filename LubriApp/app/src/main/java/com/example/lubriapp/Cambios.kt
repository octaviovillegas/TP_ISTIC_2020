package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cambios.*

class  Cambios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambios)

        BtnProductos.setOnClickListener {
            val intento3 = Intent(this, Productos::class.java)
            startActivity(intento3)
        }

        BtnProxServices.setOnClickListener {
            val intento = Intent(this, ListaDeServicios::class.java)
            startActivity(intento)

        }

        BtnComandos.setOnClickListener {
            val intent = Intent(this, ABMServicios::class.java) //va a la activity que tiene el abl de turnos(servicios)
            startActivity(intent)
        }
    }
}