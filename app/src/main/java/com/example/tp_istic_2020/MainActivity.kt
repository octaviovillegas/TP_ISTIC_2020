package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEntrar : Button =findViewById<Button>(R.id.btnEntrar)
        btnEntrar.setOnClickListener {
            val intent: Intent = Intent(this, ActividadLogin ::class.java)
            startActivity(intent)
            finish()
        }
    }
}