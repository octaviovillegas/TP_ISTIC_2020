package com.example.proyecto2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OkRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_registro)
        val btnOk : TextView =findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener {
            val intent: Intent = Intent(this, ActividadMenu ::class.java)
            startActivity(intent)
            finish()
        }
    }
}