package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad_menu.*
import kotlinx.android.synthetic.main.activity_actividad_preguntas.*

class ActividadPreguntas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_preguntas)
        btnAtras6.setOnClickListener {
            val intent: Intent = Intent(this, ActividadMenu ::class.java)
            startActivity(intent)
            finish()
        }
    }
}