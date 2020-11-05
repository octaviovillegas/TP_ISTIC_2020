package com.example.tp_istic_2020

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_actividad_gps.*
import kotlinx.android.synthetic.main.activity_actividad_menu.*

class ActividadGps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_gps)
        lateinit var btnMapa:Button
        lateinit var EdtBuscar:EditText
        btnMapa=findViewById(R.id.btnMapa)
        EdtBuscar=findViewById(R.id.EdtBuscar)
        btnMapa.setOnClickListener{
            val UriIntent= Uri.parse("geo:0,0?q=${EdtBuscar.text.toString()}")
            val btnMapaIntent=Intent(Intent.ACTION_VIEW,UriIntent)
            btnMapaIntent.setPackage("com.google.android.apps.maps")
            startActivity(btnMapaIntent)

        }
        btn_volver_menu.setOnClickListener {
            val intent: Intent = Intent(this, ActividadMenu ::class.java)
            startActivity(intent)
            finish()
        }

    }
}