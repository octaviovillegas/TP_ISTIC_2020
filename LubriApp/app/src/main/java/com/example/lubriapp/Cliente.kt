package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cliente.*

class Cliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        BtnProduc.setOnClickListener{
            val intento = Intent(this, Productos::class.java)
            startActivity(intento)
        }

        BtnServ.setOnClickListener{
            val intento = Intent(this, Servicios::class.java)
            startActivity(intento)
        }
    }
}