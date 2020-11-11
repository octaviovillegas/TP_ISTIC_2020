package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad_menu.*
import kotlinx.android.synthetic.main.activity_listado_inf.*
import kotlinx.android.synthetic.main.activity_menu_c_r_u_d.*

class menuCRUD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_c_r_u_d)
        btnAlta.setOnClickListener {
            val intent: Intent = Intent(this, altaInf ::class.java)
            startActivity(intent)
            finish()
        }

        btnLeer.setOnClickListener {
            val intent: Intent = Intent(this, listadoInf ::class.java)
            startActivity(intent)
            finish()
        }
        btnBorrar.setOnClickListener {
            val intent: Intent = Intent(this, borradoInf ::class.java)
            startActivity(intent)
            finish()
        }
        btnAtras5.setOnClickListener {
            val intent: Intent = Intent(this, ActividadMenu ::class.java)
            startActivity(intent)
            finish()
        }
        btnModificar.setOnClickListener {
            val intent: Intent = Intent(this, modificarInf ::class.java)
            startActivity(intent)
            finish()
        }
    }
}