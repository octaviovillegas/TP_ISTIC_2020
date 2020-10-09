package com.example.proyecto2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActividadRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_registro)
        val txtUsuario :TextView =findViewById<TextView>(R.id.txtUsuario)
        val txtClave :TextView =findViewById<TextView>(R.id.txtClave)
        val btnGuardar :Button =findViewById<Button>(R.id.btnGuardar)

    }
}