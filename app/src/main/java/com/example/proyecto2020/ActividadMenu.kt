package com.example.proyecto2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActividadMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_menu)
        val txtUsuario : TextView =findViewById<TextView>(R.id.txtUsuario)
        val txtClave :TextView =findViewById<TextView>(R.id.txtClave)
        val btnIngresar :Button =findViewById<Button>(R.id.btnIngresar)
        val btnRegistro :Button =findViewById<Button>(R.id.btnRegistro)
        val btnInvitado : Button =findViewById<Button>(R.id.btnInvitado)
        btnRegistro.setOnClickListener {
            val intent: Intent = Intent(this, ActividadRegistro ::class.java)
            startActivity(intent)
            finish()
        }
    }
}