package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cambios.*

class  Cambios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambios)

        BtnServicios.setOnClickListener {
            val intento = Intent()
            
        }

        BtnProx.setOnClickListener {
            val intent = Intent(this, ListaDeServicios::class.java)
            startActivity(intent)
        }
    }
}