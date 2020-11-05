package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actividad_menu.*

class ActividadMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_menu)
        btnGps.setOnClickListener {
            val intent: Intent = Intent(this, ActividadGps ::class.java)
            startActivity(intent)
            finish()
    }
        btnListado.setOnClickListener {
            val intent: Intent = Intent(this, Listado ::class.java)
            startActivity(intent)
            finish()
        }
}
}